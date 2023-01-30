package clases;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
				int numLinea = 1;
				
				SimpleDateFormat formatoFecha= new SimpleDateFormat("dd-MM-yyyy");
				int numFact = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe el numero de la factura: "));
				String nombreEmpresaFact = JOptionPane.showInputDialog(null, "Escribe el nombre de la empresa: ");
				String fechaFactSinFormato = JOptionPane.showInputDialog(null, "Escribe la fecha de la factura (dd-MM-yyyy): ");
				Date fechaFact = formatoFecha.parse(fechaFactSinFormato);
				String conceptoFact = JOptionPane.showInputDialog(null, "Escribe el concepto de la factura: ");
				
				Factura factura = new Factura(numFact, nombreEmpresaFact, fechaFact, conceptoFact);
				
				String masLineasString = "";
				do {
					anadirLinea(numLinea,factura,scan,almacen);
					masLineasString = JOptionPane.showInputDialog(null, "Quieres seguir añadiendo lineas? (s/n): ");
					numLinea++;
				}while(!masLineasString.toUpperCase().equals("N"));
				JOptionPane.showMessageDialog(null, "Mostrando la factura: ");
				factura.mostrarEnPantalla();
				masLineasString = JOptionPane.showInputDialog(null, "Quieres guardar la factura? (s/n)");
				if(masLineasString.toLowerCase().equals("s")) {
					factura.guardarEnFichero();
					JOptionPane.showMessageDialog(null, "Factura guardada.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Gracias por la compra :)");
				}
				
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
	
	
	private static void anadirLinea(int numLinea,Factura fact,Scanner sc,Almacen almacen) {
		int cantidad = 0;
		LineaFactura linea = new LineaFactura();
		boolean encontrado = false;
		Articulo articulo = null;
		int id;
		
		Cerveza cerveza = new Cerveza();
		Vino vino = new Vino();
		Refresco refresco = new Refresco();
		
		
		Iterator<Articulo> it = almacen.articulos.iterator();
		linea.setNumero(numLinea);
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del articulo: "));
		while(it.hasNext() && !encontrado) {
			articulo = (Articulo) it.next();
			//System.out.println("Codigos M/S: " + id + " - " + articulo.getCode());
			if(id == Integer.parseInt(articulo.getCode())) {
				encontrado = true;
				if(articulo instanceof Refresco) {
					refresco = (Refresco) articulo;
					linea.setArticulo(refresco);
				}
				else if(articulo instanceof Vino) {
					vino = (Vino) articulo;
					linea.setArticulo(vino);
				}
				else if(articulo instanceof Cerveza) {
					cerveza = (Cerveza)articulo;
					linea.setArticulo(cerveza);
				}
			}
			if(it.hasNext()){
				it.next();
			}
		}
		if(!encontrado) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado el articulo q buscas");
		}else {
			cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que quieres comprar: "));
			if(almacen.disponibilidad(cantidad, articulo.getCode())) {
				linea.setCantidad(cantidad);
				}
			else if(!almacen.disponibilidad(cantidad, articulo.getCode())) {
				JOptionPane.showMessageDialog(null, "No queda stock!");
			}
			else if(articulo.getStock()>0 && articulo.getStock()<cantidad){
				linea.setCantidad(articulo.getStock());
				JOptionPane.showMessageDialog(null, "No hay tanto stock pero te daremos lo que nos queda (" + articulo.getStock() + ").");
				articulo.setStock(0);
			}
		}
		fact.addLinea(linea);	
	}
	
	
}
