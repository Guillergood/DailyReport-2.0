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

    @Override
    public Cuidador add(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    @Override
    public Cuidador edit(int id, Cuidador cuidador) {
        Cuidador sourceCuidador = cuidadorRepository.getOne(id);
        cuidadorRepository.delete(sourceCuidador);
        cuidadorRepository.save(cuidador);
        return cuidador;

    }

    @Override
    public Cuidador get(int id) {

        if(cuidadorRepository.existsById(id)){
            return cuidadorRepository.getOne(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public List<Cuidador> getAll() {
        return cuidadorRepository.findAll();
    }


    @Override
    public void delete(Cuidador cuidador) {
        cuidadorRepository.delete(cuidador);
    }
}
