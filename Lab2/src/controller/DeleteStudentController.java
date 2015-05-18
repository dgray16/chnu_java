package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import dao.Factory;
import model.AbscentEntity;
import model.LogsEntity;
import model.StudentEntity;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 15.04.2015.
 */
public class DeleteStudentController implements Initializable {
    @FXML private ComboBox studentsBox;
    @FXML private Button sendDataButton;

    private List<StudentEntity> studentEntityList = Factory.getInstance().<StudentEntity>getDao().getAll(StudentEntity.class);

    public void deleteStudent(){
        StudentEntity studentEntity = new StudentEntity();
        LogsEntity logsEntity = new LogsEntity();
        for (int i = 0; i < studentEntityList.size(); i++ ){
            if (studentEntityList.get(i).getName().equals(studentsBox.getSelectionModel().getSelectedItem().toString())){
                int iterator = i;
                studentEntity.setId(studentEntityList.get(iterator).getId());
                logsEntity.setText("Student row deleted");
                break;
            }
        }
        Factory.getInstance().<StudentEntity>getDao().delete(studentEntity);
        Factory.getInstance().<LogsEntity>getDao().add(logsEntity);
    }
    public void showButton(){
        sendDataButton.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < studentEntityList.size(); i++){
            studentsBox.getItems().add(studentEntityList.get(i).getName());
        }

    }
}
