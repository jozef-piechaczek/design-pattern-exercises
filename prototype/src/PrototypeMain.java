import java.util.HashMap;
import java.util.Map;

abstract class City implements Cloneable {
    abstract void buildCity();

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class RockNRollCity extends City {

    @Override
    void buildCity() {
        System.out.println("We built this city, we built this city on rock an' roll\n" +
                "Built this city, we built this city on rock an' roll");
    }
}

class ParadiseCity extends City {

    @Override
    void buildCity() {
        System.out.println("Take me down to the paradise city\n" +
                "Where the grass is green and the girls are pretty");
    }
}

class SmallCountry {
    private Map<String, City> cityMap;

    SmallCountry() {
        cityMap = new HashMap<>();
        cityMap.put("rocknrollcity", new RockNRollCity());
        cityMap.put("paradisecity", new ParadiseCity());
    }

    City getCity(String name) {
        return (City)cityMap.get(name).clone();
    }
}

public class PrototypeMain {
    public static void main(String[] args) {
        SmallCountry smallCountry = new SmallCountry();
        smallCountry.getCity("paradisecity").buildCity();
        smallCountry.getCity("rocknrollcity").buildCity();
    }
}
