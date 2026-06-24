package com.example.sportconnect1.controller;

import com.example.sportconnect1.models.User;
import com.example.sportconnect1.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegister;
    @FXML
    private Label message;

    private final UserService userService = new UserService();

    @FXML
    private void handleLogin(){
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if(email.isEmpty() || password.isEmpty()){
            message.setText("Por favor rellena todos los campos");
        }
        try {
            User user = userService.login(email, password);

            if(user != null){
                if(user.getAdmin()){
                    navigateToDashboard(user);
                } else{
                    navigateToHomeUser(user);
                }
            } else{
                message.setText("El correo o contraseña han sido incorrectos");
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo conectar con el servidor");
            e.printStackTrace();
        }
    }

    private void navigateToDashboard(User user){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sportconnect1/fxml/dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            DashboardController controller = loader.getController();
            //controller.setUser(user);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateToHomeUser(User user){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sportconnect1/fxml/home-user.fxml"));
            Scene scene = new Scene(loader.load());
            UserHomeController controller = loader.getController();
            //controller.setUser(user);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegister(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sportconnect1/fxml/register.fxml"));
            Scene scene = new Scene(loader.load());
            RegisterController controller = loader.getController();
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
