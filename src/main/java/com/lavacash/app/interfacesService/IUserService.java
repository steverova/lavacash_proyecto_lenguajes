package com.lavacash.app.interfacesService;

import com.lavacash.app.domain.User;
import java.util.List;


public interface IUserService {

    public List<User> getAll();
    public User get(int id);
    public void add(User u);
    public User getUserVerify(String correo, String contrasena);
    public int verifyEmail(String correo);
    public void changePassword(String correo, String contrasena);
    public int changePasswordProfile(String contrasena,int id);
    public int updatePhoneNumber(String number, int id);
    public int updateAddress(String address,int id);
    public int updateEmail(String email,int id);
    public int validatePassword(String password);
    public int updateProfileImage(String imagename, int id);

}
