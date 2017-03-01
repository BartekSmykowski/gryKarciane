package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.AppState;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mainScene.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        root.getStylesheets().clear();
        String cssName = getClass().getResource("/" + AppState.getThemeName() + ".css").toString();
        root.getStylesheets().add(cssName);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

//        RobotTest robotTest = new RobotTest();
//        try {
//            Thread.sleep(2000);
//        } catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        robotTest.click(2000);


    }
}
