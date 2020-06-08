package com.pourush.parkinglot.models.vehicle;

import com.pourush.parkinglot.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class Car extends Vehicle {

    public Car(){
        super(CommonConstants.vehicleType.CAR);
    }
}
