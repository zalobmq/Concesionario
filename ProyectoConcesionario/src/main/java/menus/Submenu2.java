package menus;

import java.util.List;
import java.util.Scanner;

import models.ClienteDAO;
import models.Coche;
import models.CocheDAO;

public class Submenu2 {

	public static void MenuBusquedaCoche() {
		
		//Scanner teclado=new Scanner(System.in);
		int opcion=0;
		do {
		vistas.Menus.MenuCochesBusqueda();
		System.out.print("OPCION:");
		opcion=utils.InsertarPorTeclado.getInt();
		
		switch (opcion) {
		
			case 1:
					System.out.println("");
					System.out.println("### MOSTRAR TODOS LOS COCHES");
					System.out.println("");
					List<Coche> ListaTodosCoch = new CocheDAO().mostrarTodosLosCoches();
					System.out.println(ListaTodosCoch);
				break;
			case 2:
					System.out.println("");
					System.out.println("### MOSTRAR COCHES SIN PROPIETARIO");
					System.out.println("");
					List<Coche> ListaSinCoch = new CocheDAO().mostrarCochesSinPropietario();
					System.out.println(ListaSinCoch);
				break;
			case 3:
					System.out.println("");
					System.out.println("### MOSTRAR COCHES CON PROPIETARIO");
					System.out.println("");
					List<Coche> ListaConCoch = new CocheDAO().mostrarCochesConPropietario();
					System.out.println(ListaConCoch);
				break;
			case 4:
					String BMatricula;
					System.out.println("");
					System.out.println("### BUSCAR COCHE POR MATRICULA ###");
					System.out.println("");
					System.out.print("INSERTA LA MATRICULA: ");
					BMatricula=utils.InsertarPorTeclado.getString();
					CocheDAO Bc= new CocheDAO();
					Bc.mostarMatricula(BMatricula);
					
				break;
			case 5:
					String BMarca;
					System.out.println("");
					System.out.println("### FILTRADO POR MARCA ###");
					System.out.println("");
					System.out.print("INSERTA LA MARCA: ");
					BMarca=utils.InsertarPorTeclado.getString();
					List<Coche> Mc=CocheDAO.mostarMarca(BMarca);
					System.out.println(Mc);
					
				break;
			case 6:
				String BColor;
				System.out.println("");
				System.out.println("### FILTRADO POR COLOR ###");
				System.out.println("");
				System.out.print("INSERTA EL COLOR: ");
				BColor=utils.InsertarPorTeclado.getString();
				List<Coche> Cc=CocheDAO.mostarColor(BColor);
				System.out.println(Cc);
				
				break;
			case 7:
				System.out.println("");
				System.out.println("VOLVIENDO AL MENU DE COCHES...");
				break;
			default:
				System.out.println("OPCION INCORRECTA , POR FAVOR INSERTE UNA OPCION VALIDA");
				break;
		}
		}while(opcion != 7);
	}
}
