package com.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Deposit {
    @FXML
    private TextField depositField;

    public void submit() throws Exception {
        int amount = Integer.parseInt(depositField.getText());
        // Deposit amount should be multiple of 500
        if(amount % 500 == 0 && amount <= 100000){
            String[] data = Main.readData();
            int balance = Integer.parseInt(data[3]);
            balance += amount;
            data[3] = String.valueOf(balance);
            Main.writeData(data);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deposit successful");
            alert.setHeaderText(null);
            alert.setContentText("Your new balance is: " + balance + " Taka");
            alert.showAndWait();
            Main.switchScene("MainMenu.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Withdrawal failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Amount. Please enter a multiple of 500.");
            alert.showAndWait();
        }
    }

    public void handleBack(ActionEvent event) throws Exception {
        Main.switchScene("MainMenu.fxml");
    }
}
