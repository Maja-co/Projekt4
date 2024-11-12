package Storage;

import Model.Forestilling;
import Model.Kunde;
import Model.Plads;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Forestilling> forestillinger = new ArrayList<>();
    private static List<Kunde> kunder = new ArrayList<>();
    private static List<Plads> pladser = new ArrayList<>();

    public static void addForestilling(Forestilling forestilling) {
        if (forestilling != null) {
            forestillinger.add(forestilling);
        }
    }

    public static void addKunde(Kunde kunde) {
        if (kunde != null) {
            kunder.add(kunde);
        }
    }

    public static void addPlads(Plads plads) {
        if (plads != null) {
            pladser.add(plads);
        }
    }

    public static List<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static List<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static List<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }
}
