package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection con;
	//PROYECTO ESTO DEBE IR EN UN XML
	
	private final static String SERVER="jdbc:mysql://localhost";
	private final static String DATABSE="concesionario";
	private final static String USERNAME="root";
	private final static String PASSWORD="";
	
	public static void conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(SERVER+"/"+DATABSE,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			con=null;
			e.printStackTrace();
		}
		
		
	}
	public static Connection getConexion() {
		if(con==null) {
			conectar();
		}
		return con;
	}
}
