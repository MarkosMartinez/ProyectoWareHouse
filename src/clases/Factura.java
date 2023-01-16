package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Factura {

	private static final int IVA = 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	ArrayList<LineaFactura> lineaFacturas = new ArrayList<>();
	
	public Factura() {
		
	}
	
	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto) {
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
	
	public void addLinea(LineaFactura lineaFactura) {
		Iterator<LineaFactura> lineas=lineaFacturas.iterator();
		boolean existe = false;
		while(lineas.hasNext() && existe == false) {
			LineaFactura facturas = (LineaFactura) lineas.next();
			if(facturas.equals(lineaFactura)) {
				JOptionPane.showMessageDialog(null, "La factura ya esta en la lista");
				existe = true;
			}
			if(lineas.hasNext()) {
				lineas.next();
			}
			
		}
		if(!existe){
			lineaFacturas.add(lineaFactura);
		}
	}
	
	public void eliminarLinea(int numeroLinea) {
		Iterator<LineaFactura> lineas=lineaFacturas.iterator();
		boolean existe = false;
		while(lineas.hasNext() && existe == false) {
			LineaFactura facturas = (LineaFactura) lineas.next();
			if(facturas.getNumero() == numeroLinea) {
				JOptionPane.showMessageDialog(null, "Lineas eliminadas!");
				lineas.remove();
				existe = true;
			}
			lineas.next();
		}
	}
	
	public double precioTotal() {

		return 0;
	}
	
	public void mostrarEnPantalla() {
		//Mostrar la factura
	}
	
	public void guardarEnFichero() {
			
		}
	
}
