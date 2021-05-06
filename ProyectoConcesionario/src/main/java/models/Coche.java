package models;

public class Coche {

	protected String matricula;
	protected String marca;
	protected int potencia;
	protected String color;
	protected double precio;
	protected String dniCliente="";
	
	public Coche() {
		
	}
	public Coche(String matricula, String marca, int potencia, String color, double precio,String dniCliente) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.potencia = potencia;
		this.color = color;
		this.precio = precio;
		this.dniCliente = dniCliente;
	}
	

	public Coche(String matricula, String marca, int potencia, String color, double precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.potencia = potencia;
		this.color = color;
		this.precio = precio;
	}
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	@Override
	public String toString() {
		return "Coche: matricula=" + matricula + " | marca=" + marca + " | potencia=" + potencia + "cv | color=" + color
				+ " | precio=" + precio +" | DNI del Propietario: "+dniCliente +"\n";
	}
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			
			return true;
		}
		if(this.getClass() != obj.getClass()) {
			
			return false;
		}
		Coche v=(Coche) obj;
		if(v.getMatricula().equals(this.getMatricula())) {
			return true;
		}else {
			return false;
		}
	}
	
}
