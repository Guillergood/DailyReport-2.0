package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Animal;

import java.util.List;

public interface AnimalService {
    Animal add(Animal animal);
    void delete(Animal animal);
    Animal edit(int id, Animal animal);
    Animal get(int id);
    List<Animal> getAll();
}
