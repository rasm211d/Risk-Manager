public class RiskManagerController extends Risk{

    RiskTable rt = new RiskTable();

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

}
