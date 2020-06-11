package com.pourush.parkinglot.models;

import com.pourush.parkinglot.models.parkingspot.CompactSpot;
import com.pourush.parkinglot.models.parkingspot.ElectricSpot;
import com.pourush.parkinglot.models.parkingspot.HandicappedSpot;
import com.pourush.parkinglot.models.parkingspot.LargeSpot;
import com.pourush.parkinglot.models.parkingspot.MotorbikeSpot;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class ParkingDisplayBoard {
    private String id;
    CompactSpot freeCompactSpot;
    ElectricSpot freeElectricSpot;
    HandicappedSpot freeHandicappedSpot;
    LargeSpot freeLargeSpot;
    MotorbikeSpot freeMotorBikeSpot;

    public void showEmptySpotNumber(){
        String message ="";
        if (freeCompactSpot.getIsFree()){
            message +="Free Compact: "+freeCompactSpot.getNumber();
        }else{
            message +="Compact is full";
        }
        message += "\n";
        if (freeCompactSpot.getIsFree()){
            message +="Free electricSpot: "+freeElectricSpot.getNumber();
        }else{
            message +="electricSpot is full";
        }
        message += "\n";
        if (freeCompactSpot.getIsFree()){
            message +="Free HandicappedSpot: "+freeHandicappedSpot.getNumber();
        }else{
            message +="HandicappedSpot is full";
        }
        message += "\n";
        if (freeCompactSpot.getIsFree()){
            message +="Free LargeSpot: "+freeLargeSpot.getNumber();
        }else{
            message +="LargeSpot is full";
        }
        message += "\n";
        if (freeCompactSpot.getIsFree()){
            message +="Free MotorBikeSpot: "+freeMotorBikeSpot.getNumber();
        }else{
            message +="MotorBikeSpot is full";
        }
        message += "\n";

        System.out.println(message);

    }



}
