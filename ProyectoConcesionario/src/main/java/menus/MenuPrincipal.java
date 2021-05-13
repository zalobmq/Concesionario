package menus;

import models.DatosDeConexion;
import utils.InsertarPorTeclado;
import utils.UtilidadXml;
import vistas.Menus;

public class MenuPrincipal {

	public static void MenuPrincipal() {
	//	Scanner teclado=new Scanner(System.in);
		int opcion=0;
		do {
		Menus.MenuPresentacion();
		System.out.print("OPCION:");
		opcion= InsertarPorTeclado.getInt();
		switch(opcion) {
		
			case 1:
				
				//AQUI MOSTRARA EL MENU DE COCHES 
				// Y EJECUTARA LA CLASE SUBMENU CON LA FUNCION ASIGNADA PARA EL MENU DE COCHES 
				Submenu1.MenuPrincipalCoches();
				break;
				
			case 2:
				//AQUI MOSTRARA EL MENU DE CLIENTES 
				// Y EJECUTARA LA CLASE SUBMENU CON LA FUNCION ASIGNADA PARA EL MENU DE CLIENTES 
				Submenu1.MenuPrincipalClientes();
				break;
			case 3:
				System.out.println("Guardando xml...");
				UtilidadXml.saveFile("conexion.xml", new DatosDeConexion("localhost","concesionario","root",""));
				break;
			case 4:
				System.out.println("### SALIR DEL PROGRAMA ###");
				break;
			default:
				System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
				break;
			}
		}while(opcion != 4);
		}
}
