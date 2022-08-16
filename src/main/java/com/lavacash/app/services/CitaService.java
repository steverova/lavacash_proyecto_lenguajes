/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.services;

import com.lavacash.app.domain.Cita;
import com.lavacash.app.interfaces.CitaRepository;
import com.lavacash.app.interfacesService.ICitaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class CitaService implements ICitaService{

    @Autowired
    CitaRepository citaRepository;
    
    @Override
    public List<Cita> getCitas() {
        return citaRepository.findAll();
    }

    @Override
    public void guardarCita(Cita cita) {
        this.citaRepository.save(cita);
    }

    @Override
    public Cita getCitaById(int id) {
        Optional<Cita> optional = citaRepository.findById(id);
        Cita cita = null;
        if(optional.isPresent()){
            cita = optional.get();
        }else{
            throw new RuntimeException("Cita con el id:"+id+" No encontrada");
        }
        return cita;
    }

    @Override
    public void deleteCitaById(int id) {
        this.citaRepository.deleteById(id);
    }
    
}
