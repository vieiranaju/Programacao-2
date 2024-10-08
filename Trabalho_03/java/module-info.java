module com.mycompany.cadastroclientes {
    requires java.net.http;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;

    opens com.mycompany.cadastroclientes to javafx.fxml;
    exports com.mycompany.cadastroclientes;
}
