package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Cuidador;
import com.gbv.dailyreport.repositories.CuidadorRepository;
import com.gbv.dailyreport.services.CuidadorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CuidadorServiceImpl implements CuidadorService {

    private final CuidadorRepository cuidadorRepository;

    public CuidadorServiceImpl(CuidadorRepository cuidadorRepository) {
        this.cuidadorRepository = cuidadorRepository;
    }

    public void add(Cuidador cuidador) {
        cuidadorRepository.save(cuidador);
    }

    public void edit(int id, Cuidador cuidador) {
        Cuidador sourceCuidador = cuidadorRepository.getOne(id);
        cuidadorRepository.delete(sourceCuidador);
        cuidadorRepository.save(cuidador);

    }

    public Cuidador get(int id) {

        if(cuidadorRepository.existsById(id)){
            return cuidadorRepository.getOne(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    public List<Cuidador> getAll() {
        return cuidadorRepository.findAll();
    }


    public void delete(Cuidador cuidador) {
        cuidadorRepository.delete(cuidador);
    }
}
