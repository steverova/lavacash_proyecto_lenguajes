package com.lavacash.app.services;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavacash.app.domain.Comentario;
import com.lavacash.app.domain.InfoComentarios;
import com.lavacash.app.interfaces.CommentsInterface;
import com.lavacash.app.interfaces.CommentsRepository;
import com.lavacash.app.interfacesService.ICommentsServices;

@Service
public class CommentsServices implements ICommentsServices {

    private CommentsRepository repo;

    public CommentsServices(CommentsRepository repo){
        this.repo = repo;
    }

    @Override
    public boolean add(Comentario comentario) {
        repo.save(comentario);
        return false;
    }

    @Override
    public LinkedList<InfoComentarios> getComments() {
        List<CommentsInterface> listComments = this.repo.getComments();
        return getInfo(listComments);
    }

    @Override
    public LinkedList<InfoComentarios> getCommentsPage(int page) {
        List<CommentsInterface> listComments = this.repo.getCommentspage(page);
        return getInfopage(listComments);
    }

    private LinkedList<InfoComentarios> getInfo(List<CommentsInterface> listComments){

        LinkedList<InfoComentarios> lista = new LinkedList<>();

        listComments.forEach(
            comments -> lista.add(
                new InfoComentarios(
                    comments.getId_comentario(),
                    comments.getId(),
                    comments.getNombre(),
                    comments.getApellido(),
                    comments.getImage(),
                    comments.getComentario(),
                    comments.getDisponibilidad()
                )
            )
           
        );
        return lista;
    }

    private LinkedList<InfoComentarios> getInfopage(List<CommentsInterface> listComments){

        LinkedList<InfoComentarios> lista = new LinkedList<>();

        listComments.forEach(
            comments -> lista.add(
                new InfoComentarios(
                    comments.getId(),
                    comments.getNombre(),
                    comments.getApellido(),
                    comments.getImage(),
                    comments.getComentario(),
                    comments.getDisponibilidad()
                )
            )
           
        );
        return lista;
    }
    

    @Override
    public int setAvailability(int id) {
        System.out.println("\n\n\n\n#########################");
        System.out.println("\n\n\n\n###########  SERVICES ##############");
        System.out.println("\n\n\n\n#########################");
        int response = this.repo.setAvailability(id);
        return response;
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
        
    }

}
