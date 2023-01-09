package clases;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestorAlmacenApp {
	public void run() {
	

		final int REALIZAR_VENTA = 1;
		final int REALIZAR_COMPRA = 2;
		final int VERARTSALUDABLE = 3;
		final int VERARTMASCARO = 4;
		final int VERARTCONMENOSSTOCK = 5;
		final int SALIR = 0;

		Scanner scan = new Scanner(System.in);
		int opcion_menu;

		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null," ------MENU------\n" +
			REALIZAR_VENTA + ". Realizar venta\n" +
			REALIZAR_COMPRA + ". Realizar compra\n" +
			VERARTCONMENOSSTOCK + ". Ver articulos saludables\n" +
			VERARTMASCARO + ". Ver el articulo mas caro\n" +
			VERARTCONMENOSSTOCK + ". Ver los articulos con menos stock\n" +
			SALIR + ". Salir\nElije una de las opciones"));

			switch (opcion_menu) {
			case REALIZAR_VENTA:
				JOptionPane.showMessageDialog(null, "Opcion de Realizar venta seleccionada");

				break;
			case REALIZAR_COMPRA:
				JOptionPane.showMessageDialog(null, "Opcion de Realizar compra seleccionado");
				
				break;
			case VERARTSALUDABLE:
				JOptionPane.showMessageDialog(null, "Opcion de ver articulos saludable seleccionado");
				
				break;
			case VERARTMASCARO:
				JOptionPane.showMessageDialog(null, "Opcion de ver el articulo mas caro seleccionado");
				
				break;
			case VERARTCONMENOSSTOCK:
				JOptionPane.showMessageDialog(null, "Opcion de ver el articulo con menos estock seleccionado");
				
				break;
			case SALIR:
				JOptionPane.showMessageDialog(null, "Agur!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve a intentarlo!");
			}

		} while (opcion_menu != SALIR);
		
		
	}
}
