package clases;

import javax.swing.JOptionPane;

public class Cerveza extends Articulo implements Alcoholico {
	private String origen;
	private String cereales;
	private double gradosAlcohol;
	
	public Cerveza() {
		super();
	}
	
	public Cerveza(String tipo, String code, String name, String mark, int capacidadBotella, double precio, int stock,
			String origen, String cereales, double gradosAlcohol) {
		super(tipo, code, name, mark, capacidadBotella, precio, stock);
		this.origen = origen;
		this.cereales = cereales;
		this.gradosAlcohol = gradosAlcohol;
	}
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getCereales() {
		return cereales;
	}

	public void setCereales(String cereales) {
		this.cereales = cereales;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}

	@Override
	public boolean esFuerte() {
		boolean fuerte = false;
		if(this.gradosAlcohol >= 7){
			fuerte = true;
		}
		return fuerte;
	}

	
	
	@Override
	public double calcularTasa() {
		double tasa;
		if(this.esFuerte()) {
			tasa=TASA_BEBIDAS_FUERTES;
		}
		else {
			tasa=TASA_BEBIDAS_SUABES;
		}
		return tasa;
	}

	@Override
	public String toString() {
		return "Datos de la Cerveza:\nOrigen: " + origen + "\n Cereales: " + cereales + "\nGrados de alcohol: " + gradosAlcohol + "\n" + super.toString();
	}

	@Override
	public void visualizarArticulo() {
		JOptionPane.showMessageDialog(null, super.toString() + "\nOrigen: " + origen + "\n Cereales: " + cereales + "\nGrados de alcohol: " + gradosAlcohol);
		
	}

	@Override
	public void precioTotal() {
		int stock = this.getStock();
		double precio = this.getPrecio();
		double total = stock * precio;
		System.out.println("El precio de todas las cervezas es: "+ total);
	}

	@Override
	public boolean saludable() {
		boolean saludable = false;
		if(this.gradosAlcohol <= 8){
			saludable = true;
		}
		return saludable;
	}

}
