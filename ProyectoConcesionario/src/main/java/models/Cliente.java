package models;

public class Cliente {

	protected String dni;
	protected String nombre;
	protected int edad;
	protected int telefono;
	
	public Cliente() {
	}
	
	public Cliente(String dni, String nombre, int edad, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + "]\n";
	}

	public boolean equals(Object obj) {
		
		if(this == obj) {
			
			return true;
		}
		if(this.getClass() != obj.getClass()) {
			
			return false;
		}
		Cliente c=(Cliente) obj;
		if(c.getDni().equals(this.getDni())) {
			return true;
		}else {
			return false;
		}
	}
}
