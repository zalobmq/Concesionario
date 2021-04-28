module es.iesfranciscodelosrios.ProyectoConcesionario {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.iesfranciscodelosrios.ProyectoConcesionario to javafx.fxml;
    exports es.iesfranciscodelosrios.ProyectoConcesionario;
}
