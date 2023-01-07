package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
			if(Integer.parseInt(linea[0]) <= 9) {
				
				Refresco refresco = new Refresco(linea[1], linea[2], linea[3], linea[4],
						Boolean.parseBoolean(linea[5]), Boolean.parseBoolean(linea[6]),
						Integer.parseInt(linea[7]), Integer.parseInt(linea[8]),
						Double.parseDouble(linea[9]), Integer.parseInt(linea[10]));
				
				articulos.add(refresco);
			}
		
			
			
		}
	}
	
	public Articulo elMasCaro() {
		
		return null;
	}
	
	public double precio(String codigoProducto) {
		
		return 0;
	}
	
	public boolean hayStock(String codigoProducto) {
		
		return false;
	}
	
	public ArrayList<Articulo> stockJusto(){
		
		return null;
	}
	
	public Articulo articulo(String codigoProducto) {
		
		return null;
	}
	
	public boolean disponibilidad(int cantidad, String codigoProducto) {
		
		return false;
	}
	
	public ArrayList<Articulo> equivalentes(Articulo articulo){
		
		return null;
	}
	
	public ArrayList<Articulo> ordenarPorPrecio(String orden) {
		
		return null;
	}
	
	public void ordenarPorStock(String orden) {
		
	}

}
