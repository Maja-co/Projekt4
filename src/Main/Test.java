package Main;

import Controller.Controller;
import OrdreSystem.PladsType;
import Storage.Storage;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Controller controller = new Controller(storage);

        controller.opretForestilling("The Nutcracker", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 30));
        controller.opretKunde("Maja Kragelund", "+45 88 88 88 88");
        controller.opretPlads(1, 5, 100, PladsType.STANDARD);

    }
}
