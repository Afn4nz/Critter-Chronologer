package com.udacity.jdnd.course3.critter.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Set;

@Table
@Entity
@Data
public class Employee extends User{
    @Id
    @GeneratedValue
    private long id;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;
}
