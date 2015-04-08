package com.javafxmvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Administrator on 25.02.2015.
 */
public class AddWindowController {
    @FXML TextField fieldName;
    @FXML TextField fieldGroup;
    @FXML TextField fieldDepartment;
    @FXML DatePicker datePicker;
    static MainWindowController mainController2;

    public void add(){
        if (fieldName.getText() != null && fieldDepartment != null && fieldGroup != null && datePicker.getValue() != null) {
            mainController2.add(fieldName.getText(), fieldGroup.getText(), fieldDepartment.getText(), datePicker.getValue());
            Stage stage = (Stage) fieldDepartment.getScene().getWindow();
            stage.close();
        }
        else JOptionPane.showMessageDialog(null, "Some field is empty");
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
