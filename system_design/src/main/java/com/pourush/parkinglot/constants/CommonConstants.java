package com.pourush.parkinglot.constants;

import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class CommonConstants {

    public enum parkingSpotType{
        COMPACT,LARGE,HANDICAPPED,MOTORCYCLE,ELECTRIC
    }

    public enum vehicleType{
        CAR,TRUCK,VAN,MOTORCYCLE
    }

    public enum paymentType{
        CASH,CREDIT_CARD
    }

    public enum parkingTicketStatus{
        ACTIVE,PAID,LOST
    }
}
