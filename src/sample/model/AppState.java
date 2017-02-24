package sample.model;


import javafx.stage.Stage;

public class AppState {
    private static String appTheme = "Dark";
    private static String sceneName = "mainScene";

    public static void changeTheme(String themeTheme){
        appTheme = themeTheme;
    }

    public static String getThemeName(){
        return appTheme;
    }

    public static void setScene(String sceneName, Stage stage){

    }
}