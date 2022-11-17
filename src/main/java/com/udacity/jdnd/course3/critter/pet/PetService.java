package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetService {

    @Autowired
    PetRepository petRepository;

    public Pet createPet(Pet pet){
        return petRepository.save(pet);
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
