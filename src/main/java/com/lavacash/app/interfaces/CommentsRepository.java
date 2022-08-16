package com.lavacash.app.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lavacash.app.domain.Comentario;
import com.lavacash.app.domain.InfoComentarios;


@Repository
public interface CommentsRepository  extends JpaRepository<Comentario, Integer>{
    

    @Query(value = "{call GET_COMMENTS_CLIENTS2}", nativeQuery = true)
    List<CommentsInterface> getComments();

    @Query(value = "{call GET_COMMENTS_CLIENTS_PAGE(:$page)}", nativeQuery = true)
    List<CommentsInterface> getCommentspage(@Param("$page") int page);

    @Query(value = "{CALL UPDATE_AVAILABILITY(:$id)}", nativeQuery = true)
    public int setAvailability(@Param("$id") int id);


    
    
}
