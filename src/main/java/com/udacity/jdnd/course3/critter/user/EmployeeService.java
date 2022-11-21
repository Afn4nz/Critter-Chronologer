package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        List<Employee> employees = employeeRepository
                .findByDaysAvailableContaining(date.getDayOfWeek());
        return employees.stream().filter(e -> e.getSkills().containsAll(skills)).collect(Collectors.toList());
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }
}
