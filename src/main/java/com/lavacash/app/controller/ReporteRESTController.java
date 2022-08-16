package com.lavacash.app.controller;

import com.lavacash.app.domain.Reporte;
import com.lavacash.app.services.ReporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporte/api")
public class ReporteRESTController {
    
    @Autowired
    private ReporteService reporteServ;
    
    @GetMapping("/")
    public List<Reporte> obtener(Model model) {
        return reporteServ.obtener();
    }
    
}
