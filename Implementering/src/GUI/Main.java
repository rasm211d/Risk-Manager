package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene startScene;
    private Scene strategyTableScene;
    Stage stage = new Stage();

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

    /** Method for popup window to add strategy*/
    public void popupAddStrategy(javafx.event.ActionEvent actionEvent) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/addStrategy.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            stage.setTitle("Add Strategy");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    /** Method for closing popup window */
    public void exitPopup(javafx.event.ActionEvent actionEvent) throws Exception {
        stage.close();
    }
}
