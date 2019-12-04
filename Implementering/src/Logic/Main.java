package Logic;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/start.fxml"));
        primaryStage.setTitle("Risk Manager");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();

//        Button strategybutton = new Button();
//        strategybutton.setOnAction(value ->{});
    }



    public static void main(String[] args) {
        launch(args);
    }

    /** Method for changing scenes*/
    public void changeScreenButtonPushed(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent strategytable = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/strategytable.fxml"));
        Scene strategytableScene = new Scene(strategytable);

        // This is the line that gets the stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(strategytableScene);
        window.show();
    }
}
