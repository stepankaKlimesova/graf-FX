module com.example.graffx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graffx to javafx.fxml;
    exports com.example.graffx;
}