package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.repositories.AnimalRepository;
import com.gbv.dailyreport.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal add(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal edit(int id, Animal animal) {
        Animal sourceAnimal = animalRepository.getOne(id);
        animalRepository.delete(sourceAnimal);
        animalRepository.save(animal);
        return animal;

    }

    @Override
    public Animal get(int id) {

        if(animalRepository.existsById(id)){
            return animalRepository.getOne(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }


    @Override
    public void delete(Animal animal) {
        animalRepository.delete(animal);
    }
}
