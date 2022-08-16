package com.lavacash.app.interfaces;
import com.lavacash.app.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "{call GET_USER_VERIFY(:$correo, :$contrasena)}", nativeQuery = true)
    public User getUserVerify(@Param("$correo") String correo, @Param("$contrasena") String contrasena );

    @Query(value = "{call EMAIL_EXIST(:$correo)}",nativeQuery = true)
    public int verifyMail(@Param("$correo") String correo);

    @Modifying
    @Query(value = "{call CHANGE_PASSWORD(:$correo, :$contrasena)}", nativeQuery = true)
    public void changePassword(@Param("$correo") String correo, @Param("$contrasena") String contrasena );

    @Query(value = "{call PASSWORD_VALIDATE(:$contrasena)}", nativeQuery = true)
    public int passwordValidated(@Param("$contrasena") String contrasena);

    @Query(value = "{call UppercaseFirstLetter()}", nativeQuery = true)
    public void UppercaseFirstLetter();
    

}