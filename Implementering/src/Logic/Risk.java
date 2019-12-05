package Logic;

import java.util.ArrayList;

public class Risk {
    private int id;
    private String description = "";
    private double probability = 0.0;
    private double consequence = 0.0;
    private Strategy attachedStrategy;

    public Risk(String description, double probability, double consequence) {
        this.description = description;
        this.probability = probability;
        this.consequence = consequence;
    }

    public Risk(int id, String description, double probability, double consequence, double exposure, Strategy attachedStrategy) {
        this.id = id;
        this.description = description;
        this.probability = probability;
        this.consequence = consequence;
        this.attachedStrategy = attachedStrategy;
    }

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



    private double calculateExposure() {
        return probability * consequence;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getConsequence() {
        return consequence;
    }

    public void setConsequence(double consequence) {
        this.consequence = consequence;
    }

    public Strategy getAttachedStrategy () {
        return attachedStrategy;
    }

    public void setAttachedStrategy(Strategy attachedStrategy) {
        this.attachedStrategy = attachedStrategy;
    }
}
