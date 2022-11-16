package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Schedule {
    @Id
    private long id;
    private LocalDate date;
    private Set<EmployeeSkill> activities;
}
