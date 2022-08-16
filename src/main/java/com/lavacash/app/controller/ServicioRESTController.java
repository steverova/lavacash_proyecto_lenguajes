package com.lavacash.app.controller;

import com.lavacash.app.data.DataHijos;
import com.lavacash.app.domain.Hijo;
import com.lavacash.app.domain.ServicioHijos;
import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.services.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio/api")
public class ServicioRESTController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public List<ServicioJPA> listar() {
        List<ServicioJPA> servicios = servicioService.obtener();
        return servicios;
    }

    @GetMapping("/basico")
    public List<ServicioJPA> listarBasicos() {
        List<ServicioJPA> servicios = servicioService.obtenerBasicos();
        return servicios;
    }

    @PostMapping("/")
    public int guardar(@RequestBody ServicioJPA servicio) {
        return servicioService.guardar(servicio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicioService.eliminar(id);
    }

    @PutMapping("/")
    public void actualizar(@RequestBody ServicioJPA servicio) {
        System.out.println("SERVICIO ID: " + servicio.getId());
        servicioService.guardar(servicio);
    }

    //rutas para hijos
    @PostMapping("/hijos/")
    public boolean guardarHijos(@RequestBody ServicioHijos hijos) {
        if (servicioService.reiniciarHijos(hijos.getId())) {
            for (Hijo hijo : hijos.getHijos()) {
                servicioService.guardarHijos(hijos.getId(), hijo.getId());
            }
        }
        return true;
    }

    @GetMapping("/hijos/{id}")
    public ServicioHijos obtenerHijos(@PathVariable int id) {

        return servicioService.getHijos(id);
    }
}
