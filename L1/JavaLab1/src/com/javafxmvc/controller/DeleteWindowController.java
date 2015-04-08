package com.javafxmvc.controller;

import com.javafxmvc.util.Const;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;


/**
 * Created by Administrator on 23.02.2015.
 */
public class DeleteWindowController{
    @FXML private TextField fieldID;
    @FXML private TextField fieldCaptcha;
    static MainWindowController mainController;

    public void delete(){
        String id = "0";
        Stage stage = (Stage) fieldID.getScene().getWindow();
        if (fieldCaptcha.getText().equals("yes")){
            if (fieldID.getText().trim().matches(Const.ID_PATTERN)) {
                id = fieldID.getText();
                if (mainController.delete(id) == true) {
                    stage.close();
                }
            }
            else JOptionPane.showMessageDialog(null, "ID contains not a number element or too many numbers");
        }
        else JOptionPane.showMessageDialog(null, "Please write correctly yes");
    }
}
