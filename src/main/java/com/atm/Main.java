package com.atm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Visa.fxml")));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("ATM Interface");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void switchScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxmlFile)));
        primaryStage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
        //System.out.println("javafx.version: " + System.getProperty("javafx.version"));
    }

    //CSV file reader
    public static String[] readData() {
        String path = "src/main/resources/com/atm/cardrecords.csv";
        String[] data = new String[5];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "";
            // read the line where account number is found
            while (line != null) {
                String[] fields = line.split(",");
                if (Objects.equals(fields[0], Visa.account)) {
                    data = fields;
                    //System.out.println(data[0]);
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void writeData(String[] data) {
        String path = "src/main/resources/com/atm/cardrecords.csv";
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (Objects.equals(fields[0], Visa.account)) {
                    lines.add(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4]);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}