package com.lavacash.app.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.UserServices;


@RestController
@RequestMapping("/perfil")
public class ProfileRestController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/actualizarTelefono")
    public void updatePhone(@RequestParam("telefono") String telefono, HttpSession session){

        User seesionU = (User) session.getAttribute("csession");
        userServices.updatePhoneNumber(telefono, seesionU.getId());


    }

    @PostMapping("/verificarContrasena")
    public int passwordValidated(@RequestParam("contrasena") String contrasena){

        return userServices.validatePassword(contrasena);

    }

}
