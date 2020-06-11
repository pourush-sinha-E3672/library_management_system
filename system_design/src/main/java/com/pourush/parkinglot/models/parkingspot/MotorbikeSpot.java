package com.pourush.parkinglot.models.parkingspot;

import com.pourush.parkinglot.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */

@Data
public class MotorbikeSpot extends ParkingSpot{

    public MotorbikeSpot(){
        super(CommonConstants.parkingSpotType.MOTORCYCLE);
    }
}
