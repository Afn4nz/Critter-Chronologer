package com.udacity.jdnd.course3.critter.pet;


import com.udacity.jdnd.course3.critter.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerService customerService;

    public Pet createPet(Pet pet){
        petRepository.save(pet);
        customerService.insertPet(pet.getCustomer(), pet);
        return pet;
    }

    public Pet getPet(Long id){
        return petRepository.findById(id).get();
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Long ownerId){
       return petRepository.findAllByCustomer_id(ownerId);
    }

}
