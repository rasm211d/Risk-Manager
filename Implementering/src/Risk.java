import java.util.ArrayList;

public class Risk {
    private String description = "";
    private double probability = 0.0;
    private double consequence = 0.0;
    private double exposure = 0.0;
    private ArrayList<Strategy> strategies = new ArrayList<>();

    public void specifyRisk(String description, double probability, double consequence) {
        if (probability < 0.0 || probability > 1.0)
            // throw exception
            throw new InvalidProbabilityValueException();
        if (consequence <= 0.0 || consequence > 20.0)
            // throw exception
            throw new InvalidConsequenceValueException();

        this.description = description;
        this.probability = probability;
        this.consequence = consequence;

        calculateExposure();
    }

    private void calculateExposure() {
        exposure = probability * consequence;
    }
}
