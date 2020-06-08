package com.pourush;



import javafx.util.Pair;

import java.util.List;

/**
 * Created by pourush.sinha on 09/06/19.
 */

class BusStop{
    Pair<Integer,Integer> coordinate;
    String stopName;
    List<Long> bustimes;
}
public class DesignNearestBustation {
    

    static Double getNearestBusStation(Pair<Integer,Integer> coordinate  ,List<BusStop> busCoordinates){
        Double nearestBustop =Double.MAX_VALUE;
        for (BusStop busStop: busCoordinates) {

            Double distance= getDistance(coordinate,busStop.coordinate);
            nearestBustop =Math.min(nearestBustop,distance);
        }
        return nearestBustop;


    }

    static Double getDistance(Pair<Integer,Integer> coordinate, Pair<Integer,Integer> busCoordinate){
        Double val =Math.sqrt(busCoordinate.getKey() - coordinate.getKey()) * (busCoordinate.getKey() - coordinate.getKey()) +((busCoordinate.getValue() - coordinate.getValue()) * (busCoordinate.getValue() - coordinate.getValue()));
        return val;
    }
}
