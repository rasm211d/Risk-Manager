package Logic;

public class Strategy {

    private String description = "";
    private double cost = 0.0;
    private String responsibility = "";

    public void specifyStrategy(String description, double cost, String responsibility) {

        this.description = description;
        this.cost = cost;
        this.responsibility = responsibility;

    }
}

