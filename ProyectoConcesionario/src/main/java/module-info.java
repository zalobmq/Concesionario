module es.iesfranciscodelosrios.ProyectoConcesionario {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.xml.bind;
    requires com.sun.xml.bind;
    opens es.iesfranciscodelosrios.ProyectoConcesionario to javafx.fxml;
    opens conexion to com.sun.xml.bind, java.xml.bind;
    opens utils to com.sun.xml.bind, java.xml.bind;
    exports es.iesfranciscodelosrios.ProyectoConcesionario;
}
