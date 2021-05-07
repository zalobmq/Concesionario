package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menus.MenuPrincipal;
import models.Cliente;
import models.ClienteDAO;
import models.Coche;
import models.CocheDAO;

public class Ejecutable {

	public static void main(String[] args) {
	Scanner teclado=new Scanner(System.in);
	String dni="12345678E";
	//	List<Coche> lista=CocheDAO.mostrarCochesSinPropietario();
		
	//	System.out.println(lista);
		//System.out.print("INTRODUCE DNI:");
		//String dni=teclado.next();
		//int i=ClienteDAO.MostrarNºCochesCLiente("12345678E");
		//System.out.println(i);

		//CocheDAO c=new CocheDAO("0987D", "Audi", 500, "negro", 500000);
	//	CocheDAO c= new CocheDAO
		//System.out.println(c);
	//	c.eliminar("1222B");
		
	//ClienteDAO cl=new ClienteDAO();
	//cl.MostrarNºCochesCLiente(dni);
	//System.out.println(c1);
	
//	List<Coche> lista = CocheDAO.mostrarTodosLosCoches();
//CocheDAO c1=new CocheDAO();
//c1.mostarMatricula("4321G");

//	ClienteDAO cl=new ClienteDAO();
//	List<Coche> lista2 = CocheDAO.mostrarCochesConPropietario();
	//c1.añadir();
	//System.out.println(c1);
	//cl.asignar("12345678E", "3333D");
//	System.out.println(lista2);
	
	
	
	
	//System.out.println(lista);
	//ClienteDAO c1= new ClienteDAO();
	//c1.retirar("12345678E", "9348R");
	//CocheDAO c1 = new CocheDAO("5643H", "lotus", 1234, "verde", 1233);
	//c1.añadir();
	//System.out.println(c1);
	
	//ClienteDAO cl=new ClienteDAO();
	//cl.asignar("12345678E", "5643H");
	//System.out.println(c1);
	MenuPrincipal.MenuPrincipal();
	}

}
