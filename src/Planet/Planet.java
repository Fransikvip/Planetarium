package Planet;

import java.util.List;

public class Planet {

    private String name;
    private Integer weight;
    private List<Moon> moons;

    public Planet(String name, Integer weight, List<Moon> moons) {
        this.name = name;
        this.weight = weight;
        this.moons = moons;
    }

    public Planet() {

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

    public List<Moon> getMoons() {
        return moons;
    }

    public void setMoons(List<Moon> moons) {
        this.moons = moons;
    }
}
