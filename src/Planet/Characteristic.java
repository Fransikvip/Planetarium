package Planet;

public class Characteristic {

    private String planet;
    private Integer moonCount;
    private Integer totalWeight;
    private Integer moonWeight;

    public Characteristic(String planet, Integer moonCount, Integer totalWeight, Integer moonWeight) {
        this.planet = planet;
        this.moonCount = moonCount;
        this.totalWeight = totalWeight;
        this.moonWeight = moonWeight;
    }

    public Characteristic() {
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public Integer getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(Integer moonCount) {
        this.moonCount = moonCount;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getMoonWeight() {
        return moonWeight;
    }

    public void setMoonWeight(Integer moonWeight) {
        this.moonWeight = moonWeight;
    }
}
