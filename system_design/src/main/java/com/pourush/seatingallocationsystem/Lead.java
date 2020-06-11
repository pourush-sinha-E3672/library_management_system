package com.pourush.seatingallocationsystem;

import lombok.Data;

import java.util.List;

/**
 * Created by pourush.sinha on 04/05/19.
 */
@Data
public class Lead extends Employee {
    private List<Developer> listOfDevelopers;

    public void changeSeat(int rowNumber, int seatNumber) {

    }

}
