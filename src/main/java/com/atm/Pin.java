package com.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Objects;

public class Pin {
    @FXML
    private PasswordField pinField;

    @FXML
    public void handlePin(ActionEvent event) throws Exception {
        String pin = pinField.getText();
        String[] data = Main.readData();

        if (Objects.equals(data[2], pin)) {
                Main.switchScene("MainMenu.fxml");
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid PIN number. Please try again.");
            alert.showAndWait();
        }
    }

}
