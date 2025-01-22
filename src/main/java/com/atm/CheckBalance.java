package com.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CheckBalance {
    @FXML
    private Label balance;

    @FXML
    public void initialize() throws Exception {
        try{
            String[] data = Main.readData();
            balance.setText(data[3] + " Taka");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void handleBack(ActionEvent event) {
        try {
            Main.switchScene("MainMenu.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

