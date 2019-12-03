import java.util.ArrayList;

public class RiskTable {
    private ArrayList<Risk> risks = new ArrayList<>();

    public void addRisk(Risk r){
        risks.add(r);
    }

    public void specifyRisk(Risk risk, String description, double probability, double consequence){
        if (risk == null)
            return;
        risk.specifyRisk(description, probability, consequence);
    }

    public void showRisk(Risk id) {
        //risks.get(id);
    }
}
