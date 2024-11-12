package Main;

import Model.Forestilling;
import Model.Kunde;
import Storage.Storage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Gui extends Application {
    private ListView<String> forestillingListView = new ListView<>();
    private ListView<String> kundeListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab forestillingTab = new Tab("Forestilling", createForestillingPane());
        Tab kundeTab = new Tab("Kunde", createKundePane());
        tabPane.getTabs().addAll(forestillingTab, kundeTab);

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Administrer Forestillinger og Kunder");
        primaryStage.show();

        updateForestillingList();
        updateKundeList();
    }

    private VBox createForestillingPane() {
        Button addButton = new Button("Tilføj forestilling");
        addButton.setOnAction(e -> openAddForestillingWindow());

        Button deleteButton = new Button("Slet forestilling");
        deleteButton.setOnAction(e -> deleteSelectedItem(forestillingListView));

        HBox buttonBox = new HBox(10, addButton, deleteButton);
        buttonBox.setStyle("-fx-alignment: center;");

        VBox vbox = new VBox(10, forestillingListView, buttonBox);
        vbox.setStyle("-fx-padding: 10;");
        return vbox;
    }

    private VBox createKundePane() {
        Button addButton = new Button("Tilføj kunde");
        addButton.setOnAction(e -> openAddKundeWindow());

        Button deleteButton = new Button("Slet kunde");
        deleteButton.setOnAction(e -> deleteSelectedItem(kundeListView));

        HBox buttonBox = new HBox(10, addButton, deleteButton);
        buttonBox.setStyle("-fx-alignment: center;");

        VBox vbox = new VBox(10, kundeListView, buttonBox);
        vbox.setStyle("-fx-padding: 10;");
        return vbox;
    }

    private void openAddForestillingWindow() {
        Stage addWindow = new Stage();
        addWindow.setTitle("Tilføj Forestilling");

        TextField nameField = new TextField();
        nameField.setPromptText("Navn");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setPromptText("Startdato");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setPromptText("Slutdato");

        Button saveButton = new Button("Gem");
        saveButton.setOnAction(e -> {
            String navn = nameField.getText();
            LocalDate startDato = startDatePicker.getValue();
            LocalDate slutDato = endDatePicker.getValue();
            if (!navn.isEmpty() && startDato != null && slutDato != null) {
                Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
                Storage.addForestilling(forestilling);
                updateForestillingList();
                addWindow.close();
            } else {
                showAlert("Udfyld alle felter!");
            }
        });


        VBox vbox = new VBox(10, nameField, startDatePicker, endDatePicker, saveButton);
        vbox.setStyle("-fx-padding: 10;");
        addWindow.setScene(new Scene(vbox, 300, 200));
        addWindow.show();
    }

    private void openAddKundeWindow() {
        Stage addWindow = new Stage();
        addWindow.setTitle("Tilføj Kunde");

        TextField nameField = new TextField();
        nameField.setPromptText("Navn");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobilnummer");

        Button saveButton = new Button("Gem");
        saveButton.setOnAction(e -> {
            String navn = nameField.getText();
            String mobil = mobileField.getText();
            if (!navn.isEmpty() && !mobil.isEmpty()) {
                Kunde kunde = new Kunde(navn, mobil);
                Storage.addKunde(kunde);
                updateKundeList();
                addWindow.close();
            } else {
                showAlert("Udfyld alle felter!");
            }
        });


        VBox vbox = new VBox(10, nameField, mobileField, saveButton);
        vbox.setStyle("-fx-padding: 10;");
        addWindow.setScene(new Scene(vbox, 300, 150));
        addWindow.show();
    }

    private void updateForestillingList() {
        forestillingListView.getItems().clear();
        for (Forestilling forestilling : Storage.getForestillinger()) {
            forestillingListView.getItems().add(forestilling.getName() + " - " +
                    forestilling.getStartDate() + " til " + forestilling.getEndDate());
        }
    }


    private void updateKundeList() {
        kundeListView.getItems().clear();
        for (Kunde kunde : Storage.getKunder()) {
            kundeListView.getItems().add(kunde.getName() + " " +
                    kunde.getMobilNumber());
        }
    }

    private void deleteSelectedItem(ListView<String> listView) {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listView.getItems().remove(selectedItem);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
