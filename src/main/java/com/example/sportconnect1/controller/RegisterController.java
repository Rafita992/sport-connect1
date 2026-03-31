package com.example.sportconnect1.controller;

import com.example.sportconnect1.models.User;
import com.example.sportconnect1.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnVolver;

    private final UserService userService = new UserService();

    @FXML
    private void handleRegistrar(){
        String nombre = name.getText().trim();
        String apellido = surname.getText().trim();
        String correo = email.getText().trim();
        String telefono = phone.getText().trim();
        String contraseña = password.getText().trim();

        if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contraseña.isEmpty()){
            System.out.println("Rellena todos los campos por favor");
            return;
        }

        if(!correo.contains("@") || !correo.contains(".")){
            System.out.println("El correo no es válido");
            return;
        }

        if(contraseña.length() < 6){
            System.out.println("La contraseña debe tener al menos 6 caracteres");
            return;
        }

        User user = new User();
        user.setName(nombre);
        user.setLastName(apellido);
        user.setEmail(correo);
        user.setPhone(telefono);
        user.setPassword(contraseña);
        user.setAdmin(false);

        if(userService.registerNewUser(user)){
            System.out.println("Cuenta creada correctamente");
            handleVolver();
        } else{
            System.out.println("Este correo ya está registrado");
        }
    }

    @FXML
    private void handleVolver(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sportconnect1/fxml/login.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
