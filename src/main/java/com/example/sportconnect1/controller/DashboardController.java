package com.example.sportconnect1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DashboardController {
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnDashboard;

    @FXML
    private Label message;

    @FXML
    private void handleName(){
        String nombre = email.getText();
        String contraseña = password.getText();
        if(nombre.isEmpty() || contraseña.isEmpty()){
            message.setText("Debes rellenar los campos");
        } else{
            message.setText("Hola, " + nombre + "!");
        }
    }
}
