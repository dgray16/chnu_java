package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dao.Factory;
import model.LogsEntity;
import model.StudentEntity;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 16.04.2015.
 */
public class EditStudentController implements Initializable {
    @FXML ComboBox studentsBox;
    @FXML Label nameLabel;
    @FXML Label groupLabel;
    @FXML Label departmentLabel;
    @FXML TextField nameField;
    @FXML TextField groupField;
    @FXML TextField departmentField;
    @FXML Button sendDataButton;

    private List<StudentEntity> studentEntityList = Factory.getInstance().<StudentEntity>getDao().getAll(StudentEntity.class);
    private int iterator = -1;

    public void toUpperCase(){
        char string[] = nameField.getText().toCharArray();
        if (string.length >= 1) {
            String symbol = String.valueOf(string[0]).toUpperCase();
            if (!String.valueOf(string[0]).equals(symbol)) {
                nameField.setText(nameField.getText().substring(0, 0) + symbol);
                nameField.selectAll();
                nameField.deselect();
            }
        }
    }
    public void saveStudent(){
        StudentEntity studentEntity = new StudentEntity();
        LogsEntity logsEntity = new LogsEntity();

        studentEntity.setId(iterator);
        studentEntity.setName(nameField.getText());
        studentEntity.setGroup(groupField.getText());
        studentEntity.setDepartment(departmentField.getText());

        logsEntity.setText("Edited student row");

        Factory.getInstance().<StudentEntity>getDao().update(studentEntity);
        Factory.getInstance().<LogsEntity>getDao().add(logsEntity);
    }
    public void showFields(){
        nameLabel.setVisible(true);
        nameField.setVisible(true);
        groupLabel.setVisible(true);
        groupField.setVisible(true);
        departmentLabel.setVisible(true);
        departmentField.setVisible(true);
        sendDataButton.setVisible(true);
        setFieldsData();
    }

    private void setFieldsData(){
        for (int i = 0; i < studentEntityList.size(); i++){
            if (studentEntityList.get(i).getName().equals(studentsBox.getSelectionModel().getSelectedItem().toString())){
                nameField.setText(studentEntityList.get(i).getName());
                groupField.setText(studentEntityList.get(i).getGroup());
                departmentField.setText(studentEntityList.get(i).getDepartment());
                iterator = studentEntityList.get(i).getId();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < studentEntityList.size(); i++){
            studentsBox.getItems().add(studentEntityList.get(i).getName());
        }
    }
}
