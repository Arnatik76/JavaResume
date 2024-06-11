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

public class RegistrationMenuController {
    @FXML private TextField logInTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Button signUpButton;

    public void signUp() {
        String login = logInTextField.getText();
        String password = passwordTextField.getText();

        if (login.isBlank() || password.isBlank()) {
            signUpButton.setText("Login and password must not be empty!");

             PauseTransition pause = new PauseTransition(Duration.seconds(3));
             pause.setOnFinished(event -> signUpButton.setText("Sign Up"));
             pause.play();
        } else {
            if (Client.addUser(login, password)) {
                signUpButton.setText("User registered! Redirecting to login menu...");

                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(event -> {
                    try {
                        App.setRoot("LoginMenu");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
                pause.play();
            }
            else {
                signUpButton.setText("Registration error or user is already exists!");

                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(event -> signUpButton.setText("Sign Up"));
                pause.play();
            }
        }
    }

    public void logIn() {
        try {
            App.setRoot("LoginMenu");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
