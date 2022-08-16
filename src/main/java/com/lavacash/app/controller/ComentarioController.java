package com.lavacash.app.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lavacash.app.domain.Comentario;
import com.lavacash.app.domain.InfoComentarios;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.CommentsServices;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private CommentsServices services;

    @PostMapping("/info")
    public String getCommentsPage(@RequestParam("page") int page, Model model) {
        LinkedList<InfoComentarios> comments = services.getCommentsPage(page);

        model.addAttribute("comentarios", comments);
        return "comentarios/comment_card";
    }

    @PostMapping("/agregar")
    public String viewComment(@RequestParam("asunto") String asunto, @RequestParam("mytextarea") String mytextarea,
            Model model, HttpSession session) {

        System.out.println(asunto + ";" + mytextarea);
        User seesionU = (User) session.getAttribute("csession");
        Comentario comment = new Comentario();
        comment.setComentario(asunto + ";" + mytextarea);
        comment.setId_user(seesionU.getId());
        comment.setDisponibilidad(1);

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        comment.setFecha(currentTime);

        System.out.println(asunto + ";" + mytextarea + ";" + comment.getFecha());
        services.add(comment);

        return "agregado";

    }

    @GetMapping("/estado/{id}")
    public String setAvailability(@PathVariable ("id") int id, Model model){
        System.out.println("\n\n\n\n#########################");
        System.out.println("viene el id: "+id);
        services.setAvailability(id);
        

        LinkedList<InfoComentarios> comments = services.getComments();
        model.addAttribute("comentarios", comments);
   
        return "user/admin/index";
    }
    
}
