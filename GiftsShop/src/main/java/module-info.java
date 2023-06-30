module com.example.giftsshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.giftsshop to javafx.fxml;
    exports com.example.giftsshop;
}