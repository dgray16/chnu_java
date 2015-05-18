package controller;

import dao.Factory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AbscentEntity;
import model.LogsEntity;
import model.StudentEntity;
import model.TableEntity;
import sun.security.x509.AVA;
import util.Constant;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 22.02.2015.
 */
public class MainWindowController implements Initializable{

    private AbscentEntity abscentEntity = new AbscentEntity();
    private LogsEntity logsEntity = new LogsEntity();
    private ObservableList<TableEntity> correctAbscentList = FXCollections.observableArrayList();

    @FXML private TableColumn columnID;
    @FXML private TableColumn columnName;
    @FXML private TableColumn columnGroup;
    @FXML public TableView<TableEntity> abscentStudentsTable;
    @FXML private Label labelDepartment;
    @FXML private Label labelDate;

    public void setUpTable(){
        abscentStudentsTable.setEditable(false);
        columnID.setCellValueFactory(new PropertyValueFactory("id"));
        columnName.setCellValueFactory(new PropertyValueFactory("name"));
        columnGroup.setCellValueFactory(new PropertyValueFactory("group"));
    }
    public void actionAbout(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_ABOUT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_ABOUT_WINDOW_TITLE);
                Scene scene = new Scene(root, 282, 221);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }

    public void editStudent(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_EDIT_STUDENT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_EDIT_STUDENT_WINDOW_TITLE);

                Scene scene = new Scene(root, 550, 290);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        abscentStudentsTable.getItems().clear();
                        setUpMainTable();
                    }
                });
                stage.showAndWait();
            }
        });
    }
    public void deleteStudent(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_DELETE_STUDENT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_DELETE_STUDENT_WINDOW_TITLE);
                Scene scene = new Scene(root, 390, 220);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }
    public void addStudent(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_ADD_STUDENT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_ADD_STUDENT_WINDOW_TITLE);

                Scene scene = new Scene(root, 443, 309);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }

    public void addAbscentStudent(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_ADD_ABSCENT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_ADD_ABSCENT_WINDOW_TITLE);

                Scene scene = new Scene(root, 443, 309);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                AddAbscentRowController.mainController2 = getObject();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        abscentStudentsTable.getItems().clear();
                        setUpMainTable();
                    }
                });
                stage.showAndWait();
            }
        });
    }
    public void deleteAbscentStudent(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_DELETE_ABSCENT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Constant.APPLICATION_DELETE_ABSCENT_WINDOW_TITLE);
                Scene scene = new Scene(root, 450, 220);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        abscentStudentsTable.getItems().clear();
                        setUpMainTable();
                    }
                });
                stage.showAndWait();
            }
        });
    }
    private void setUpMainTable(){
        setUpTable();
        List<StudentEntity> studentEntityList = Factory.getInstance().<StudentEntity>getDao().getAll(StudentEntity.class);
        List<AbscentEntity> abscentEntityList = Factory.getInstance().<AbscentEntity>getDao().getAll(AbscentEntity.class);

        for (int i = 0; i < abscentEntityList.size(); i++){
            TableEntity tableEntity = new TableEntity();
            tableEntity.setId(abscentEntityList.get(i).getId());
            tableEntity.setName(abscentEntityList.get(i).getStudentByStudentId().getName());
            tableEntity.setGroup(abscentEntityList.get(i).getStudentByStudentId().getGroup());
            tableEntity.setDepartment(abscentEntityList.get(i).getStudentByStudentId().getDepartment());
            tableEntity.setDate(abscentEntityList.get(i).getDate());
            correctAbscentList.addAll(tableEntity);
        }
        abscentStudentsTable.setItems(correctAbscentList);


        labelDepartment.setText("Department:" + " " + abscentStudentsTable.getItems().get(0).getDepartment());
        labelDate.setText("Date:" + " " + abscentStudentsTable.getItems().get(0).getDate().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpMainTable();

        abscentStudentsTable.setRowFactory(tv -> {
            TableRow<TableEntity> row = new TableRow<TableEntity>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    int id = row.getItem().getId();
                    for (int i = 0; i < correctAbscentList.size(); i++) {
                        if (correctAbscentList.get(i).getId() == id) {
                            labelDepartment.setText("Department:" + " " + correctAbscentList.get(i).getDepartment());
                            labelDate.setText("Date:" + " " + correctAbscentList.get(i).getDate().toString());
                        }
                    }
                }
            });
            return row;
        });

        // Set values for first program start
        abscentStudentsTable.getSelectionModel().select(0);
    }

    public void add(String studentName, LocalDate date){
        /*Student student3 = new Student(tableStudents.getItems().size() + 1, name, group, department, date);
        students.add(student3);*/

        // Conver LocalDate to sql.Date
        Date date1 = Date.valueOf(date);

        List<StudentEntity> studentEntityList = Factory.getInstance().<StudentEntity>getDao().getAll(StudentEntity.class);
        for (int i = 0; i < studentEntityList.size(); i++){
            if (studentEntityList.get(i).getName().equals(studentName)){
                abscentEntity.setStudentId(studentEntityList.get(i).getId());
                abscentEntity.setDate(date1);
                break;
            }
        }
        logsEntity.setText("Abscent row added");
        Factory.getInstance().<AbscentEntity>getDao().add(abscentEntity);
        Factory.getInstance().<LogsEntity>getDao().add(logsEntity);
        abscentStudentsTable.getItems().clear();
        setUpMainTable();
    }
    public void sendDataToServer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int serverPort = 1234;
        String serverAddress = "127.0.0.1";

        try{
            InetAddress ipAddress = InetAddress.getByName(serverAddress);
            Socket socket = new Socket(ipAddress, serverPort);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


            dataOutputStream.writeUTF("ID: " + abscentStudentsTable.getSelectionModel().getSelectedItem().getId());
            dataOutputStream.flush();
            String incomeMsg = dataInputStream.readUTF();
            alert.setHeaderText(incomeMsg);
            alert.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

        abscentStudentsTable.getSelectionModel().getSelectedItem().getId();
        abscentStudentsTable.getSelectionModel().getSelectedItem().getName();
    }
    public MainWindowController getObject(){
        return this;
    }
}
