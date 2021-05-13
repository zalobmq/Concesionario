package menus;

import java.util.List;

import models.Cliente;
import models.ClienteDAO;
import models.Coche;
import models.CocheDAO;
import utils.InsertarPorTeclado;
import vistas.Menus;

public class Submenu1 {
	
	public static void MenuPrincipalCoches() {
		int opcion=0;
		do {
		Menus.MenuCoches();
		System.out.print("OPCION: ");
		opcion= InsertarPorTeclado.getInt();
		
		switch (opcion) {
		
			case 1:
				String matricula;
				String marca;
				int potencia;
				String color;
				double precio;
				boolean ComprobacionM;
				System.out.println("");
				do {
				System.out.println("### CREAR Y AÑADIR COCHE ###");
				System.out.println("");
				System.out.print("MATRICULA: ");
				matricula= InsertarPorTeclado.getString();
				CocheDAO cCompM= new CocheDAO();
				ComprobacionM=cCompM.ComprMatriculaExiste(matricula);
				if(ComprobacionM) {
					System.out.println("YA EXISTE UN COCHE CON ESTA MATRICULA");	
				}
				}while(ComprobacionM);

				System.out.print("MARCA: ");
				marca= InsertarPorTeclado.getString();
				System.out.print("POTENCIA:");
				potencia= InsertarPorTeclado.getInt();
				System.out.print("COLOR: ");
				color= InsertarPorTeclado.getString();
				System.out.print("PRECIO: ");
				precio= InsertarPorTeclado.getDouble();
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
				matriculaEliminar= InsertarPorTeclado.getString();
				CocheDAO cComp= new CocheDAO();
				CocheDAO cB= new CocheDAO();
				Comprobacion=cComp.ComprSiTienePropPorMatricula(matriculaEliminar);

				if(Comprobacion) {
					System.out.println("ESTE VEHICULO PERTENECE A UN CLIENTE , NO SE PUEDE BORRAR");
				}else {
					cB.eliminar(matriculaEliminar);
					System.out.println("COCHE ELIMINADO");
				}
				break;
				
			case 3:
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
	

	public static void MenuPrincipalClientes() {
	
		int opcion=0;
		do {
		Menus.MenuClientes();
		System.out.print("OPCION: ");
		opcion= InsertarPorTeclado.getInt();
		
			switch(opcion) {
			
				case 1:
					String AMatricula;
					String ADni;
					
					System.out.println("### ASIGNAR COCHE ###");
					System.out.println("");
					System.out.print("DNI DEL CLIENTE: ");
					ADni= InsertarPorTeclado.getString();
					System.out.print("MATRICULA DEL COCHE: ");
					AMatricula= InsertarPorTeclado.getString();
					
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
					RDni= InsertarPorTeclado.getString();
					System.out.print("MATRICULA DEL COCHE: ");
					RMatricula= InsertarPorTeclado.getString();
					
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
					CCDni= InsertarPorTeclado.getString();
					ClienteDAO c = ClienteDAO.getClientePorDNI(CCDni);
					List<Coche> ListaCochClien = c.getMisCoches();
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
					IDni= InsertarPorTeclado.getString();
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
