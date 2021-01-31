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

    public void add(Animal animal) {
        animalRepository.save(animal);
    }

    public void edit(int id, Animal animal) {
        Animal sourceAnimal = animalRepository.findAnimalById(id);
        animalRepository.delete(sourceAnimal);
        animalRepository.save(animal);

    }

    public Animal get(int id) {

        if(animalRepository.existsById(id)){
            return animalRepository.findAnimalById(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }


    public void delete(Animal animal) {
        animalRepository.delete(animal);
    }
}
