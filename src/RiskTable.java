import java.util.ArrayList;

public class RiskTable {
    private ArrayList<Risk> risks = new ArrayList<>();

    public Risk addRisk(){
        return null;
    }

    public void specifyRisk(Risk risk, String description, double probability, double consequence){
        if (risk == null)
            return;
        risk.specifyRisk(description, probability, consequence);
    }
}
