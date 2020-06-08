package com.pourush.librarymanagmentsystem.services;

import com.pourush.librarymanagmentsystem.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 24/03/19.
 */
@Data
public class BookReservation {
    int memberId;
    public static BookReservation fetchReservationDetails(String barcode) {
        return new BookReservation();
    }


    public void updateStatus(CommonConstants.ReservationStatus status) {
    }

    public void sendBookAvailableNotification() {
    }
}
