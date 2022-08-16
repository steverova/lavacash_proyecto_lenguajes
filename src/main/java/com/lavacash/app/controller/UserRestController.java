package com.lavacash.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.MailServices;
import com.lavacash.app.services.UserServices;
import com.lavacash.app.upload.Utils;

@RestController
@RequestMapping("/hola")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private MailServices mail;

    @PostMapping("/requestPassword")
    public boolean request(@RequestParam("email") String email, HttpSession session) {

        String codeVerify = Utils.cadenaAleatoria();
        session.setAttribute("codeVerify", codeVerify);
        session.setAttribute("email", email);
        mail.sendEmail(
                email,
                "SOLICITUD DE CAMBIO DE CONTRASEÑA",
                "PARA RESTABLECER TU CONTRASEÑA INGRESA EL SIGUETE CODIGO: " + codeVerify);
                return true;
    }

    @PostMapping("/validateCode")
    public boolean requestCode(@RequestParam("code") String code, HttpSession session) {
        System.out.println(session.getAttribute("codeVerify"));
        if(code.equals(session.getAttribute("codeVerify"))){
            return true;
        }
         return false;       
    }

    @PostMapping("/validateEmail")
    public int requestemail(@RequestParam("email") String email, HttpSession session) {
         return userServices.verifyEmail(email); 
    }

    @PostMapping("/actualizarImagen")
    public boolean updateImageProfeile(@RequestParam("file") MultipartFile imagen, HttpSession session, Model model){
        User seesionU = (User) session.getAttribute("csession");
        Utils.delete(seesionU.getImage());
        String imageName = Utils.guardarImagen(imagen);
        Utils.copyDirectory();
        userServices.updateProfileImage(imageName, seesionU.getId());
        return true;

    }


}
