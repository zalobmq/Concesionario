package menus;

//import java.util.Scanner;

public class MenuPrincipal {

	public static void MenuPrincipal() {
	//	Scanner teclado=new Scanner(System.in);
		int opcion=0;
		do {
		vistas.Menus.MenuPresentacion();
		System.out.print("OPCION:");
		opcion=utils.InsertarPorTeclado.getInt();
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
				System.out.println("### SALIR DEL PROGRAMA ###");
				break;
			default:
				System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
				break;
			}
		}while(opcion != 3);
		}
}
