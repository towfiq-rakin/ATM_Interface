package com.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Objects;

public class Visa {
    @FXML
    private TextField accountField;

    public static String account = "";
    @FXML
    public void handleLogin(ActionEvent event) throws Exception {
        account = accountField.getText();
        boolean isvalid = cardCheck(account);
        if (isvalid) {
            String[] data = Main.readData();
            if (Objects.equals(data[0], account)) {
                Main.switchScene("Pin.fxml");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Card not found.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Card number.");
            alert.showAndWait();
        }
    }

    public boolean cardCheck(String account) {
        // lunh algorithm
        int nDigits = account.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = account.charAt(i) - '0';
            if (isSecond == true)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }
}

