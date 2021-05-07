package utils;

import java.util.Scanner;

public class InsertarPorTeclado {
	
	private static Scanner teclado=new Scanner (System.in);
	
	public static String getString() {
        String result = "";
        boolean valid = false;
        do {
            try {
                result = teclado.nextLine();
                valid = true;
            } catch (Exception ex) {
                System.out.println("Error desconocido. Inténtelo de nuevo: ");
            }
        } while (!valid);
        return result;
    }
	
	public static int getInt() {
        int result = 0;
        boolean valid = false;
        do {
            try {
                result = Integer.parseInt(teclado.nextLine());
                valid = true;
            } catch (IllegalStateException ex) {
                teclado = new Scanner(System.in);
                System.out.println("Opcion no valida. Inténtelo de nuevo: ");
            } catch (NumberFormatException ex) {
                System.out.println("Opcion no valida. Inténtelo de nuevo: ");
            } catch (Exception ex) {
                System.out.println("Error desconocido. Inténtelo de nuevo: ");
            }
        } while (!valid);
        return result;
    }
	public static double getDouble() {
		double result = 0;
        boolean valid = false;
        do {
            try {	//Integer.parse(teclado.nextLine());
                result = Double.parseDouble(teclado.nextLine());
                valid = true;
            } catch (IllegalStateException ex) {
                teclado = new Scanner(System.in);
                System.out.println("Opcion no valida. Inténtelo de nuevo: ");
            } catch (NumberFormatException ex) {
                System.out.println("Opcion no valida. Inténtelo de nuevo: ");
            } catch (Exception ex) {
                System.out.println("Error desconocido. Inténtelo de nuevo: ");
            }
        } while (!valid);
        return result;
    }
	
	
}
