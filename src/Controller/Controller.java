package Controller;

import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import OrdreSystem.PladsType;
import Storage.Storage;

import java.time.LocalDate;

public class Controller {
    private Storage storage;

    public Controller(Storage storage){
        this.storage = storage;
    }

    public Forestilling opretForestilling(String name, LocalDate startDate, LocalDate endDate){
        Forestilling forestilling = new Forestilling(name, startDate, endDate);
        storage.addForestilling(forestilling);
        return forestilling;
    }

    public Kunde opretKunde(String name, String mobilNumber){
        Kunde kunde = new Kunde(name, mobilNumber);
        storage.addKunde(kunde);
        return kunde;
    }
    public Plads opretPlads (int row, int seatNumber, int price, PladsType pladsType){
        Plads plads = new Plads(row, seatNumber, price, pladsType);
        storage.addPlads(plads);
        return plads;
    }
}
