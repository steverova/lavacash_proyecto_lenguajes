package com.lavacash.app.controller;

import java.util.List;

import javax.persistence.criteria.Selection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.ServicioService;

@Controller
@RequestMapping({ "/", "" })
public class HomeController {

    @Autowired
    private ServicioService servicioService;

    /**
     * @param model
     * @return
     */
    @GetMapping("")
    public String home(Model model, HttpSession session) {

        List<ServicioJPA> servicios = servicioService.obtener();
        model.addAttribute("servicios", servicios);

        User seesionU = (User) session.getAttribute("csession");

        if(seesionU != null){
            model.addAttribute("client",seesionU);
        }

        return "home";
    }
}
