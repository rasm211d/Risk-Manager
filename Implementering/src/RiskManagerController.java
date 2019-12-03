import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RiskManagerController extends Application{

    RiskTable rt = new RiskTable();
    StrategyTable st = new StrategyTable();

    public void addRisk(){
        Risk newRisk = new Risk();
        rt.addRisk(newRisk);
    }

    public void specifyRisk(Risk risk, String description, double probability, double consequence){
        rt.specifyRisk(risk, description, probability, consequence); // Kan ses i sekvensdiagrammet
    }

    public void showRisk() {
        Risk riskId = new Risk();
        rt.showRisk(riskId);
    }
    public  void addStrategy() {
        Strategy newStrategy = new Strategy();
        st.addStrategy(newStrategy);
    }
    public void specifyStrategy() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Risk Manager");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
