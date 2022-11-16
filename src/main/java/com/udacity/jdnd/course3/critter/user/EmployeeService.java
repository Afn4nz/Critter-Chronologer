package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO){
        return employeeRepository.findAllBySkillsInAndDaysAvailableContains(employeeRequestDTO.getSkills(), employeeRequestDTO.getDate());
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long id){
       Employee employee = getEmployee(id);
       for (DayOfWeek dayOfWeek: daysAvailable)
       employee.getDaysAvailable().add(dayOfWeek);
       employee.setDaysAvailable(daysAvailable);
    }
}
