module com.atmoop.demoatm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.atm to javafx.fxml;
    exports com.atm;
}