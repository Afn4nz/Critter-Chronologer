package com.udacity.jdnd.course3.critter.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Customer extends User{
    @Id
    private long id;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds;
}
