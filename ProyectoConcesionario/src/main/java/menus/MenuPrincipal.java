package menus;

import models.DatosDeConexion;
import utils.InsertarPorTeclado;
import utils.UtilidadXml;
import vistas.Menus;

public class MenuPrincipal {

	/*
	 * MENU PRINCIPAL
	 * 
	 * Es el que se muestra al ejecutar nuestro programa
	 * */
	public static void MenuPrincipal() {
		int opcion=0;
		do {
		Menus.MenuPresentacion();
		System.out.print("OPCION:");
		opcion= InsertarPorTeclado.getInt();
		switch(opcion) {
		
			case 1:
				
				//MOSTRARA EL MENU DE COCHES 
				Submenu1.MenuPrincipalCoches();
				break;
				
			case 2:
				//MOSTRARA EL MENU DE CLIENTES 
				Submenu1.MenuPrincipalClientes();
				break;
			case 3:
				//Guardara el XML
				System.out.println("Guardando xml...");
				UtilidadXml.saveFile("conexion.xml", new DatosDeConexion("localhost","concesionario","root",""));
				break;
			case 4:
				//SALDRA DEL PROGRAMA
				System.out.println("### SALIR DEL PROGRAMA ###");
				break;
			default:
				//Se ejecutara al introducir una opcion no valida
				System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
				break;
			}
		}while(opcion != 4);
		}
}
