module com.example.zombiesurvivor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.zombiesurvivor to javafx.fxml;
    exports com.example.zombiesurvivor;

    opens com.example.zombiesurvivor.controleur to javafx.fxml;
    exports com.example.zombiesurvivor.controleur;
}