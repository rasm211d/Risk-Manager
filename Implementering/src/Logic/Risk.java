package Logic;

import java.util.ArrayList;

public class Risk {
    private int id;
    private String description = "";
    private double probability = 0.0;
    private double consequence = 0.0;
    private double exposure = 0.0;
    private Strategy attachedStrategy;

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


    public void attachStrategy(Strategy strategy) {
        attachedStrategy = strategy;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getProbability() {
        return probability;
    }

    public double getConsequence() {
        return consequence;
    }

    public double getExposure() {
        return exposure = consequence * probability;
    }




}
