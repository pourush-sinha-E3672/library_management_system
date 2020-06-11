package com.pourush.parkinglot.models.parkingspot;

import com.pourush.parkinglot.constants.CommonConstants;
import com.pourush.parkinglot.models.vehicle.Vehicle;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public abstract class ParkingSpot {
    String number;
    CommonConstants.parkingSpotType parkingSpotType;
    Boolean isFree;
    Vehicle vehicle;

    public ParkingSpot(CommonConstants.parkingSpotType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isFree =false;
    }

    public void freeVehicle(){
        this.vehicle =null;
        this.isFree =true;
    }

}
