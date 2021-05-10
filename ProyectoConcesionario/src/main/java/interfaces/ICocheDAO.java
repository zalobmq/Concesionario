package interfaces;

import java.util.List;

import models.Coche;

public interface ICocheDAO {
	
	public int añadir();
	public int eliminar(String matricula);
	public void mostarMatricula(String matricula);
	public boolean ComprMatriculaExiste(String matricula);
	public boolean ComprSiTienePropPorMatricula(String matricula);
	public static List<Coche> mostrarTodosLosCoches() {
		return null;
	}
	public static List<Coche> mostrarCochesSinPropietario() {
		return null;
	}
	public static List<Coche> mostrarCochesConPropietario() {
		return null;
	}
	public static List<Coche> mostarMarca(String marca) {
		return null;
	}
	public static List<Coche> mostarColor(String color) {
		return null;
	}

}
