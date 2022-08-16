/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.controller;

import com.lavacash.app.domain.Cita;
import com.lavacash.app.domain.Vehiculo;
import com.lavacash.app.services.CitaService;
import com.lavacash.app.services.ServicioService;
import com.lavacash.app.services.UserServices;
import com.lavacash.app.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/citas")
public class CitasController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @Autowired
    private CitaService citaService;
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private UserServices userServices;
    
    //--------Apartado Citas -------------
    @GetMapping("/citas")
    public String inicioCitas(Model model){
        model.addAttribute("listaCitas", citaService.getCitas());
        
        return "cita/indexCita";
    }
    
    @GetMapping("citas/agregarCita")
    public String agregarCita(Model model){
        //crea atributo 
        Cita cita = new Cita();
        model.addAttribute("cita", cita);
        model.addAttribute("listaVehiculos", vehiculoService.getVehiculos());
        model.addAttribute("listaServicios", servicioService.obtener());
        
        return "cita/nueva_cita";
    }
    
    @PostMapping("/guardarCita")
    public String guardarCita(@ModelAttribute("cita") Cita cita){
        //guarda en db
        citaService.guardarCita(cita);
        return "redirect:/citas/citas";
    }
    
    
    //------------Apartado Vehiculos ------------------
    @GetMapping("/")
    public String inicioVehiculos(Model model){
        model.addAttribute("listaVehiculos", vehiculoService.getVehiculos());
        
        return "vehiculo/index";
    }
    
    @GetMapping("/agregarVehiculoForm")
    public String agregarVehiculoForm(Model model){
        //crea atributo 
        Vehiculo vehiculo = new Vehiculo();
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("listaUsuarios", userServices.getAll());
        return "vehiculo/nuevo_vehiculo";
    }
    
    @PostMapping("/guardarVehiculo")
    public String guardarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo){
        //guarda en db
        vehiculoService.guardarVehiculo(vehiculo);
        return "redirect:/citas/";
    }
    
    @GetMapping("/mostrarFormActualizar/{id}")
    public String mostrarFormActualizar(@PathVariable (value="id") int id, Model model){
        
        //obtiene vehiculo del service
        Vehiculo vehiculo = vehiculoService.getVehiculoById(id);
        
        //set vehiculo como modelo al form
        model.addAttribute("vehiculo", vehiculo);
        return "vehiculo/actualizar_vehiculo";
    }
    
    @GetMapping("/borrarVehiculo/{id}")
    public String borrarVehiculo(@PathVariable (value = "id") int id){
        //call delete employee method
        
        this.vehiculoService.deleteVehiculoById(id);
        
        return "redirect:/citas/";
    }
    
}
