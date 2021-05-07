module es.iesfranciscodelosrios.ProyectoConcesionario {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires com.sun.xml.bind;
    requires jakarta.xml.bind;
    opens models to com.sun.xml.bind, jakarta.xml.bind;
    opens utils to com.sun.xml.bind, jakarta.xml.bind;
    exports es.iesfranciscodelosrios.ProyectoConcesionario;
}
