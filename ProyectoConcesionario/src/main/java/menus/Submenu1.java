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
		//Scanner teclado=new Scanner(System.in);
		int opcion=0;
		do {
		vistas.Menus.MenuCoches();
		System.out.print("OPCION: ");
		opcion=utils.InsertarPorTeclado.getInt();
		
		switch (opcion) {
		
			case 1:
				String matricula;
				String marca;
				int potencia;
				String color;
				double precio;
				boolean ComprobacionM;
				int llave=0;
				System.out.println("");
				do {
				System.out.println("### CREAR Y AÑADIR COCHE ###");
				System.out.println("");
				System.out.print("MATRICULA: ");
				matricula=utils.InsertarPorTeclado.getString();
				CocheDAO cCompM= new CocheDAO();
				ComprobacionM=cCompM.ComprMatriculaExiste(matricula);
				if(ComprobacionM) {
					//COMPROBACION ES TRUE ->  HAY COCHE CON ESA MATRICULA
					System.out.println("YA EXISTE UN COCHE CON ESTA MATRICULA");	
				}
				}while(ComprobacionM);

				System.out.print("MARCA: ");
				marca=utils.InsertarPorTeclado.getString();
				System.out.print("POTENCIA:");
				potencia=utils.InsertarPorTeclado.getInt();
				System.out.print("COLOR: ");
				color=utils.InsertarPorTeclado.getString();
				System.out.print("PRECIO: ");
				precio=utils.InsertarPorTeclado.getDouble();
				System.out.println("");
				System.out.println("COCHE AÑADIDO");
				CocheDAO c= new CocheDAO(matricula, marca, potencia, color, precio);
				c.añadir();
				break;
			
			case 2:
				String matriculaEliminar;
				boolean Comprobacion;
				System.out.println("");
				System.out.println("### ELIMINAR COCHE ###");
				System.out.println("");
				System.out.print("MATRICULA DEL COCHE: ");
				matriculaEliminar=utils.InsertarPorTeclado.getString();
				CocheDAO cComp= new CocheDAO();
				CocheDAO cB= new CocheDAO();
				//BUSCAR EL VEHICULO POR AL MATRICULA Y COMPROBAR SI TIENE PROPIETARIO O NO
				Comprobacion=cComp.ComprSiTienePropPorMatricula(matriculaEliminar);

				if(Comprobacion) {
					System.out.println("ESTE VEHICULO PERTENECE A UN CLIENTE , NO SE PUEDE BORRAR");
				}else {
					cB.eliminar(matriculaEliminar);
					System.out.println("COCHE ELIMINADO");
				}
				/*
				if() {
					System.out.println("ESTE VEHICULO PERTENECE A UN CLIENTE , NO SE PUEDE BORRAR");
				}else {
					cB.eliminar(matriculaEliminar);
					System.out.println("COCHE ELIMINADO");
				}
				*/
				break;
				
			case 3:
				//AQUI MOSTRARA EL MENU DE BUSQUEDA DE COCHES 
				// Y EJECUTARA LA CLASE SUBMENU2 CON LA FUNCION ASIGNADA PARA EL MENU DE BUSQUEDA DE COCHES
				Submenu2.MenuBusquedaCoche();
				break;
			case 4:
				System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
				break;
			default:
				System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
				break;
			
				
		}
		}while(opcion != 4);
	}
	
	//MENU DE CLIENTES
	public static void MenuPrincipalClientes() {
	
		//Scanner teclado=new Scanner(System.in);
		int opcion=0;
		do {
		vistas.Menus.MenuClientes();
		System.out.print("OPCION: ");
		opcion=utils.InsertarPorTeclado.getInt();
		
			switch(opcion) {
			
				case 1:
					String AMatricula;
					String ADni;
					
					System.out.println("### ASIGNAR COCHE ###");
					System.out.println("");
					System.out.print("DNI DEL CLIENTE: ");
					ADni=utils.InsertarPorTeclado.getString();
					System.out.print("MATRICULA DEL COCHE: ");
					AMatricula=utils.InsertarPorTeclado.getString();
					
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
					RDni=utils.InsertarPorTeclado.getString();
					System.out.print("MATRICULA DEL COCHE: ");
					RMatricula=utils.InsertarPorTeclado.getString();
					
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
					CCDni=utils.InsertarPorTeclado.getString();
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
					IDni=utils.InsertarPorTeclado.getString();
					ClienteDAO clI=new ClienteDAO();
					System.out.println();
					System.out.println("Mostrando info del cliente con DNI: "+IDni);
					clI.MostrarInfoCliente(IDni);
					break;
					
				case 6:
					System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
					break;
				default:
					System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
					break;
					
			}
		}while(opcion != 6);
		
	}
}
