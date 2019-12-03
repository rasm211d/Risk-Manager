import java.util.ArrayList;

public class StrategyTable {
    private ArrayList<Strategy> strategies = new ArrayList<>();

    public void addStrategy(Strategy strategy) {
        strategies.add(strategy);
    }

    public Strategy showStrategy() {return null;}

    public Strategy deleteStrategy() {return null;}

    public void sortByCost (double cost){}

    public void sortByResponsibility (String responsibility){}

    public void sortByDescription (String description){}

    public void specifyStrategy (Strategy strategy, String description, double cost, String responsibility) {
        if (strategy == null) {
            return;
        }
        strategy.specifyStrategy(description, cost, responsibility);
    }



}
