public class RiskManagerController {

    RiskTable rt = new RiskTable();

    public Risk addRisk(){
        return null;
    }

    public void specifyRisk(Risk risk, String description, double probability, double consequence){
        rt.specifyRisk(risk, description, probability, consequence); // Kan ses i sekvensdiagrammet

    }
}
