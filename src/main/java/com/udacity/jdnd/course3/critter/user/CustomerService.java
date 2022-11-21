package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PetRepository petRepository;

    public Customer createCustomer(Customer customer, List<Long> petIds){
        if (petIds != null && !petIds.isEmpty()  ) {
            List<Pet> myPets = new ArrayList<>();
            for(Long petId : petIds){
                myPets.add(petRepository.findById(petId).get());
        }
        customer.setPets(myPets);
    }
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void insertPet(Customer customer, Pet pet){

        if(customer.getPets() == null) {
            List<Pet> petList = new ArrayList<>();
            petList.add(pet);
            customer.setPets(petList);
        }
        else
            customer.getPets().add(pet);

        customerRepository.save(customer);
    }

    public Customer getOwnerByPet(Long id){
        return customerRepository.findByPets_id(id);
    }
}
