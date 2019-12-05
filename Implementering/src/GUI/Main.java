package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    private Scene strategytableScene;
    private Scene risktableScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/start.fxml"));
        primaryStage.setTitle("Risk Manager");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /** Method for changing scenes*/
    public void changeSceneToStrategyTable(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/strategytable.fxml"));

        if (strategytableScene == null)
            strategytableScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(strategytableScene);
        primaryStage.show();
    }

    /** Method for changing scenes*/
    public void changeSceneToStart(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/start.fxml"));
        Scene startScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /** Method for changing scenes*/
    public void changeSceneToRiskTable(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/risktable.fxml"));

        if (risktableScene == null)
            risktableScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(risktableScene);
        primaryStage.show();
    }
}
