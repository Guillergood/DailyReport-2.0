package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Cuidador;

import java.util.List;

public interface CuidadorService {
    Cuidador add(Cuidador cuidador);
    void delete(Cuidador cuidador);
    Cuidador edit(int id, Cuidador cuidador);
    Cuidador get(int id);
    List<Cuidador> getAll();
}
