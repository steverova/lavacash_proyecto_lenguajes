/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.interfacesService;

import com.lavacash.app.domain.Vehiculo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IVehiculoService {
    
    List<Vehiculo> getVehiculos();
    void guardarVehiculo(Vehiculo vehiculo);
    Vehiculo getVehiculoById(int id);
    void deleteVehiculoById(int id);
    
}
