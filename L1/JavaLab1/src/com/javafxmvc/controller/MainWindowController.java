package com.javafxmvc.controller;


import com.javafxmvc.model.entity.Student;
import com.javafxmvc.util.Const;
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
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 22.02.2015.
 */
public class MainWindowController implements Initializable{

    public static ObservableList<Student> students = FXCollections.observableArrayList();
    @FXML private TableColumn columnID;
    @FXML private TableColumn columnName;
    @FXML private TableColumn columnGroup;
    @FXML public TableView<Student> tableStudents;
    @FXML private Label labelDepartment;
    @FXML private Label labelDate;


    public void setUpTable(){
        tableStudents.setEditable(false);

        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnGroup.setCellFactory(TextFieldTableCell.forTableColumn());

        columnName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Student, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
            }
        });
        columnGroup.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Student, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
            }
        });

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
                    root = FXMLLoader.load(getClass().getResource(Const.APPLICATION_ABOUT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Const.APPLICATION_ABOUT_WINDOW_TITLE);

                Scene scene = new Scene(root, 282, 221);
                stage.setScene(scene);
                stage.getIcons().add(new Image(Const.APPLICATION_ICON_PATH));
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }
    public void actionEdit(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Const.APPLICATION_EDIT_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Const.APPLICATION_EDIT_WINDOW_TITLE);

                Scene scene = new Scene(root, 385, 290);
                stage.setScene(scene);
                stage.getIcons().add(new Image(Const.APPLICATION_ICON_PATH));
                stage.setResizable(false);
                EditWindowController.mainController1 = MainWindowController.this.getObject();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }
    public void actionDelete(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Const.APPLICATION_DELETE_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Const.APPLICATION_DELETE_WINDOW_TITLE);

                Scene scene = new Scene(root, 443, 309);
                stage.setScene(scene);
                stage.getIcons().add(new Image(Const.APPLICATION_ICON_PATH));
                stage.setResizable(false);
                DeleteWindowController.mainController = MainWindowController.this.getObject();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }
    public void actionAdd(){
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                Stage stage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource(Const.APPLICATION_ADD_WINDOW_PATH));
                } catch (IOException e) {
                }
                stage.setTitle(Const.APPLICATION_ADD_WINDOW_TITLE);

                Scene scene = new Scene(root, 443, 309);
                stage.setScene(scene);
                stage.getIcons().add(new Image(Const.APPLICATION_ICON_PATH));
                stage.setResizable(false);
                AddWindowController.mainController2 = MainWindowController.this.getObject();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(labelDate.getScene().getWindow());
                stage.showAndWait();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpTable();
        LocalDate dateTemp = LocalDate.now();
        Student student = new Student(1, "Vova Perebykivskiy", "343", "PZKS", dateTemp);
        dateTemp = LocalDate.of(2015, Month.APRIL, 13);
        Student student1 = new Student(2, "Stiven King", "342", "FPM", dateTemp);

        students.addAll(student, student1);
        tableStudents.setItems(students);

        tableStudents.setRowFactory(tv -> {
            TableRow<Student> row = new TableRow<Student>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    int id = row.getItem().getId();
                    labelDepartment.setText("Department:" + " " + tableStudents.getItems().get(id - 1).getDepartment());
                    labelDate.setText("Date:" + " " + tableStudents.getItems().get(id - 1).getDate().format(DateTimeFormatter.ofPattern(Const.TIME_PATTERN)).toString());

                    // Works when clicking, but not for first item from program start
                    EditWindowController.id = row.getItem().getId();
                    EditWindowController.name = row.getItem().getName();
                    EditWindowController.group = row.getItem().getGroup();
                    EditWindowController.department = row.getItem().getDepartment();
                    EditWindowController.date = row.getItem().getDate();
                }
            });
            return row;
        });
        labelDepartment.setText("Department:" + " " + tableStudents.getItems().get(0).getDepartment());
        labelDate.setText("Date:" + " " + tableStudents.getItems().get(0).getDate().format(DateTimeFormatter.ofPattern(Const.TIME_PATTERN)).toString());

        // Set values for first program start
        tableStudents.getSelectionModel().select(0);
        EditWindowController.id = tableStudents.getSelectionModel().getSelectedItem().getId();
        EditWindowController.name = tableStudents.getSelectionModel().getSelectedItem().getName();
        EditWindowController.group = tableStudents.getSelectionModel().getSelectedItem().getGroup();
        EditWindowController.department = tableStudents.getSelectionModel().getSelectedItem().getDepartment();
        EditWindowController.date = tableStudents.getSelectionModel().getSelectedItem().getDate();

    }

    public boolean delete(String id){
        boolean pass = true;
        try {
            if (tableStudents.getItems().get(Integer.parseInt(id) - 1).getId() == Integer.parseInt(id)) {
                students.remove(Integer.parseInt(id) - 1);
                tableStudents.setItems(students);
                labelDepartment.setText("Department:" + " " + tableStudents.getItems().get(tableStudents.getItems().size() - 1).getDepartment());
                labelDate.setText("Date:" + " " + tableStudents.getItems().get(tableStudents.getItems().size() - 1).getDate().format(DateTimeFormatter.ofPattern(Const.TIME_PATTERN)).toString());

                // Set values for edit window after deleting
                tableStudents.getSelectionModel().select(tableStudents.getItems().size() - 1);
                EditWindowController.id = tableStudents.getSelectionModel().getSelectedItem().getId();
                EditWindowController.name = tableStudents.getSelectionModel().getSelectedItem().getName();
                EditWindowController.group = tableStudents.getSelectionModel().getSelectedItem().getGroup();
                EditWindowController.department = tableStudents.getSelectionModel().getSelectedItem().getDepartment();
                EditWindowController.date = tableStudents.getSelectionModel().getSelectedItem().getDate();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No such id in list");
            pass = false;
        }
        return pass;
    }
    public void edit(int id, String name, String group, String department, LocalDate date) {
        tableStudents.getItems().get(id - 1).setName(name);
        tableStudents.getItems().get(id - 1).setGroup(group);
        tableStudents.getItems().get(id - 1).setDepartment(department);
        tableStudents.getItems().get(id - 1).setDate(date);
        labelDepartment.setText("Department:" + " " + tableStudents.getItems().get(id - 1).getDepartment());
        labelDate.setText("Date:" + " " + tableStudents.getItems().get(id - 1).getDate().format(DateTimeFormatter.ofPattern(Const.TIME_PATTERN)).toString());

        // For static editing, not ckicked row
        EditWindowController.id = tableStudents.getItems().get(id - 1).getId();
        EditWindowController.name = tableStudents.getItems().get(id - 1).getName();
        EditWindowController.group = tableStudents.getItems().get(id - 1).getGroup();
        EditWindowController.department = tableStudents.getItems().get(id - 1).getDepartment();
        EditWindowController.date = tableStudents.getItems().get(id - 1).getDate();

        setUpTable();
    }
    public void add(String name, String group, String department, LocalDate date){
        Student student3 = new Student(tableStudents.getItems().size() + 1, name, group, department, date);
        students.add(student3);
    }
    public MainWindowController getObject(){
        return this;
    }

}
