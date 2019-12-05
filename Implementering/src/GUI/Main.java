package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene startScene;
    private Scene strategyTableScene;
    private Scene addStrategyScene;

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
    public void changeSceneToStart(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/start.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (startScene == null)
            startScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /** Method for changing scenes*/
    public void changeSceneToStrategyTable(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/strategytable.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (strategyTableScene == null)
            strategyTableScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(strategyTableScene);
        primaryStage.show();
    }

    /** Method for changing scenes*/
    public void changeSceneToAddStrategy(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/addStrategy.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (addStrategyScene == null)
            addStrategyScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(addStrategyScene);
        primaryStage.show();
    }
}
