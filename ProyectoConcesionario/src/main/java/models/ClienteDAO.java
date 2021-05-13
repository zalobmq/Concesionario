package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import utils.UtilidadXml;

public class ClienteDAO extends Cliente {

    //SENTENCIAS SQL

    private final static String ASIGNAR = "UPDATE coche SET dni_cliente=? WHERE matricula=?";
    private final static String RETIRAR = "UPDATE coche SET dni_cliente=NULL WHERE matricula=? AND dni_cliente=?";
    private final static String SELECT_COCHES_CLIENTE = "SELECT * FROM coche WHERE dni_cliente=(SELECT dni FROM cliente WHERE dni=?)";
    private final static String SELECT_INFO_CLIENTE = "SELECT * FROM cliente WHERE dni=?";
    private final static String SELECT_ALL_CLIENTE = "SELECT * FROM cliente";


    

    //CONSTRUCTORES

    
    public ClienteDAO() {

    }

    public ClienteDAO(String dni, String nombre, int edad, int telefono) {
        super(dni, nombre, edad, telefono);
    }

    public ClienteDAO(String dni) {
        this.dni = dni;
    }

    public ClienteDAO(Cliente cl) {

        this.dni = cl.dni;
        this.nombre = cl.nombre;
        this.edad = cl.edad;
        this.telefono = cl.telefono;
    }
    
    //METODOS

    
    /*
     * Asignar:
     * 
     * Recibe el dni del cliente y la matricula del coche.
     * Asignara el coche al cliente.
     * */

    public int asignar(String dni, String matricula) {
        int rs = 0;
        Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
        if (con != null) {
            try {
                PreparedStatement q = con.prepareStatement(ASIGNAR);
                q.setString(1, dni);
                q.setString(2, matricula);
                rs = q.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return rs;
    }

    /*
     * Retirar:
     * 
     * Recibe el dni del cliente y la matricula del coche.
     * Retirara el coche al cliente.
     * */
    
    public int retirar(String dni, String matricula) {
        int rs = 0;

        Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
        if (con != null) {
            try {
                PreparedStatement q = con.prepareStatement(RETIRAR);
                q.setString(1, matricula);
                q.setString(2, dni);
                rs = q.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return rs;
    }
    /*
     * MostrarInfoCliente:
     * 
     * Recibe el dni del cliente.
     * Devolvera la informacion de dicho cliente.
     * */
    public void MostrarInfoCliente(String dni) {

        Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
        Cliente cl = new Cliente();


        if (con != null) {
            try {
                PreparedStatement q = con.prepareStatement(SELECT_INFO_CLIENTE);
                q.setString(1, dni);
                ResultSet rs = q.executeQuery();
                while (rs.next()) {
                    cl.setDni(rs.getString("dni"));
                    cl.setNombre(rs.getString("nombre"));
                    cl.setEdad(rs.getInt("edad"));
                    cl.setTelefono(rs.getInt("telefono"));

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(cl);
    }
    /*
     * getClientePorDNI:
     * 
     * Recibe el dni del cliente.
     * Devolvera un ClienteDAO.
     * */
    
    public static ClienteDAO getClientePorDNI(String dni) {

        Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
        ClienteDAO result = new ClienteDAO();


        if (con != null) {
            try {
                PreparedStatement q = con.prepareStatement(SELECT_INFO_CLIENTE);
                q.setString(1, dni);
                ResultSet rs = q.executeQuery();
                while (rs.next()) {
                    result.setDni(rs.getString("dni"));
                    result.setNombre(rs.getString("nombre"));
                    result.setEdad(rs.getInt("edad"));
                    result.setTelefono(rs.getInt("telefono"));

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }


    @Override
    
    /*
     * getMisCoches:
     * 
     * Devolvera la lista de coches de un cliente.
     * */
    
    public List<Coche> getMisCoches() {
        List<Coche> result = super.getMisCoches();
        if (result == null) {
            Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
            if (con != null) {
                result = new ArrayList<>();
                try {
                    PreparedStatement q = con.prepareStatement(SELECT_COCHES_CLIENTE);
                    q.setString(1, this.dni);
                    ResultSet rs = q.executeQuery();
                    while (rs.next()) {
                        Coche c = new Coche();
                        c.setMatricula(rs.getString("matricula"));
                        c.setMarca(rs.getString("marca"));
                        c.setPotencia(rs.getInt("potencia"));
                        c.setColor(rs.getString("color"));
                        c.setPrecio(rs.getDouble("precio"));
                        c.setCliente(this);
                        result.add(c);
                    }
                    super.setMisCoches(result);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    /*
     * MostrarTodos
     * 
     * Devolvera una lista con la informacion de todos los clientes.
     * */
    
    public List<Cliente> MostrarTodos() {
        List<Cliente> result = new ArrayList<Cliente>();
        Connection con = Conexion.getConexion(UtilidadXml.loadFile("conexion.xml"));
        if (con != null) {

            try {
                PreparedStatement q = con.prepareStatement(SELECT_ALL_CLIENTE);
                ResultSet rs = q.executeQuery();
                while (rs.next()) {
                    Cliente cl = new Cliente();
                    cl.setDni(rs.getString("dni"));
                    cl.setNombre(rs.getString("nombre"));
                    cl.setEdad(rs.getInt("edad"));
                    cl.setTelefono(rs.getInt("telefono"));

                    result.add(cl);

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return result;
    }


}