package vistas;

public class Menus {

	public static void MenuPresentacion() {
		
		System.out.println("");
		System.out.println("####### BIENVENIDO ########");
		System.out.println("#                         #");
		System.out.println("# ELIGE UNA OPCION        #");
		System.out.println("#                         #");
		System.out.println("# 1.- SECCION DE COCHES   #");
		System.out.println("# 2.- SECCION DE CLIENTES #");
		System.out.println("# 3.- GUARDAR XML         #");
		System.out.println("# 4.- SALIR               #");
		System.out.println("#                         #");
		System.out.println("###########################");
		
	}
	
	public static void MenuCoches() {
		System.out.println("");
		System.out.println("### MENU COCHES  ###");
		System.out.println("#                  #");
		System.out.println("# ELIGE UNA OPCION #");
		System.out.println("# 1.- AÑADIR       #");
		System.out.println("# 2.- BORRAR       #");
		System.out.println("# 3.- BUSCAR       #");
		System.out.println("# 4.- SALIR        #");
		System.out.println("#                  #");
		System.out.println("####################");
		
	}
	public static void MenuCochesBusqueda() {
		System.out.println("");
		System.out.println("### MENU BUSQUEDA DE COCHES ##########");
		System.out.println("#                                    #");
		System.out.println("# ELIGE UNA OPCION                   #");
		System.out.println("# 1.- MOSTRAR TODOS                  #");
		System.out.println("# 2.- MOSTAR COCHES SIN PROPIETARIO  #");
		System.out.println("# 3.- MOSTRAR COCHES CON PROPIETARIO #");
		System.out.println("# 4.- BUSCAR COCHE POR MATRICULA     #");
		System.out.println("# 5.- FILTRADO POR MARCA             #");
		System.out.println("# 6.- FILTRADO POR COLOR             #");
		System.out.println("# 7.- SALIR                          #");
		System.out.println("#                                    #");
		System.out.println("######################################");
	}
	public static void MenuClientes() {
		System.out.println("");
		System.out.println("######### MENU CLIENTES  #########");
		System.out.println("#                                #");
		System.out.println("# ELIGE UNA OPCION               #");
		System.out.println("# 1.- ASIGNAR COCHE A CLIENTE    #");
		System.out.println("# 2.- RETIRAR COCHE A CLIENTE    #");
		System.out.println("# 3.- MOSTRAR TODOS LOS CLIENTES #");
		System.out.println("# 4.- MOSTRAR COCHES DE CLIENTE  #");
		System.out.println("# 5.- INFO CLIENTE               #");
		System.out.println("# 6.- SALIR                      #");
		System.out.println("#                                #");
		System.out.println("##################################");
	}
}
