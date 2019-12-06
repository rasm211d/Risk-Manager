package GUI;

import DBAccess.DBRisk;
import DBAccess.Connect;
import DBAccess.DBStrategy;
import Logic.Risk;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

import static java.lang.Double.parseDouble;

public class Main extends Application {

    private Scene startScene;
    private Scene strategyTableScene;
    private Scene riskTableScene;
    Stage stage = new Stage();

    @FXML
    private javafx.scene.control.Button saveButton;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField probabilityField;

    @FXML
    private TextField consequenceField;

    @FXML
    private javafx.scene.control.TableView<Risk> TableView;

    @FXML
    private TableColumn<Risk, Integer> idColumn;

    @FXML
    private TableColumn<Risk, Double> probabilityColumn;

    @FXML
    private TableColumn<Risk, Double> consequenceColumn;

    @FXML
    private TableColumn<Risk, Double> exposureColumn;

    @FXML
    private TableColumn<Risk, String> descriptionColumn;

    @FXML
    private TableColumn<Risk, Integer> attachedStrategy;

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

    /**
     * Method for changing scenes
     */
    public void changeSceneToStart(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/start.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (startScene == null)
            startScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /**
     * Method for changing scenes
     */
    public void changeSceneToStrategyTable(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/strategytable.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (strategyTableScene == null)
            strategyTableScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(strategyTableScene);
        primaryStage.show();
    }

    /**
     * Method for changing scenes
     */
    public void changeSceneToRiskTable(javafx.event.ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/risktable.fxml"));

        // Only creates a new scene if it doesn't already exist
        if (riskTableScene == null)
            riskTableScene = new Scene(root);

        // This is the line that gets the stage information
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        primaryStage.setScene(riskTableScene);
        primaryStage.show();

//        showRisks();
    }

    /**
     * Method for popup window to add strategy
     */
    public void popupAddStrategy(javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/addStrategy.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        stage.setTitle("Add Strategy");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    /**
     * Method for popup window to add Risk
     */
    public void popupAddRisk(javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/addRisk.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        stage.setTitle("Add Risk");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void addRiskSaveButton() {

        String description = descriptionField.getText();
        double probability = parseDouble(probabilityField.getText());
        double consequence = parseDouble(consequenceField.getText());

        Risk newRisk = new Risk(description, probability, consequence);

        DBRisk.insert(newRisk);

        closePopup();
    }

    /**
     * Method for closing the popup window
     */
    public void closePopup() {
        // get a handle to the stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

//    public ObservableList<Risk> getRisksList() {
//        ObservableList<Risk> riskList = FXCollections.observableArrayList();
//
//        DBRisk dbRisk = new DBRisk();
//        dbRisk.createTable();
//
//        Risk risk = null;
//
//        String sql = "SELECT * FROM risk";
//
//        try (Connection conn = Connect.connect();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                risk = new Risk(
//                        rs.getInt("id"),
//                        rs.getString("description"),
//                        rs.getDouble("probability"),
//                        rs.getDouble("consequence"));
//                riskList.add(risk);
//
//
//
////                if (rs.getInt("attachedStrategy") != 0) {
////                    risk.setAttachedStrategy(DBStrategy.getById(rs.getInt("id")));
////                }
//
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return riskList;
//    }

//    public void showRisks() {
//        ObservableList<Risk> list = getRisksList();
//
//        idColumn.setCellValueFactory(new PropertyValueFactory<Risk,Integer>("id"));
//        probabilityColumn.setCellValueFactory(new PropertyValueFactory<Risk,Double>("sandsynlighed"));
//        consequenceColumn.setCellValueFactory(new PropertyValueFactory<Risk,Double>("konsekvens"));
//        exposureColumn.setCellValueFactory(new PropertyValueFactory<Risk,Double>("prioritet"));
//        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Risk,String>("beskrivelse"));
//        attachedStrategy.setCellValueFactory(new PropertyValueFactory<Risk,Integer>("strategi"));
//
//        TableView.setItems(list);
//    }

}
