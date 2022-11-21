package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PetService petService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return toDTO(scheduleService.createSchedule(toEntity(scheduleDTO)));
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleService.getAllSchedules();
        for (Schedule schedule : scheduleList)
            scheduleDTOList.add(toDTO(schedule));
        return scheduleDTOList;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleService.getScheduleForPet(petId);
        for (Schedule schedule : scheduleList)
            scheduleDTOList.add(toDTO(schedule));
        return scheduleDTOList;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleService.getScheduleForEmployee(employeeId);
        for (Schedule schedule : scheduleList)
            scheduleDTOList.add(toDTO(schedule));
        return scheduleDTOList;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleService.getScheduleForCustomer(customerId);
        for (Schedule schedule : scheduleList)
            scheduleDTOList.add(toDTO(schedule));
        return scheduleDTOList;
    }

    private ScheduleDTO toDTO(Schedule schedule){
        List<Long> employeeIds = new ArrayList<>();
        List<Long> petIds = new ArrayList<>();
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setActivities(schedule.getActivities());
        scheduleDTO.setDate(schedule.getDate());

        for (Employee employee : schedule.getEmployees())
            employeeIds.add(employee.getId());
        scheduleDTO.setEmployeeIds(employeeIds);

        for(Pet pet : schedule.getPets())
            petIds.add(pet.getId());
        scheduleDTO.setPetIds(petIds);

        return scheduleDTO;
    }

    private Schedule toEntity(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        List<Employee> employeeList = new ArrayList<>();
        List<Pet> petList = new ArrayList<>();

        schedule.setId(scheduleDTO.getId());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());

            for (long id : scheduleDTO.getEmployeeIds())
                employeeList.add(employeeService.getEmployee(id));
            schedule.setEmployees(employeeList);

            for (long id : scheduleDTO.getPetIds())
                petList.add(petService.getPet(id));
            schedule.setPets(petList);

        return schedule;
    }
}
