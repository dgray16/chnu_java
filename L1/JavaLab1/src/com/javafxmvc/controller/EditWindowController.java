package com.javafxmvc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 24.02.2015.
 */
public class EditWindowController implements Initializable{
    @FXML private TextField fieldName;
    @FXML private TextField fieldGroup;
    @FXML private TextField fieldDepartment;
    @FXML private DatePicker fieldDate;
    @FXML private Label labelID;
    static int id;
    static String name;
    static String group;
    static String department;
    static LocalDate date;
    static MainWindowController mainController1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelID.setText("ID: " + id);
        fieldName.setText(name);
        fieldGroup.setText(group);
        fieldDepartment.setText(department);
        fieldDate.setValue(date);

    }

    public void edit(){
        mainController1.edit(id, fieldName.getText(), fieldGroup.getText(), fieldDepartment.getText(), fieldDate.getValue());
        Stage stage = (Stage) fieldDate.getScene().getWindow();
        stage.close();
    }
    public void toUpperCaseName(){
        char string[] = fieldName.getText().toCharArray();
        if (string.length >= 1) {
            String symbol = String.valueOf(string[0]).toUpperCase();
            if (!String.valueOf(string[0]).equals(symbol)) {
                fieldName.setText(fieldName.getText().substring(0, 0) + symbol);
                fieldName.selectAll();
                fieldName.deselect();
            }

        }
    }
    public void toUpperCaseDepartment(){
        char string[] = fieldDepartment.getText().toCharArray();
        if (string.length >= 1) {
            String symbol = String.valueOf(string[0]).toUpperCase();
            if (!String.valueOf(string[0]).equals(symbol)) {
                fieldDepartment.setText(fieldDepartment.getText().substring(0, 0) + symbol);
                fieldDepartment.selectAll();
                fieldDepartment.deselect();
            }

        }
    }
}
