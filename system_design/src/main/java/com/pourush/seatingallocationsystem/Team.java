package com.pourush.seatingallocationsystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 04/05/19.
 */
@Data
public class Team {
    Lead lead;
    Integer rowNumber;
    List<Developer> listOfDevelopers = new ArrayList<>();

    int getNumberOfDevelopersRequired(){
        return Constants.MAX_DEVELOPERS_IN_TEAM - listOfDevelopers.size();
    }

}
