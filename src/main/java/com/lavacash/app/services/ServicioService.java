package com.lavacash.app.services;

import com.lavacash.app.data.DataHijos;
import com.lavacash.app.domain.Hijo;
import com.lavacash.app.domain.ServicioHijos;
import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.interfaces.IServicio;
import com.lavacash.app.interfacesService.IServicioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements IServicioService{

    @Autowired
    private IServicio servicioData;
    
    @Override
    public List<ServicioJPA> obtener() {
        return (List<ServicioJPA>) servicioData.findAll();
    }

    @Override
    public Optional<ServicioJPA> obtenerPorId(int id) {
        return servicioData.findById(id);
    }

    @Override
    public int guardar(ServicioJPA servicio) {
        ServicioJPA nServicio = servicioData.save(servicio);
        return (nServicio != null) ? nServicio.getId() : 0;
    }

    @Override
    public void eliminar(int id) {
        servicioData.deleteById(id);
    }

    public List<ServicioJPA> obtenerBasicos() {
        List<ServicioJPA> servicios = (List<ServicioJPA>) servicioData.findAll();
        ArrayList<ServicioJPA> basicos = new ArrayList();
        for (ServicioJPA basico : servicios) {
            if(basico.getTipo() == 1){
                basicos.add(basico);
            }
        }
        return basicos;
    }
    
    /*
     * 
     */
    public ServicioHijos getHijos(int padre) {
        return new DataHijos().getHijos(padre);
    }
    
    public boolean guardarHijos(int padre, int hijo) {
        return new DataHijos().guardarHijo(padre, hijo);
    }
    
    public boolean reiniciarHijos(int padre) {
        return new DataHijos().reiniciarHijos(padre);
    }
}
