package com.atm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Statement  {
    @FXML
    private  Label name;
    @FXML
    private  Label account;
    @FXML
    private  Label balance;
    @FXML
    private  Label type;

    public  void  initialize()  {
        String[] data = Main.readData();
        System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
        setLabels(data);
    }

    @FXML
    private void setLabels(String[] data) {
        try{
            account.setText(data[0]);
            name.setText(data[1]);
            balance.setText(data[3] + " Taka");
            type.setText(data[4]);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void handleBack() throws Exception {
        Main.switchScene("MainMenu.fxml");
    }
}
