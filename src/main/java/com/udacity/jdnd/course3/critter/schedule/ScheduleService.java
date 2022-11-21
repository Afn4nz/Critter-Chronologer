package com.udacity.jdnd.course3.critter.schedule;


import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PetService petService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    public Schedule createSchedule(Schedule schedule){
            return scheduleRepository.save(schedule);
        }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleForPet(Long id){
        Pet pet = petService.getPet(id);
        System.out.println("_+_+_+_+_+_+_+ The size of list is:"+scheduleRepository.findByPetsContaining(pet).size());
        return scheduleRepository.findByPetsContaining(pet);
    }

    public List<Schedule> getScheduleForEmployee(Long id){
        Employee employee = employeeService.getEmployee(id);
        System.out.println("_+_+_+_+_+_+_+ The size of list is:"+scheduleRepository.findByEmployeesContaining(employee).size());
        return scheduleRepository.findByEmployeesContaining(employee);
    }

    public List<Schedule> getScheduleForCustomer(Long id){
        Customer customer = customerService.getCustomer(id);
        List<Schedule> schedules = scheduleRepository.findByPetsIn(customer.getPets());
        System.out.println("_+_+_+_+_+_+_+ The size of list is:"+schedules.size());
        return schedules;
    }
}
