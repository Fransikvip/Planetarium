package Planet;

public class Moon {

    private String name;
    private Integer weight;

    public Moon(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public Moon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
