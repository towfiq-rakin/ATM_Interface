package com.atm;

import javafx.event.ActionEvent;

public class MainMenu {
    public void handleCheckBalance(ActionEvent event) throws Exception {
        CheckBalance checkBalance = new CheckBalance();
        checkBalance.initialize();
        Main.switchScene("CheckBalance.fxml");
    }

    public void handleDeposit(ActionEvent event) throws Exception {
        Main.switchScene("Deposit.fxml");
    }

    public void handleWithdraw(ActionEvent event) throws Exception {
        Main.switchScene("Withdraw.fxml");
    }

    public void handleExit(ActionEvent event) {
        System.exit(0);
    }

    public void handleLogout(ActionEvent event) throws Exception {
        Main.switchScene("Visa.fxml");
    }

    public void handleTransfer(ActionEvent event) throws Exception {
        Main.switchScene("Transfer.fxml");
    }

    public void handleChangePin(ActionEvent event) throws Exception {
        Main.switchScene("ChangePin.fxml");
    }

    public void handleStatement(ActionEvent event) throws Exception {
        Statement statement = new Statement();
        statement.initialize();
        Main.switchScene("Statement.fxml");
    }

}
