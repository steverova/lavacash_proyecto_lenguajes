package com.lavacash.app.controller;

import com.lavacash.app.domain.InfoComentarios;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.CommentsServices;
import com.lavacash.app.services.MailServices;
import com.lavacash.app.services.UserServices;
import com.lavacash.app.upload.Utils;

import java.util.LinkedList;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cuenta")
public class UserController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private CommentsServices services;

    @Autowired
    private MailServices mail;

    @GetMapping("/registrar")
    public String viewRegister(Model model) {
        model.addAttribute("user", new User());
        return "user/autentication/form_register_user";
    }

    @GetMapping("/cambiar_contrasena")
    public String changepassword(Model model, HttpSession session) {
        model.addAttribute("email", session.getAttribute("email"));
        return "user/autentication/update_password";
    }

    @GetMapping("/iniciar_sesion")
    public String viewLogin(Model model) {
        model.addAttribute("user", new User());
        return "user/autentication/form_login_user";
    }

    @GetMapping("/perfil")
    public String viewProfile(Model model,HttpSession session) {
        model.addAttribute("client", session.getAttribute("csession"));
        User u = (User) session.getAttribute("csession");
        System.out.println(u.getNombre());
        return "user/client/profilev2";
    }

    @GetMapping("/cliente")
    public String viewUserIndex(Model model, HttpSession session) {
        User seesionU = (User) session.getAttribute("csession");
        if (seesionU != null && seesionU.getRol().equals("CLIENT")) {
            model.addAttribute("client", session.getAttribute("csession"));
            System.out.println("Cliente: "+seesionU.getNombre());
            return "user/client/index";
        }


        return "redirect:/cuenta/iniciar_sesion";
    }

    @GetMapping("/admin")
    public String viewAdminIndex(Model model, HttpSession session) {
        User seesionU = (User) session.getAttribute("asession");
        if (seesionU != null && seesionU.getRol().equals("ADMIN")) {
            // model.addAttribute("client", session.getAttribute("csession"));

            LinkedList<InfoComentarios> comments = services.getComments();
            model.addAttribute("comentarios", comments);
       
            return "user/admin/index";
        }
        return "redirect:/cuenta/iniciar_sesion";

    }

    // procesar datos
    @PostMapping("/guardar")
    public String saveUser(@Validated User user, @RequestParam("file") MultipartFile imagen) {
        mail.sendEmail(
                user.getCorreo(),
                "BIENVENIDA",
                "HOLA " + user.getNombre().toUpperCase() + " YA ERES USUARIO DE LAVACASH");

        String imageName = Utils.guardarImagen(imagen);
        user.setImage(imageName);
        user.setContrasena_(user.getContrasena());
        Utils.copyDirectory();

        userServices.add(user);
        return "user/autentication/succes_register";
    }

    @PostMapping("/ingresar")
    public String login(@Validated User user, Model model, HttpSession session) {
        User u = userServices.getUserVerify(user.getCorreo(), user.getContrasena());

        if (u != null) {
            if (u.getRol().equalsIgnoreCase("CLIENT")) {
                session.setAttribute("csession", u);
                return "redirect:/cuenta/cliente";
            } else if (u.getRol().equalsIgnoreCase("ADMIN")) {
                session.setAttribute("asession", u);
                return "redirect:/cuenta/admin";
            }
        }
        model.addAttribute("mensaje", "Usuario no registrado");
        return "user/autentication/form_login_user";
    }

    @GetMapping("/cerrar")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("csession");
        session.invalidate();
        return "redirect:/cuenta/iniciar_sesion";
    }

    @GetMapping("/recuperar")
    public String recoverPassword(Model model, HttpSession session) {
        return "user/autentication/recover_template";
    }

    @PostMapping("/actualizar_contrasena")
    public String updatePassword(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpSession session) {
                System.out.println(email);
                System.out.println(password);
        userServices.changePassword(email, password);

        return "user/autentication/succes_register";
    }

    @GetMapping("/prueba")
    public int prueba(HttpSession session){
        User seesionU = (User) session.getAttribute("csession");
        System.out.println("Prueba: "+seesionU.getNombre());
        return 0;
    }

    @PostMapping("/actualizarTelefono")
    public String updatePhone(@RequestParam("telefono") String telefono, HttpSession session, Model model){

        User seesionU = (User) session.getAttribute("csession");
        System.out.println("Prueba: "+seesionU.getNombre());
        userServices.updatePhoneNumber(telefono, seesionU.getId());
        return refrestpage(session, model);

    }

    @PostMapping("/actualizarCorreo")
    public String updateEmail(@RequestParam("correo") String correo, HttpSession session, Model model){
        User seesionU = (User) session.getAttribute("csession");
        System.out.println("Prueba: "+seesionU.getNombre());
        userServices.updateEmail(correo, seesionU.getId());
        return refrestpage(session, model);

    }

    @PostMapping("/actualizarDireccion")
    public String updateAddress(@RequestParam("direccion") String direccion, HttpSession session, Model model){

        User seesionU = (User) session.getAttribute("csession");
        System.out.println("Prueba: "+seesionU.getNombre());
        userServices.updateAddress(direccion, seesionU.getId());
        return refrestpage(session, model);

    }

    @PostMapping("actualizarImagen")
    public String updateImageProfeile(@RequestParam("file") MultipartFile imagen, HttpSession session, Model model){
        User seesionU = (User) session.getAttribute("csession");
        Utils.delete(seesionU.getImage());
        String imageName = Utils.guardarImagen(imagen);
        Utils.copyDirectory();
        userServices.updateProfileImage(imageName, seesionU.getId());
        return refrestpage(session, model);

    }

    public String refrestpage(HttpSession session, Model model){
        User seesionU = (User) session.getAttribute("csession");
        User u = userServices.get(seesionU.getId());
       // User u = userServices.getUserVerify(seesionU.getCorreo(), seesionU.getContrasena());
        System.out.println(u.toString());
        session.removeAttribute("csession");
        session.setAttribute("csession", u);
        model.addAttribute("client", session.getAttribute("csession"));
        return "user/client/profilev2";

    }

}


