package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Pet {
    @Id
    private long id;
    private PetType type;
    private String name;
    @ManyToOne
    private Customer customer;
    private LocalDate birthDate;
    private String notes;
}
