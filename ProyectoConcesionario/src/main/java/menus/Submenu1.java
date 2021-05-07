package menus;

import java.util.List;
import java.util.Scanner;

import models.Cliente;
import models.ClienteDAO;
import models.Coche;
import models.CocheDAO;

public class Submenu1 {
	
	//MENU DE COCHES 
	public static void MenuPrincipalCoches() {
		Scanner teclado=new Scanner(System.in);
		int opcion=0;
		
		vistas.Menus.MenuCoches();
		System.out.print("OPCION: ");
		opcion=teclado.nextInt();
		
		switch (opcion) {
		
			case 1:
				String matricula;
				String marca;
				int potencia;
				String color;
				double precio;
				System.out.println("");
				System.out.println("### CREAR Y AÑADIR COCHE ###");
				System.out.println("");
				System.out.print("MATRICULA: ");
				matricula=teclado.next();
				System.out.print("MARCA: ");
				marca=teclado.next();
				System.out.print("POTENCIA:");
				potencia=teclado.nextInt();
				System.out.print("COLOR: ");
				color=teclado.next();
				System.out.print("PRECIO: ");
				precio=teclado.nextDouble();
				System.out.println("");
				System.out.println("COCHE AÑADIDO");
				CocheDAO c= new CocheDAO(matricula, marca, potencia, color, precio);
				c.añadir();
				break;
			
			case 2:
				String matriculaEliminar;
				System.out.println("");
				System.out.println("### ELIMINAR COCHE ###");
				System.out.println("");
				System.out.print("MATRICULA DEL COCHE: ");
				matriculaEliminar=teclado.next();
				CocheDAO cB= new CocheDAO();
				cB.eliminar(matriculaEliminar);
				System.out.println("COCHE ELIMINADO");
				break;
				
			case 3:
				//AQUI MOSTRARA EL MENU DE BUSQUEDA DE COCHES 
				// Y EJECUTARA LA CLASE SUBMENU2 CON LA FUNCION ASIGNADA PARA EL MENU DE BUSQUEDA DE COCHES
				Submenu2.MenuBusquedaCoche();
				break;
			case 4:
				System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
				break;
				
		}
	}
	
	//MENU DE CLIENTES
	public static void MenuPrincipalClientes() {
	
		Scanner teclado=new Scanner(System.in);
		int opcion=0;
		
		vistas.Menus.MenuClientes();
		System.out.print("OPCION: ");
		opcion=teclado.nextInt();
		
			switch(opcion) {
			
				case 1:
					String AMatricula;
					String ADni;
					
					System.out.println("### ASIGNAR COCHE ###");
					System.out.println("");
					System.out.print("DNI DEL CLIENTE: ");
					ADni=teclado.next();
					System.out.print("MATRICULA DEL COCHE: ");
					AMatricula=teclado.next();
					
						ClienteDAO clA= new ClienteDAO();
						clA.asignar(ADni, AMatricula);
					
					System.out.println("");
					System.out.println("EL COCHE HA SIDO ASIGNADO AL CLIENTE ");
						
					break;
				case 2:
					String RMatricula;
					String RDni;
					System.out.println("");
					System.out.println("### ASIGNAR COCHE ###");
					System.out.println("");
					System.out.print("DNI DEL CLIENTE: ");
					RDni=teclado.next();
					System.out.print("MATRICULA DEL COCHE: ");
					RMatricula=teclado.next();
					
						ClienteDAO clR= new ClienteDAO();
						clR.retirar(RDni, RMatricula);
					
					System.out.println("");
					System.out.println("EL COCHE HA SIDO RETIRADO AL CLIENTE ");
					
					break;
				case 3:
					System.out.println("");
					System.out.println("### TODOS LOS CLIENTES ###");
					System.out.println("");
					List<Cliente> ListaTodClien = new ClienteDAO().MostrarTodos();
					System.out.println(ListaTodClien);
					break;
				case 4:
					String CCDni;
					System.out.println("");
					System.out.println("### COCHES DE CLIENTE ###");
					System.out.println("");
					System.out.print("INSERTA EL DNI DEL CLIENTE: ");
					CCDni=teclado.next();
					List<Coche> ListaCochClien = new ClienteDAO().MostrarCochesCLiente(CCDni);
					System.out.println("");
					System.out.println("Mostrando coches del cliente con DNI: "+CCDni);
					System.out.println(ListaCochClien);
					
					break;
				case 5:
					String IDni;
					System.out.println("");
					System.out.println("### INFO CLIENTE ###");
					System.out.println("");
					System.out.print("INSERTA EL DNI DEL CLIENTE: ");
					IDni=teclado.next();
					ClienteDAO clI=new ClienteDAO();
					System.out.println();
					System.out.println("Mostrando info del cliente con DNI: "+IDni);
					clI.MostrarInfoCliente(IDni);
					break;
					
				case 6:
					System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
					break;
					
			}
		
	}
}
