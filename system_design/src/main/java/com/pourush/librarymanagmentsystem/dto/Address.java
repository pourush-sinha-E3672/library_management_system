package com.pourush.librarymanagmentsystem.dto;

import lombok.Data;

/**
 * Created by pourush.sinha on 19/03/19.
 */
@Data
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
