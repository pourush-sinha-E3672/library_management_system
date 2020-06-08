package com.pourush.seatingallocationsystem;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by pourush.sinha on 04/05/19.
 */
@Data
public class Office {
    private static  final int numberOfrows = 100;
    private static Office ourInstance = new Office();

    public static Office getInstance() {
        return ourInstance;
    }

    private Office() {
    }


    Map<String,BusinessUnit> stringBusinessUnitMap = new HashMap<String, BusinessUnit>();
    Map<Integer ,Row> integerRowMap = new TreeMap<Integer,Row>();

    public void totalNumberOfBu(){
        System.out.println("Total number BU ="+stringBusinessUnitMap.size());

    }

    public void printOpenPositionOfLeads( String buName){
        BusinessUnit businessUnit = stringBusinessUnitMap.get(buName);
        businessUnit.referesh();
        System.out.println("Total number leads required ="+businessUnit.getNumberOfleadRequired());
        System.out.println("Total number of Developers required ="+businessUnit.getNumberOfDevelopersRequired());

    }

    public void printTotalNumberOfOpernPositions(String buName){
        BusinessUnit businessUnit = stringBusinessUnitMap.get(buName);
        businessUnit.referesh();
        System.out.println("Total number of oper positions ="+businessUnit.getNumberOfOpenPositions());

    }






}
