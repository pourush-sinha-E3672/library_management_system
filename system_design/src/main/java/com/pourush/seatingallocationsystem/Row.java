package com.pourush.seatingallocationsystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 05/05/19.
 */
@Data
public class Row {
    Boolean rowAllocated;
    List<Seat> seats = new ArrayList<>();


}
