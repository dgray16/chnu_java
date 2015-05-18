package controller;

import dao.Factory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LogsEntity;
import model.StudentEntity;


/**
 * Created by Administrator on 16.04.2015.
 */
public class AddStudentController {
    @FXML TextField fieldName;
    @FXML TextField fieldGroup;
    @FXML TextField fieldDepartment;

    public void addStudent(){
        StudentEntity studentEntity = new StudentEntity();
        LogsEntity logsEntity = new LogsEntity();

        studentEntity.setId(0);
        studentEntity.setName(fieldName.getText());
        studentEntity.setGroup(fieldGroup.getText());
        studentEntity.setDepartment(fieldDepartment.getText());
        logsEntity.setText("Student added");

        Factory.getInstance().<StudentEntity>getDao().add(studentEntity);
        Factory.getInstance().<LogsEntity>getDao().add(logsEntity);
        closeWindow();

    }
    public void toUpperCase(){
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

    private void closeWindow(){
        Stage stage = (Stage) fieldName.getScene().getWindow();
        stage.close();
    }
}
