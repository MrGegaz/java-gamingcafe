module com.example.gamingcafe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.example.gamingcafe to javafx.fxml;
    opens com.example.gamingcafe.controller to javafx.fxml;

    exports com.example.gamingcafe;
}