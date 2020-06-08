package com.pourush.librarymanagmentsystem.dto;

import com.pourush.librarymanagmentsystem.constants.CommonConstants;
import com.pourush.librarymanagmentsystem.services.BookLending;
import com.pourush.librarymanagmentsystem.services.BookReservation;
import com.pourush.librarymanagmentsystem.services.Fine;
import lombok.Data;

import java.util.Date;

/**
 * Created by pourush.sinha on 23/03/19.
 */
@Data
public class Member extends Account {

    int memberId;
    private Date dateOfMembership;
    private int totalBooksCheckedout;
    public int getTotalBooksCheckedout(){
        return  10;
    }
    public boolean reserveBookItem(BookItem bookItem){
        return  false;
    }
    private void incrementTotalBooksCheckedout(){

    }



    public boolean checkoutBookItem(BookItem bookItem) throws Exception {
        if(this.getTotalBooksCheckedout() >= CommonConstants.MAX_BOOKS_ISSUED_TO_A_USER ) {
            throw new Exception("The user has already checkedout maximum number of books");
        }
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if( bookReservation != null &&  bookReservation.getMemberId() != this.getMemberId() ) {
            // book item has a pending reservation from another user
            throw new Exception("This book is reserved by another member");
        } else if( bookReservation != null ) {
            // book item has a pending reservation from the give member, update it
            bookReservation.updateStatus(CommonConstants.ReservationStatus.COMPLETED);
        }

        if(!bookItem.checkout(this.getId())) {
            return false;
        }

        this.incrementTotalBooksCheckedout();
        return true;
    }

    private void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date();
        // check if the book has been returned within the due date
        if(today.compareTo(dueDate) > 0) {
            long diff = new Date().getTime() - dueDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            Fine.collectFine(memberId, diffDays);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if(bookReservation != null) {
            // book item has a pendening reservation
            bookItem.updateBookItemStatus(CommonConstants.BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(CommonConstants.BookStatus.AVAILABLE);
    }

    public Boolean renewBookItem(BookItem bookItem) throws Exception {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if( bookReservation != null && bookReservation.getMemberId() != this.getMemberId() ) {
            // book item has a pendening reservation from another member
            decrementTotalBooksCheckedout();
            bookItem.updateBookItemStatus(CommonConstants.BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
            throw new Exception("This book is reserved by another member");
        } else if( bookReservation != null ){
            // book item has a pendening reservation from this member
            bookReservation.updateStatus(CommonConstants.ReservationStatus.COMPLETED);
        }
        BookLending.lendBook(bookItem.getBarcode(), this.getMemberId());
        //bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }
}
