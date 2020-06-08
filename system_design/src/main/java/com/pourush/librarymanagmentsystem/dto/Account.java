package com.pourush.librarymanagmentsystem.dto;

import com.pourush.librarymanagmentsystem.constants.CommonConstants;
import lombok.Data;

/**
 * Created by pourush.sinha on 23/03/19.
 */
@Data
public abstract class Account {
    private String id;
    private String password;
    private CommonConstants.AccountStatus status;
    private Person person;

    public boolean resetPassword(){
        return true;
    }

    public  void decrementTotalBooksCheckedout(){

    }
}
