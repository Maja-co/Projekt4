package Model;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private String name;
    private String mobilNumber;
    private List<Bestilling> bestillinger;

    public Kunde(String name, String mobilNumber) {
        this.name = name;
        this.mobilNumber = mobilNumber;
        this.bestillinger = new ArrayList<>();
    }

    public void addBestilling(Bestilling order) {
        if (order != null) {
            bestillinger.add(order);
        }
    }

    public String getName() {
        return name;
    }

    public String getMobilNumber() {
        return mobilNumber;
    }

    public List<Bestilling> getBestillinger() {
        return bestillinger;
    }

    @Override
    public String toString() {
        return name + " - " + mobilNumber;
    }
}
