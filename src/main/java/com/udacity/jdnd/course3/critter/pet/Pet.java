package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class Pet {
    @Id
    @GeneratedValue
    private long id;
    private PetType type;
    private String name;
    @ManyToOne
    private Customer customer;
    private LocalDate birthDate;
    private String notes;
}
