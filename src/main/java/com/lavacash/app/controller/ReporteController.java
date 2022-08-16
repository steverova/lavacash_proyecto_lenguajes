package com.lavacash.app.controller;

import com.lavacash.app.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
    
    @Autowired
    private ReporteService reporteServ;
    
    @GetMapping("/")
    public String page(Model model) {
        return "reporte/listar";
    }
    
}
