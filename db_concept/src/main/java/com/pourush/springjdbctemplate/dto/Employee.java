package com.pourush.springjdbctemplate.dto;

import lombok.Data;

/**
 * Created by pourush.sinha on 17/01/19.
 */
@Data
public class Employee {
    public Employee(int id,String name ,float salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    private int id;
    private String name;
    private float salary;
}
