package com.lavacash.app.controller;

import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.services.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/")
    public String listar(Model model) {
        List<ServicioJPA> servicios = servicioService.obtener();
        model.addAttribute("servicios", servicios);
        return "servicio/listar";
    }
    
    @GetMapping("/crear")
    public String crear(Model model) {
        //List<ServicioJPA> servicios = servicioService.obtener();
        //model.addAttribute("servicios", servicios);
        return "servicio/crear";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        ServicioJPA servicio = servicioService.obtenerPorId(id).get();
        model.addAttribute("servicio", servicio);
        return "servicio/editar";
    }
    
    @PostMapping("/save")
    public String guardar(@Validated ServicioJPA servicio, Model model) {
        servicioService.guardar(servicio);
        return "redirect:http://localhost:8080/servicio/";
    }
}
