package com.pourush.seatingallocationsystem;

import lombok.Data;

/**
 * Created by pourush.sinha on 04/05/19.
 */
@Data
public abstract class Employee {
    String id;
    String name;
    String address;
    String buId;
    String teamName;


    public abstract void changeSeat(int rowNumber,int seatNumber);

}
