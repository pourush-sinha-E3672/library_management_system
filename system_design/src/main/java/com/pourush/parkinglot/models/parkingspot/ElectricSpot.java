package com.pourush.parkinglot.models.parkingspot;

import com.pourush.parkinglot.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class ElectricSpot extends ParkingSpot {
    public ElectricSpot(){
        super(CommonConstants.parkingSpotType.ELECTRIC);
    }
}
