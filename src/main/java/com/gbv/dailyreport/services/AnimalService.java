package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Animal;

import java.util.List;

public interface AnimalService {
    void add(Animal animal);
    void delete(Animal animal);
    void edit(int id, Animal animal);
    Animal get(int id);
    List<Animal> getAll();
}