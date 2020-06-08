package com.pourush.seatingallocationsystem;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pourush.sinha on 04/05/19.
 */
@Data
public class BusinessUnit {
    int startRow;
    int endRow;
    int totalStrength;
    int numberOfOpenPositions;
    int numberOfleadRequired;
    int numberOfDevelopersRequired;
    int strengthOfbu;


    BusinessUnit(int startRow ,int endRow){
        this.startRow = startRow;
        this.endRow = endRow;
    }


    Map<String,Team> map = new HashMap<String, Team>();

    public void referesh(){
        for (Map.Entry<String,Team> entry : map.entrySet()){
            numberOfOpenPositions += entry.getValue().getNumberOfDevelopersRequired();
            numberOfDevelopersRequired += entry.getValue().getNumberOfDevelopersRequired();
            strengthOfbu = entry.getValue().getListOfDevelopers().size();
            if(entry.getValue().lead == null){
                numberOfOpenPositions += 1;
                numberOfleadRequired += 1;
            }else {
                strengthOfbu +=1;
            }


    }


}


}
