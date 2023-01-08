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
			if(linea[0].toLowerCase().equals("refresco")) {
				Refresco refresco = new Refresco(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]), Double.parseDouble(linea[5]), Integer.parseInt(linea[6]), linea[7], Boolean.parseBoolean(linea[8]), Boolean.parseBoolean(linea[9]), Integer.parseInt(linea[10]));	
				articulos.add(refresco);
			}else if(linea[0].toLowerCase().equals("vino")) {
				Vino vino = new Vino(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]), Double.parseDouble(linea[5]), Integer.parseInt(linea[6]), linea[7], linea[8], Integer.parseInt(linea[9]), linea[10], Double.parseDouble(linea[11])); 
				articulos.add(vino);
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
