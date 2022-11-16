package com.udacity.jdnd.course3.critter.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Set;

@Table
@Entity
public class Employee extends User{
    @Id
    private long id;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;
}
