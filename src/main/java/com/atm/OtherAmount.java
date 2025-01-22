package com.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class OtherAmount {
    @FXML
    private TextField otherAmountField;

    public void submit(ActionEvent event) throws Exception {
        // Amount should be multiple of 500
        int amount = Integer.parseInt(otherAmountField.getText());
        if (amount % 500 == 0) {
            String[] data = Main.readData();
            int balance = Integer.parseInt(data[3]);
            if (balance >= amount) {
                balance -= amount;
                data[3] = String.valueOf(balance);
                Main.writeData(data);
                //Main.switchScene("Receipt.fxml");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Withdrawal successful");
                alert.setHeaderText("Please take your cash.");
                alert.setContentText("Your new balance is: " + balance + " Taka");
                alert.showAndWait();
                Main.switchScene("MainMenu.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Withdrawal failed");
                alert.setHeaderText(null);
                alert.setContentText("Insufficient balance");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Withdrawal failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Amount. Please enter a multiple of 500.");
            alert.showAndWait();
        }
    }
    public void handleCancel(ActionEvent event) throws Exception {
            Main.switchScene("MainMenu.fxml");
    }
}
