package com.pourush.librarymanagmentsystem.services;

import lombok.Data;

import java.util.Date;

/**
 * Created by pourush.sinha on 24/03/19.
 */
@Data
public class Fine {
    private Date creationDate;
    private double bookItemBarcode;
    private String memberId;

    public static void collectFine(int memberId, long days) {}
}
