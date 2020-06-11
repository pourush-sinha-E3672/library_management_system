package com.pourush.parkinglot.models.vehicle;


import com.pourush.parkinglot.ParkingTicket;
import com.pourush.parkinglot.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class Vehicle {
    public Vehicle(CommonConstants.vehicleType vehicleType){
        this.vehicleType =vehicleType;
    }
    CommonConstants.vehicleType vehicleType;
    String LicenseNumber;
    private ParkingTicket  parkingTicket;

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
    }

}
