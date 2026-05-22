package com.example.gamingcafe.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {

    @FXML private BorderPane contentArea;
    @FXML private Button navMain;
    @FXML private Button navWorkstations;

    private Button activeButton;

    private enum View {
        WORKSTATIONS("WorkstationsView.fxml");

        final String fxmlPath;
        View(String fxmlPath) { this.fxmlPath = fxmlPath; }
    }

    @FXML
    public void initialize() {
        activeButton = navMain;
        loadView(View.WORKSTATIONS);
        setActiveButton(navWorkstations);
    }

    @FXML
    private void onNavMain() {
        // TODO korak 5: zamijeniti s DASHBOARD
        loadView(View.WORKSTATIONS);
        setActiveButton(navMain);
    }

    @FXML
    private void onNavWorkstations() {
        loadView(View.WORKSTATIONS);
        setActiveButton(navWorkstations);
    }

    private void loadView(View view) {
        try {
            String path = "/com/example/gamingcafe/fxml/" + view.fxmlPath;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node node = loader.load();
            contentArea.setCenter(node);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading view: " + view.fxmlPath, e);
        }
    }

    private void setActiveButton(Button button) {
        if (activeButton != null) {
            activeButton.getStyleClass().remove("nav-button-active");
            if (!activeButton.getStyleClass().contains("nav-button")) {
                activeButton.getStyleClass().add("nav-button");
            }
        }
        button.getStyleClass().remove("nav-button");
        if (!button.getStyleClass().contains("nav-button-active")) {
            button.getStyleClass().add("nav-button-active");
        }
        activeButton = button;
    }
}