package controller;

import dao.Factory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.StudentEntity;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 25.02.2015.
 */
public class AddAbscentRowController implements Initializable {
    @FXML ComboBox studentsBox;
    @FXML DatePicker datePicker;

    static MainWindowController mainController2;

    public void addAbscentRow(){
        if (studentsBox.getSelectionModel().getSelectedItem() != null && datePicker.getValue() != null) {
            mainController2.add(studentsBox.getSelectionModel().getSelectedItem().toString(), datePicker.getValue());
            Stage stage = (Stage) studentsBox.getScene().getWindow();
            stage.close();
        }
        else JOptionPane.showMessageDialog(null, "Some field is empty");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<StudentEntity> studentEntityList = Factory.getInstance().<StudentEntity>getDao().getAll(StudentEntity.class);
        for (int i = 0; i < studentEntityList.size(); i++){
            studentsBox.getItems().add(studentEntityList.get(i).getName());
        }
    }
}
