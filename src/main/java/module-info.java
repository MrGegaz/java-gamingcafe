module com.example.gamingcafe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires java.sql;
    requires atlantafx.base;

    opens com.example.gamingcafe to javafx.fxml;
    opens com.example.gamingcafe.controller to javafx.fxml;

    exports com.example.gamingcafe.app;
}