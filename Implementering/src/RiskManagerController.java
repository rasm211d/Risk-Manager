public class RiskManagerController{

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


}
