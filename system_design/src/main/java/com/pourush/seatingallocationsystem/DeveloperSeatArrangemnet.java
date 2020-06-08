package com.pourush.seatingallocationsystem;

import java.util.List;

/**
 * Created by pourush.sinha on 05/05/19.
 */
public class DeveloperSeatArrangemnet implements ISeatArrangement {
    @Override
    public void changeSeat(Employee employee, int seatNumber) {
        Developer developer = (Developer)employee;
        BusinessUnit businessUnit =  Office.getInstance().getStringBusinessUnitMap().get(developer.getBuId());
        Team team = businessUnit.getMap().get(developer.getTeamName());
        Row row = Office.getInstance().getIntegerRowMap().get(team.getRowNumber());
        Seat seat = row.getSeats().get(seatNumber);
        if (seat.seatState == SeatState.OPEN){
            seat.setEmployee(employee);
            row.getSeats().stream().forEach(seat1 -> {if(seat1.getEmployee() !=null && seat1.getEmployee().id ==employee.getId()){
                seat1.setEmployee(null);
                seat1.seatState =SeatState.OPEN;
            }
            });
        }else{
            throw new RuntimeException(" Seat is already allocated");
        }

    }
}
