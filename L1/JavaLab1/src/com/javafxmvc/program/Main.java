package com.javafxmvc.program;

import com.javafxmvc.model.entity.Student;
import com.javafxmvc.util.Const;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Administrator on 22.02.2015.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Const.APPLICATION_MAIN_WINDOW_PATH));
        primaryStage.setTitle(Const.APPLICATION_MAIN_WINDOW_TITLE);

        Scene scene = new Scene(root, 590, 400);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(Const.APPLICATION_ICON_PATH));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}
