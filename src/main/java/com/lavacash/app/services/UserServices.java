package com.lavacash.app.services;

import com.lavacash.app.domain.Role;
import com.lavacash.app.domain.User;
import com.lavacash.app.interfaces.UserRepository;
import com.lavacash.app.interfacesService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServices implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public User get(int id) {
        return repo.findById(id).get();
    }

    @Override
    public void add(User u) {
        u.setRol(Role.CLIENT.toString());
       repo.save(u);
       //repo.UppercaseFirstLetter();
    }

    @Override
    public User getUserVerify(String correo, String contrasena) {
        return repo.getUserVerify(correo, contrasena);
        
    }

    @Override
    public int verifyEmail(String correo) {
        return repo.verifyMail(correo);
    }

    @Override
    public void changePassword(String correo, String contrasena) {
        repo.changePassword(correo, contrasena);
        
    }

    @Override
    public int changePasswordProfile(String contrasena, int id) {
        User u = repo.findById(id).get();
        u.setContrasena(contrasena);
        u.setContrasena_(contrasena);
        repo.save(u);
        return 0;
    }

    @Override
    public int updatePhoneNumber(String number,int id) {
        User u = repo.findById(id).get();
        u.setTelefono(number);
        repo.save(u);
        return 0;
    }

    @Override
    public int updateAddress(String address,int id) {
        User u = repo.findById(id).get();
        u.setDireccion(address);
        repo.save(u);
        return 0;
    }

    @Override
    public int updateEmail(String email,int id) {
        User u = repo.findById(id).get();
        u.setCorreo(email);
        repo.save(u);
        return 0;
    }

    @Override
    public int validatePassword(String password) {
        return repo.passwordValidated(password);
    }

    @Override
    public int updateProfileImage(String imagename, int id) {
        User u = repo.findById(id).get();
        u.setImage(imagename);
        repo.save(u);
        return 0;
    }

    
}
