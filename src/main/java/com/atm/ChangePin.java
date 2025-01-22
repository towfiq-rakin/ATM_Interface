package com.atm;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.util.Objects;

public class ChangePin {
    @FXML
    private PasswordField oldPinField;
    @FXML
    private PasswordField newPinField;
    @FXML
    private PasswordField confirmPinField;

    public void handlConfirm() throws Exception {
        String oldPin = oldPinField.getText();
        String newPin = newPinField.getText();
        String confirmPin = confirmPinField.getText();
        if(newPin.length() != 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid PIN");
            alert.setHeaderText(null);
            alert.setContentText("PIN should be 4 digits long.");
            alert.showAndWait();
        }
        String[] data = Main.readData();
        if (Objects.equals(data[2], oldPin) && Objects.equals(newPin, confirmPin)) {
            data[2] = newPin;
            Main.writeData(data);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PIN Changed");
            alert.setHeaderText(null);
            alert.setContentText("Your PIN has been changed successfully.");
            alert.showAndWait();
            Main.switchScene("MainMenu.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid PIN");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Pin Number.");
            alert.showAndWait();
        }
    }

    public void handleCancel() throws Exception {
        Main.switchScene("MainMenu.fxml");
    }
}
