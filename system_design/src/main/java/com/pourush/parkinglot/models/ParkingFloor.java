package com.pourush.parkinglot.models;

import com.pourush.parkinglot.models.parkingspot.CompactSpot;
import com.pourush.parkinglot.models.parkingspot.ElectricSpot;
import com.pourush.parkinglot.models.parkingspot.HandicappedSpot;
import com.pourush.parkinglot.models.parkingspot.LargeSpot;
import com.pourush.parkinglot.models.parkingspot.MotorbikeSpot;
import com.pourush.parkinglot.models.parkingspot.ParkingSpot;
import com.pourush.parkinglot.models.vehicle.Vehicle;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pourush.sinha on 25/03/19.
 */
@Data
public class ParkingFloor {
    String name;
    CompactSpot freeCompactSpot;
    ElectricSpot freeElectricSpot;
    HandicappedSpot freeHandicappedSpot;
    LargeSpot freeLargeSpot;
    MotorbikeSpot freeMotorBikeSpot;
    private Map<String,ParkingSpot> compactSpots = new HashMap<String, ParkingSpot>();
    private Map<String,ParkingSpot> freeElectricSpots = new HashMap<String, ParkingSpot>();
    private Map<String,ParkingSpot> freeHandicappedSpots = new HashMap<String, ParkingSpot>();
    private Map<String,ParkingSpot> freeLargeSpots = new HashMap<String, ParkingSpot>();
    private Map<String,ParkingSpot> freeMotorBikeSpots = new HashMap<String, ParkingSpot>();
    private ParkingDisplayBoard parkingDisplayBoard;
    public ParkingFloor(String name){
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        switch (parkingSpot.getParkingSpotType()){

            case COMPACT:
                compactSpots.put(parkingSpot.getNumber(),parkingSpot);
                break;
            case ELECTRIC:
                freeElectricSpots.put(parkingSpot.getNumber(),parkingSpot);
                break;
            case HANDICAPPED:
                freeHandicappedSpots.put(parkingSpot.getNumber(),parkingSpot);
                break;
            case LARGE:
                freeLargeSpots.put(parkingSpot.getNumber(),parkingSpot);
                break;
            case MOTORCYCLE:
                freeMotorBikeSpots.put(parkingSpot.getNumber(),parkingSpot);
                break;
            default:
                System.out.print("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot){
        spot.setVehicle(vehicle);
        switch (spot.getParkingSpotType()){

            case COMPACT:
                updateDispalayBoardForComapct(spot);
                break;
            case ELECTRIC:
                updateDispalayBoardForElectric(spot);
                break;
            case HANDICAPPED:
                updateDispalayBoardForHandiCapped(spot);
                break;
            case LARGE:
                updateDispalayBoardForLarge(spot);
                break;
            case MOTORCYCLE:
                updateDispalayBoardForMotorCyle(spot);
                break;
            default:
                System.out.print("Wrong parking spot type!");

        }

    }

    private void updateDispalayBoardForElectric(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getFreeElectricSpot().getNumber() == spot.getNumber()){
            for(String name :freeElectricSpots.keySet()){
                if(freeElectricSpots.get(name).getIsFree()){
                    this.parkingDisplayBoard.setFreeElectricSpot((ElectricSpot) freeElectricSpots.get(name));
                }
            }
        }
    }

    private void updateDispalayBoardForMotorCyle(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getFreeMotorBikeSpot().getNumber() == spot.getNumber()){
            for(String name :freeMotorBikeSpots.keySet()){
                if(freeMotorBikeSpots.get(name).getIsFree()){
                    this.parkingDisplayBoard.setFreeMotorBikeSpot((MotorbikeSpot) freeMotorBikeSpots.get(name));
                }
            }
        }
        this.parkingDisplayBoard.showEmptySpotNumber();
    }

    private void updateDispalayBoardForLarge(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getFreeLargeSpot().getNumber() == spot.getNumber()){
            for(String name :freeLargeSpots.keySet()){
                if(freeLargeSpots.get(name).getIsFree()){
                    this.parkingDisplayBoard.setFreeLargeSpot((LargeSpot) freeLargeSpots.get(name));
                }
            }
        }
        this.parkingDisplayBoard.showEmptySpotNumber();
    }

    private void updateDispalayBoardForHandiCapped(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getFreeHandicappedSpot().getNumber() == spot.getNumber()){
            for(String name :freeHandicappedSpots.keySet()){
                if(freeHandicappedSpots.get(name).getIsFree()){
                    this.parkingDisplayBoard.setFreeHandicappedSpot((HandicappedSpot) freeHandicappedSpots.get(name));
                }
            }
        }
        this.parkingDisplayBoard.showEmptySpotNumber();
    }


    private void updateDispalayBoardForComapct(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getFreeCompactSpot().getNumber() == spot.getNumber()){
            for(String name :compactSpots.keySet()){
                if(compactSpots.get(name).getIsFree()){
                    this.parkingDisplayBoard.setFreeCompactSpot((CompactSpot) compactSpots.get(name));
                }
            }
        }
        this.parkingDisplayBoard.showEmptySpotNumber();
    }


}
