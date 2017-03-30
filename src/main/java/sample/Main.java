package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.AppState;

import java.net.URL;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gry Karciane");
        FXMLLoader loader = new FXMLLoader();
        URL viewName = getClass().getResource("/");
        loader.setLocation(getClass().getResource("/mainScene.fxml"));
        Parent root = loader.load();
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

//        Map<Integer, String> map = new HashMap<>();
//        map.put(1,"jeden");
//        map.put(2,"dwa");
//        map.put(3,"trzy");
//        map.forEach((c,d)->System.out.println(c + " = " + d));
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.forEach(c->{
//            c += 2;
//            System.out.println(c);
//        });
//
//        List<List<Integer>> listOfLists = new ArrayList<>();
//        List<Integer> intList = new ArrayList<>();
//        for(int i = 0; i <5;i++){
//            intList.clear();
//            intList.add(1);
//            intList.add(2);
//            intList.add(3);
//            listOfLists.add(intList);
//        }



    }
}
