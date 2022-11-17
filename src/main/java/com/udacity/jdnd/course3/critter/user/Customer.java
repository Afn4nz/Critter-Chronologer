package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Data
public class Customer extends User{
    @Id
    private long id;
    private String phoneNumber;
    private String notes;
    @OneToMany
    private List<Pet> pets;
}
