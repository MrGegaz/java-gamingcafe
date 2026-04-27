module com.example.gamingcafe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.gamingcafe to javafx.fxml;
    exports com.example.gamingcafe;
}