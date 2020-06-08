package com.pourush.librarymanagmentsystem.dto;

import com.pourush.librarymanagmentsystem.constants.CommonConstants;
import com.pourush.librarymanagmentsystem.services.BookLending;
import lombok.Data;

import java.util.Date;

/**
 * Created by pourush.sinha on 23/03/19.
 */
@Data
public class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private CommonConstants.BookFormat format;
    private CommonConstants.BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public boolean checkout(String memberId) throws Exception {
        if(this.isReferenceOnly) {
            throw new Exception("This book is Reference only and can't be issued");
        }
        /*if(!BookLending.lendBook(this.getBarcode(), memberId)){
            return false;
        }*/
        this.updateBookItemStatus(CommonConstants.BookStatus.LOANED);
        return true;
    }

    public void updateBookItemStatus(CommonConstants.BookStatus loaned) {
    }


}
