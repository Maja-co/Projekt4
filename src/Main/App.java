package Main;

import Model.Forestilling;
import Model.Kunde;
import Storage.Storage;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    private static void initStorage(){
        Storage.addForestilling(new Forestilling("Evita", LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 10)));
        Storage.addForestilling(new Forestilling("Lykke Per", LocalDate.of(2024, 9, 1), LocalDate.of(2024,9,10)));
        Storage.addForestilling(new Forestilling("Chess", LocalDate.of(2024, 8, 21), LocalDate.of(2024,8,30)));

        Storage.addKunde(new Kunde("Anders Hansen", "+45 20 21 20 21"));
        Storage.addKunde(new Kunde("Peter Jensen", "+45 25 27 23 21"));
        Storage.addKunde(new Kunde("Niels Madsen", "+45 30 23 60 91"));
    }
}
