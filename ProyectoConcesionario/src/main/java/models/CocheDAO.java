package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;

public class CocheDAO  extends Coche{

	//SENTENCIAS 
	
	private final static String INSERT="INSERT INTO coche (matricula,marca,potencia,color,precio,dni_cliente)"
			+ "VALUES (?,?,?,?,?,NULL)";
	private final static String DELETE="DELETE FROM coche WHERE matricula=?";
	private final static String SELECT_ALL_COCHES="SELECT * FROM coche";
	private final static String SELECT_COCHES_SIN_PROPIETARIO="SELECT * FROM coche WHERE dni_cliente IS NULL";
	private final static String SELECT_COCHES_CON_PROPIETARIO="SELECT * FROM coche WHERE dni_cliente IS NOT NULL";
	private final static String SELECT_MATRICULA="SELECT * FROM coche WHERE matricula=?";
	private final static String SELECT_MARCA="SELECT * FROM coche WHERE marca=?";
	private final static String SELECT_COLOR="SELECT * FROM coche WHERE color=?";
	private final static String SELECT_ALL_MATRICULAS="SELECT matricula FROM coche";

	//--
	Connection con;
	
	public CocheDAO () {
		try {
			con=Conexion.conectar(utils.UtilidadXml.loadFile("conexion.xml"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public CocheDAO (String matricula, String marca, int potencia, String color, double precio,String dniCliente) {
	super(matricula,marca,potencia,color,precio,dniCliente);
	try {
		con=Conexion.conectar(utils.UtilidadXml.loadFile("conexion.xml"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	public CocheDAO (String matricula, String marca, int potencia, String color ,double precio) {
		super(matricula,marca,potencia,color,precio);
		try {
			con=Conexion.conectar(utils.UtilidadXml.loadFile("conexion.xml"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public CocheDAO(Coche c) {
		
		this.matricula = c.matricula;
		this.marca = c.marca;
		this.potencia = c.potencia;
		this.color = c.color;
		this.precio = c.precio;
		this.dniCliente=c.dniCliente;
		
	}
	public CocheDAO(String matricula) {
		
		this.matricula=matricula;
	}
	
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(INSERT);
				q.setString(1, this.matricula);
				q.setString(2, this.marca);
				q.setInt(3, this.potencia);
				q.setString(4, this.color);
				q.setDouble(5, this.precio);
				result = q.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int eliminar(String matricula) {
		int rs=0;
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(DELETE);
				q.setString(1, matricula);
				rs = q.executeUpdate();
				this.matricula="-1";
				this.marca="";
				this.potencia=-1;
				this.color="";
				this.precio=-1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}
	public  void mostarMatricula(String matricula){
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(SELECT_MATRICULA);
				q.setString(1, matricula);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						Coche c=new Coche();
						c.setMatricula(rs.getString("matricula"));
						c.setMarca(rs.getString("marca"));
						c.setPotencia(rs.getInt("potencia"));
						c.setColor(rs.getString("color"));
						c.setPrecio(rs.getDouble("precio"));
						c.setDniCliente(rs.getString("dni_cliente"));
						
						System.out.println(c);
						
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean ComprMatriculaExiste(String matricula) {
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		boolean result=false;
		if(con != null) {
			
			List<Coche> listaComprobacionCoches = CocheDAO.listaMatriculas();
			for (int i=0;i<listaComprobacionCoches.size();i++) {
				
				if(listaComprobacionCoches.get(i).getMatricula().equals(matricula)) {
					
					//EL COCHE YA EXISTE
					result=true;	
				}
			}
		}
		return result;
	}
	
	public boolean ComprSiTienePropPorMatricula(String matricula){
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		boolean result=false;
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(SELECT_MATRICULA);
				q.setString(1, matricula);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						Coche c=new Coche();
						c.setDniCliente(rs.getString("dni_cliente"));
						
						if(c.getDniCliente() != null) {
							// SI TIENE PROPIETARIO ,BOOLEAN = TRUE
							result = true;
						}else {
							//SI NO BOOLEAN = FALSE
						}
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public static List<Coche> mostrarTodosLosCoches(){
		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(SELECT_ALL_COCHES);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						Coche c=new Coche();
						c.setMatricula(rs.getString("matricula"));
						c.setMarca(rs.getString("marca"));
						c.setPotencia(rs.getInt("potencia"));
						c.setColor(rs.getString("color"));
						c.setPrecio(rs.getDouble("precio"));
						c.setDniCliente(rs.getString("dni_cliente"));
						
						result.add(c);
						
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public static List<Coche> mostrarCochesSinPropietario(){
		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));		
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECT_COCHES_SIN_PROPIETARIO);
				ResultSet rs= q.executeQuery();
				while(rs.next()) {
					Coche c=new Coche();
					c.setMatricula(rs.getString("matricula"));
					c.setMarca(rs.getString("marca"));
					c.setPotencia(rs.getInt("potencia"));
					c.setColor(rs.getString("color"));
					c.setPrecio(rs.getDouble("precio"));
					c.setDniCliente(rs.getString("dni_cliente"));
					
					result.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;
	}
	public static List<Coche> mostrarCochesConPropietario(){

		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));		
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECT_COCHES_CON_PROPIETARIO);
				ResultSet rs= q.executeQuery();
				while(rs.next()) {
					Coche c=new Coche();
					c.setMatricula(rs.getString("matricula"));
					c.setMarca(rs.getString("marca"));
					c.setPotencia(rs.getInt("potencia"));
					c.setColor(rs.getString("color"));
					c.setPrecio(rs.getDouble("precio"));
					c.setDniCliente(rs.getString("dni_cliente"));
					
					result.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;
	
	}
	
	public static List<Coche> mostarMarca(String marca){
		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));		
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECT_MARCA);
				q.setString(1, marca);
				ResultSet rs= q.executeQuery();
				while(rs.next()) {
					Coche c=new Coche();
					c.setMatricula(rs.getString("matricula"));
					c.setMarca(rs.getString("marca"));
					c.setPotencia(rs.getInt("potencia"));
					c.setColor(rs.getString("color"));
					c.setPrecio(rs.getDouble("precio"));
					c.setDniCliente(rs.getString("dni_cliente"));
					
					result.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;	
	}
	public static List<Coche> mostarColor(String color){
		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));		
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECT_COLOR);
				q.setString(1, color);
				ResultSet rs= q.executeQuery();
				while(rs.next()) {
					Coche c=new Coche();
					c.setMatricula(rs.getString("matricula"));
					c.setMarca(rs.getString("marca"));
					c.setPotencia(rs.getInt("potencia"));
					c.setColor(rs.getString("color"));
					c.setPrecio(rs.getDouble("precio"));
					c.setDniCliente(rs.getString("dni_cliente"));
					
					result.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;	
	}
	private static List<Coche> listaMatriculas(){
		List<Coche> result = new ArrayList<Coche>();
		Connection con = Conexion.getConexion(utils.UtilidadXml.loadFile("conexion.xml"));		
		try {
			PreparedStatement q = con.prepareStatement(SELECT_ALL_MATRICULAS);
			ResultSet rs= q.executeQuery();
				while(rs.next()) {
					Coche c=new Coche();
					c.setMatricula(rs.getString("matricula"));
					
					result.add(c);
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return result;
	}
	
	
	
	
	
}
