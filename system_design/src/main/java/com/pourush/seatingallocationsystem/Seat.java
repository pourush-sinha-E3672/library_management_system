package com.pourush.seatingallocationsystem;

import lombok.Data;

/**
 * Created by pourush.sinha on 05/05/19.
 */
@Data
public class Seat {
    Employee employee;
    SeatState seatState;
}
