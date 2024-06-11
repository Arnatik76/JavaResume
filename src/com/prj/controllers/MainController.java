package com.prj.controllers;

import com.prj.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.util.ArrayList;

public class MainController {
    @FXML
    private TextField searchTextField;
    @FXML private ListView<String> booksListView;

    public void initialize() {
        booksListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            Button button = new Button(item);
                            button.setOnAction(event -> {
                                // Здесь ваш код для обработки нажатия на кнопку
                                System.out.println("Button clicked: " + item);
                            });
                            setGraphic(button);
                        }
                    }
                };
            }
        });
    }

    public void updateBookList() {
        ArrayList<String> list = Client.getGenreList();
        for (int i = 0; i < booksListView.getItems().size(); i++) {

        }
    }

    public void searchBook() {
        String search = searchTextField.getText();
        // search in database
    }
}
