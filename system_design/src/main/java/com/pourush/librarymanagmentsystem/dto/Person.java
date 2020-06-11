package com.pourush.librarymanagmentsystem.dto;

import lombok.Data;

/**
 * Created by pourush.sinha on 19/03/19.
 */

@Data
public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}
