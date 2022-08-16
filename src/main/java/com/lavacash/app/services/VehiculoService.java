/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.services;

import com.lavacash.app.domain.Vehiculo;
import com.lavacash.app.interfaces.VehiculoRepository;
import com.lavacash.app.interfacesService.IVehiculoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Override
    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo getVehiculoById(int id) {
        Optional<Vehiculo> optional = vehiculoRepository.findById(id);
        Vehiculo vehiculo = null;
        if(optional.isPresent()){
            vehiculo = optional.get();
        }else{
            throw new RuntimeException("Vehiculo con el id:"+id+" No encontrado");
        }
        return vehiculo;
    }

    @Override
    public void deleteVehiculoById(int id) {
        this.vehiculoRepository.deleteById(id);
    }

}
