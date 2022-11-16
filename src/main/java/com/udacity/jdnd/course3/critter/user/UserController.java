package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = new Customer();
        CustomerDTO customerDTO1 = new CustomerDTO();
        BeanUtils.copyProperties(customerDTO, customer);
        BeanUtils.copyProperties(customerService.createCustomer(customer), customerDTO1);
        return customerDTO1;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        BeanUtils.copyProperties(customerService.getAllCustomers(), customerDTOList);
        return customerDTOList;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        throw new UnsupportedOperationException();
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        BeanUtils.copyProperties(employeeDTO, employee);
        BeanUtils.copyProperties(employeeService.createEmployee(employee), employeeDTO1);
        return employeeDTO1;
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeService.getEmployee(employeeId), employeeDTO);
        return employeeDTO;
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        BeanUtils.copyProperties(employeeService.findEmployeesForService(employeeDTO), employeeDTOList);
        return employeeDTOList;
    }

}
