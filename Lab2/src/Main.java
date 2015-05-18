import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Constant;

/**
 * Created by Administrator on 22.02.2015.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Constant.APPLICATION_MAIN_WINDOW_PATH));
        primaryStage.setTitle(Constant.APPLICATION_MAIN_WINDOW_TITLE);

        Scene scene = new Scene(root, 590, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}