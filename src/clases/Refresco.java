package clases;

import javax.swing.JOptionPane;

public class Refresco extends Articulo {
	
	private String sabor;
	/*Crear tipo?*/
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	public Refresco() {
    	super();
	}
	
	public Refresco(String tipo, String code, String name, String mark, int capacidadBotella,
			double precio, int stock, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super(tipo, code, name, mark, capacidadBotella, precio, stock);
		this.sabor = sabor;
		this.zumo = zumo;
		this.gaseoso = gaseoso;
		this.cantidadAzucar = cantidadAzucar;
	}
	
	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public boolean isZumo() {
		return zumo;
	}

	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}

	public boolean isGaseoso() {
		return gaseoso;
	}

	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}

	public int getCantidadAzucar() {
		return cantidadAzucar;
	}

	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}

	

	@Override
	public void visualizarArticulo() {
		JOptionPane.showMessageDialog(null, super.toString() + "\nSabor: " + sabor + "\nZumo: " + zumo + "\nGaseoso: " + gaseoso + "\nCantidad de azucar: " + cantidadAzucar);
	}

	@Override
	public void precioTotal() {
		int stock = this.getStock();
		double precio = this.getPrecio();
		double total = stock * precio;
		System.out.println("El precio de todos los refrescos es: "+ total);
	}
	
	@Override
	public String toString() {
		return "Datos del Refresco:\nSabor: " + sabor + "\nZumo: " + zumo + "\nGaseoso: " + gaseoso + "\nCantidad de azucar: " + cantidadAzucar + "\n" + super.toString();
	}

	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
