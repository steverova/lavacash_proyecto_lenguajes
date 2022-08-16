package com.lavacash.app.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lavacash.app.domain.Comentario;
import com.lavacash.app.domain.InfoComentarios;
import com.lavacash.app.domain.User;
import com.lavacash.app.services.CommentsServices;

@Controller
@RequestMapping("/pagina")
public class ComentarioRestController {

    @Autowired
    private CommentsServices services;

    @GetMapping("/comentarios")
    public String viewComments(Model model, HttpSession session) {
        model.addAttribute("client", session.getAttribute("csession"));
        return "comentarios/comments";

    }

    @GetMapping("/info")
    public ResponseEntity<LinkedList<InfoComentarios>> getComments() {
        LinkedList<InfoComentarios> comments = services.getComments();
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/info")
    public String getCommentsPage(@RequestParam("page") int page, Model model) {
        LinkedList<InfoComentarios> comments = services.getCommentsPage(page);
        model.addAttribute("comentarios", comments);
        return "comentarios/comments_card";
    }

    @PostMapping("/comentarios")
    public String viewComment(@RequestParam("asunto") String asunto, @RequestParam("mytextarea") String mytextarea,
            Model model, HttpSession session) {

        System.out.println(asunto + ";" + mytextarea);
        User seesionU = (User) session.getAttribute("csession");
        Comentario comment = new Comentario();
        comment.setComentario(asunto + ";" + mytextarea);
        comment.setId_user(seesionU.getId());
        comment.setDisponibilidad(1);

        // fecha

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        comment.setFecha(currentTime);

        System.out.println(asunto + ";" + mytextarea + ";" + comment.getFecha());
        services.add(comment);

        return "redirect:/pagina/comentarios";
    }

    @GetMapping("/estado/{id}")
    public String setAvailability(@PathVariable ("id") int id, Model model){
        System.out.println("\n\n\n\n#########################");
        System.out.println("viene el id: "+id);
        int response = services.setAvailability(id);
        

        LinkedList<InfoComentarios> comments = services.getComments();
        model.addAttribute("comentarios", comments);
   
        return "redirect:/cuenta/admin";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable ("id") int id, Model model){
        System.out.println("###############");
        System.out.println("entro a eliminar: "+id);
        services.delete(id);
        LinkedList<InfoComentarios> comments = services.getComments();
        model.addAttribute("comentarios", comments);
        return "redirect:/cuenta/admin";

    }

}
