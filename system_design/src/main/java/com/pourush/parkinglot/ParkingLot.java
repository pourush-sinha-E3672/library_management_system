package com.pourush.parkinglot;

import com.pourush.parkinglot.constants.CommonConstants;
import com.pourush.parkinglot.models.ParkingFloor;
import com.pourush.parkinglot.models.vehicle.Vehicle;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pourush.sinha on 26/03/19.
 */
@Data
public class ParkingLot {

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;

    Map<String,ParkingFloor> parkingFloorMap = new HashMap<String, ParkingFloor>();
    Map<String ,ParkingTicket> activeParkingTickets = new HashMap<String, ParkingTicket>();

    private static ParkingLot parkingLot= null;

    private  ParkingLot(){
        maxCompactCount =200;
        maxLargeCount =200;
        maxMotorbikeCount =200;
        maxElectricCount =200;
    }
    public static ParkingLot getParkingLot(){
        if (parkingLot== null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public synchronized ParkingTicket getParkingTicket(Vehicle vehicle) throws Exception {
        if (this.isFull(vehicle.getVehicleType())) {
            throw new Exception("");
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
       // ticket.saveInDB();
        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.getVehicleType());
        this.activeParkingTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }





    public boolean isFull(CommonConstants.vehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == CommonConstants.vehicleType.TRUCK || type == CommonConstants.vehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == CommonConstants.vehicleType.MOTORCYCLE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == CommonConstants.vehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    private void incrementSpotCount(CommonConstants.vehicleType type) {
        if (type == CommonConstants.vehicleType.TRUCK || type == CommonConstants.vehicleType.VAN) {
            largeSpotCount++;
        } else if (type == CommonConstants.vehicleType.MOTORCYCLE) {
            motorbikeSpotCount++;
        } else if (type == CommonConstants.vehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    public void addParkingFloor(ParkingFloor floor) {
    /* stores in database */ }

   /* public void addEntrancePanel(EntrancePanel entrancePanel) {
    *//* stores in database *//* }

    public void addExitPanel(ExitPanel exitPanel) {
    *//* stores in database *//* }
*/






}
