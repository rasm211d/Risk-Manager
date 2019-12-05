package Logic;

public class Strategy {

    private int id;
    private String description = "";
    private double cost = 0.0;
    private String responsibility = "";

    public Strategy(String description, double cost, String responsibility) {
        this.description = description;
        this.cost = cost;
        this.responsibility = responsibility;
    }

    public Strategy(int id, String description, double cost, String responsibility) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.responsibility = responsibility;
    }

    public void specifyStrategy(String description, double cost, String responsibility) {

        this.description = description;
        this.cost = cost;
        this.responsibility = responsibility;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}

