package com.atm;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;


public class Withdraw {

    public void handleWithdraw1000(ActionEvent event) throws Exception {
        withdrawAmount(1000);
    }

    public void handleWithdraw2000(ActionEvent event) throws Exception {
        withdrawAmount(2000);
    }

    public void handleWithdraw5000(ActionEvent event) throws Exception {
        withdrawAmount(5000);
    }

    public void handleWithdraw10000(ActionEvent event) throws Exception {
        withdrawAmount(10000);
    }

    public void handleWithdraw20000(ActionEvent event) throws Exception {
        withdrawAmount(20000);
    }

    public void OtherAmount(ActionEvent event) throws Exception {
            Main.switchScene("OtherAmount.fxml");
    }
    void withdrawAmount(int amount) throws Exception {
        // Read data from a CSV file
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
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Withdrawal failed");
            alert.setHeaderText(null);
            alert.setContentText("Insufficient balance");
            alert.showAndWait();
        }
    }
    public void handleMainMenu(ActionEvent event) throws Exception {
        Main.switchScene("MainMenu.fxml");
    }
}

