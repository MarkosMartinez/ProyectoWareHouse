package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Almacen {
	
	public Almacen() {}
	
	ArrayList<Articulo> articulos = new ArrayList<>();
	
	public ArrayList<Articulo> getArticulos(){
		return articulos;
	}
	
	public void cargarDatos() throws FileNotFoundException {
		File file = new File("datos/datos.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			String linea[]= scan.nextLine().split(";");
			if(linea[0].toLowerCase().equals("refresco")) {
				Refresco refresco = new Refresco(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]), Double.parseDouble(linea[5]), Integer.parseInt(linea[6]), linea[7], Boolean.parseBoolean(linea[8]), Boolean.parseBoolean(linea[9]), Integer.parseInt(linea[10]));	
				articulos.add(refresco);
				refresco.visualizarArticulo();
			}else if(linea[0].toLowerCase().equals("vino")) {
				Vino vino = new Vino(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]), Double.parseDouble(linea[5]), Integer.parseInt(linea[6]), linea[7], linea[8], Integer.parseInt(linea[9]), linea[10], Double.parseDouble(linea[11])); 
				articulos.add(vino);
				vino.visualizarArticulo();
			}else if(linea[0].toLowerCase().equals("cerveza")) {
				Cerveza cerveza = new Cerveza(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]), Double.parseDouble(linea[5]), Integer.parseInt(linea[6]), linea[7], linea[8], Double.parseDouble(linea[9]));
				articulos.add(cerveza);
				cerveza.visualizarArticulo();
			}else {
				JOptionPane.showMessageDialog(null, "Hay un error en la lista de articulos! Por favor finaliza el programa.");
			}
		}
		scan.close();
	}
		
	public Articulo elMasCaro() {
		Articulo precioMaximo = null;
		double precio = 0;
		
		for (Articulo articulo : articulos) {
			if(articulo.getPrecio()>precio) {
				precioMaximo = articulo;
				precio = articulo.getPrecio();
			}
			/* Si quieres hacer que si no hay stock no lo muestre
			if(articulo.getPrecio()>precio) {
				if(articulo.getStock()>0) {
				 precioMaximo = articulo;
				 precio = articulo.getPrecio();
				}
			}
			 * */
		}
		return precioMaximo;
	}
	
	public double precio(String codigoProducto) throws FileNotFoundException {
		double precio = 0;
		File file=new File("datos/articulos.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
		String linea[]= scan.nextLine().split(";");
			if(linea[1] == codigoProducto) {
			precio= Double.parseDouble(linea[5]);
			}
		}
		scan.close();
		return precio;
	}
	
	public boolean hayStock(String codigoProducto) throws FileNotFoundException {
		File file=new File("datos/articulos.txt");
		Scanner scan = new Scanner(file);
		boolean stock = false;
		
		while(scan.hasNextLine()) {
		String linea[]= scan.nextLine().split(";");
			if((linea[1] == codigoProducto) && (Integer.parseInt(linea[6]) > 0)) {
			stock = true;
			}
		}
		scan.close();
		return stock;
	}
	
	public ArrayList<Articulo> stockJusto(int cantidad){
		ArrayList<Articulo> stockJusto = new ArrayList<Articulo>();
		for (Articulo articulos : articulos) {
			if(articulos.getStock()<cantidad) {
				stockJusto.add(articulos);
			}
		}
		return stockJusto;
	}
	
	public Articulo articulo(String codigoProducto) {
		Articulo articulodevuelto = null;
		Iterator<Articulo> it = articulos.iterator();
		boolean encontrado = false;
		while(it.hasNext()||encontrado == false) {
			Articulo articulo = (Articulo) it.next();
			if(articulo.getCode().equals(codigoProducto)) {
				encontrado = true;
				articulodevuelto = articulo;
			}
			it.next();
		}
		return articulodevuelto;
	}
	
	public boolean disponibilidad(int cantidad, String codigoProducto) {
		boolean disponible = false;
		boolean encontrado = false;
		Iterator<Articulo> here = articulos.iterator();
		while(here.hasNext() && !encontrado) {
			Articulo articulo = (Articulo) here.next();
			if(articulo.getCode().equals(codigoProducto) && articulo.getStock() > cantidad) {
				disponible = true;
				encontrado = true;
			}
			if(here.hasNext()) {
				here.next();
			}
		}
		return disponible;
	}

	public ArrayList<Articulo> equivalente(Articulo articulo){
		ArrayList<Articulo> equivalente=new ArrayList<Articulo>();
		double diferencias;
		for(Articulo articulos:articulos) {
			if(articulos.getTipo() == articulo.getTipo()){
				if(articulos.getPrecio() > articulo.getPrecio()) {
					diferencias = articulos.getPrecio() - articulo.getPrecio();
				}else {
					diferencias = articulo.getPrecio() - articulos.getPrecio();
				}
				if(diferencias <= 0.2 ) {
					equivalente.add(articulos);
				}
			}
		}
		return equivalente;
	}
	

	public ArrayList<Articulo> ordenarPorPrecio(String orden) {
		
		return null;
	}
	
	public void ordenarPorStock(String orden) {
		
	}
	

}
