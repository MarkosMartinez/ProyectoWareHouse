package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestorAlmacenApp {
	public void run() throws FileNotFoundException, ParseException {

		final int REALIZAR_VENTA = 1;
		final int REALIZAR_COMPRA = 2;
		final int VERARTSALUDABLE = 3;
		final int VERARTMASCARO = 4;
		final int VERARTCONMENOSSTOCK = 5;
		final int SALIR = 0;
		
		Almacen almacen = new Almacen();
		JOptionPane.showMessageDialog(null, "Estos son todos los elementos de nuestra lista.\nRecuerda memorizarte el codigo del producto si lo quieres comprar!");
		almacen.cargarDatos();

		Scanner scan = new Scanner(System.in);
		int opcion_menu;

		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null," ------ Ware House ------\n" +
			REALIZAR_VENTA + ". Realizar venta\n" +
			REALIZAR_COMPRA + ". Realizar compra\n" +
			VERARTSALUDABLE + ". Ver articulos saludables\n" +
			VERARTMASCARO + ". Ver el articulo mas caro\n" +
			VERARTCONMENOSSTOCK + ". Ver los articulos con menos stock\n" +
			SALIR + ". Salir\nElije una de las opciones: "));

			switch (opcion_menu) {
			case REALIZAR_VENTA:
				JOptionPane.showMessageDialog(null, "Opcion de Realizar venta seleccionada");
				boolean maslineas = true;
				int numLinea = 1;
				
				SimpleDateFormat formatoFecha= new SimpleDateFormat("dd-MM-yyyy");
				int numFact = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe el numero de la factura: "));
				String nombreEmpresaFact = JOptionPane.showInputDialog(null, "Escribe el nombre de la empresa: ");
				String fechaFactSinFormato = JOptionPane.showInputDialog(null, "Escribe la fecha de la factura: ");
				Date fechaFact = formatoFecha.parse(fechaFactSinFormato);
				String conceptoFact = JOptionPane.showInputDialog(null, "Escribe el concepto de la factura: ");
				
				Factura factura = new Factura(numFact, nombreEmpresaFact, fechaFact, conceptoFact);
				
				do {
					//Aqui estara el codigo para ir creando las lineas de la factura.
					
					
					
					String masLineasString = JOptionPane.showInputDialog(null, "Quieres seguir añadiendo lineas? (s/n): ");
					if(masLineasString.toLowerCase().charAt(0) == 'N')
						maslineas = false;
					numLinea++;
				}while(maslineas == true);
				
				break;
			case REALIZAR_COMPRA:	
				String IDArticulo = JOptionPane.showInputDialog(null, "Escribe el ID del elemento al que le quieres subir el Stock: ");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de stock a aumentar: "));
                boolean encontrado = false;
                for(Articulo articulo:almacen.articulos) {
                    if(articulo.getCode().equals(IDArticulo)) {
                    	articulo.incrementarStock(cantidad);
                    	encontrado = true;
                    	JOptionPane.showMessageDialog(null, "Elemento aumentado: " + articulo.getName() + " a " + articulo.getStock() + " unidades!");
                    }
                }
                if(!encontrado) {
                	JOptionPane.showMessageDialog(null, "No he podido encontrar ese elemento!\n Intentalo de nuevo.");
                }
				break;
			case VERARTSALUDABLE:
				JOptionPane.showMessageDialog(null, "Lista de articulos saludables: ");
				for(Articulo articulo:almacen.articulos) {
					if(articulo.saludable()) {
						JOptionPane.showMessageDialog(null, articulo);
					}
				}
				
				break;
			case VERARTMASCARO:
				JOptionPane.showMessageDialog(null, "El articulo mas caro existente en nuestros almacenes es: " + almacen.elMasCaro());
				
				break;
			case VERARTCONMENOSSTOCK:
				int cantidadStock = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe la cantidad maxima de Stock de la lista de elementos que quieres ver: "));
				JOptionPane.showMessageDialog(null, "Articulos con menos Stock de " + cantidadStock);
				for (int i = 0; i < almacen.stockJusto(cantidadStock).size(); i++) {
					JOptionPane.showMessageDialog(null, almacen.stockJusto(cantidadStock).get(i));
				}
				
				break;
			case SALIR:
				JOptionPane.showMessageDialog(null, "Agur!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve a intentarlo!");
			}

		} while (opcion_menu != SALIR);
		
		scan.close();
	}
}
