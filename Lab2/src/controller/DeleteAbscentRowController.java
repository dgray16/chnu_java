package controller;

import dao.Factory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AbscentEntity;
import model.LogsEntity;


/**
 * Created by Administrator on 15.04.2015.
 */
public class DeleteAbscentRowController {
    @FXML private TextField fieldID;
    @FXML private Button sendDataButton;

    public void showButton(){
        sendDataButton.setVisible(true);
    }
    public void deleteAbscentRow(){
        AbscentEntity abscentEntity = new AbscentEntity();
        LogsEntity logsEntity = new LogsEntity();
        if (!fieldID.getText().equals("")){
            abscentEntity.setId(Integer.parseInt(fieldID.getText()));
            logsEntity.setText("Abscent row deleted");
            Factory.getInstance().<LogsEntity>getDao().add(logsEntity);
            Factory.getInstance().<AbscentEntity>getDao().delete(abscentEntity);
        }
    }
}
