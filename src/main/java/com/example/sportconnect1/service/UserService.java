package com.example.sportconnect1.service;

import com.example.sportconnect1.dao.UserDAO;
import com.example.sportconnect1.models.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public User login(String email, String password){
        User user = userDAO.getUserByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            return user;
        } else{
            return null;
        }
    }

    public boolean registerNewUser(User user){
        User user1 = userDAO.getUserByEmail(user.getEmail());
        if(user1 == null){
            userDAO.saveUser(user);
            return true;
        } else{
            return false;
        }
    }

    public void saveUser(User user){
        userDAO.saveUser(user);
    }

    public void deleteUser(User user){
        userDAO.deleteUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
