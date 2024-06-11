package com.prj.controllers;

import com.prj.App;

import com.prj.Client;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;

public class LoginMenuController {
    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Button signInButton;

    public void SignIn() {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        if (login.isBlank() || password.isBlank()) {
            signInButton.setText("Login and password must not be empty!");

            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> signInButton.setText("Sign In"));
            pause.play();
        } else {
            if (Client.checkPasswordAndLogin(login, password)) {
                try {
                    App.setRoot("Main");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                signInButton.setText("Incorrect login or password!");

                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(event -> signInButton.setText("Sign In"));
                pause.play();
            }
        }
    }

    public void registration() {
        try {
            App.setRoot("RegistrationMenu");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
