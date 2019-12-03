import java.util.ArrayList;

public class StrategyTable {
    private ArrayList<Strategy> strategies = new ArrayList<>();

    public Strategy showStrategy() {return null;}

    public Strategy deleteStrategy() {return null;}

    public void sortStrategy (Strategy strategy, )

    public void specifyStrategy (Strategy strategy, String description, double cost, String responsibility) {
        if (strategy == null) {
            return;
        }
        strategy.specifyStrategy(description, cost, responsibility);
    }

    public Strategy addStrategy() {return null;}

}
