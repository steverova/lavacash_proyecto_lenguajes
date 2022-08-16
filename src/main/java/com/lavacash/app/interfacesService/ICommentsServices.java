package com.lavacash.app.interfacesService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.lavacash.app.domain.Comentario;
import com.lavacash.app.domain.InfoComentarios;
import com.lavacash.app.interfaces.CommentsInterface;

public interface ICommentsServices {

    public boolean add(Comentario comentario);
    public List<InfoComentarios> getComments();
    public List<InfoComentarios> getCommentsPage(int page);
    public int setAvailability(int id);
    public void delete(int id);
    
}
