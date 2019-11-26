public class Risk {
    private String description = "";
    private double probability = 0.0;
    private double consequence = 0.0;
    private double exposure = 0.0;

    public void specifyRisk(String description, double probability, double consequence) {
        if (probability < 0.0 || probability > 1.0)
            // throw exception
            throw new InvalidProbabilityValueException();
        if (consequence <= 0.0 || consequence > 20.0)
            // throw exception
            throw new InvalidConsequenceValueException();

    }

    private void calculateExposure() {

    }
}
