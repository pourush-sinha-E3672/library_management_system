package com.pourush.librarymanagmentsystem.dto;

import lombok.Data;

/**
 * Created by pourush.sinha on 23/03/19.
 */
@Data
public class Librarian extends Account {
    public boolean addBookItem(BookItem bookItem){
        return false;
    }
    public boolean blockMember(Member member){
        return false;
    }
    public boolean unBlockMember(Member member){
        return false;
    }
}
