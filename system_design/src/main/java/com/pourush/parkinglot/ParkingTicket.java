package com.pourush.parkinglot;

import com.pourush.parkinglot.constants.CommonConstants;
import lombok.Data;

import java.util.Date;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class ParkingTicket {

    String ticketNumber;
    Date issuedAt;
    Date payedAt;
    int payedAmount;
    CommonConstants.parkingTicketStatus  parkingTicketStatus;
}
