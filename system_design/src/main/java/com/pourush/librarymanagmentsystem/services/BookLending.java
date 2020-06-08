package com.pourush.librarymanagmentsystem.services;

import java.util.Date;

/**
 * Created by pourush.sinha on 23/03/19.
 */
public class BookLending {
    private Date dueDate;
    public static boolean lendBook(String barcode, int memberId) {
        return false;
    }

    public static BookLending fetchLendingDetails(String bookItemBarcode) {
        return  new BookLending();
    }

    public Date getDueDate() {
        return dueDate;
    }
}
