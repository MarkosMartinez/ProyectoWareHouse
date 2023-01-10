package clases;

import javax.swing.JOptionPane;

public class Vino extends Articulo implements Alcoholico {

	private String color;
	private String origen;
	private int anio;
	private String tipoDeUva;
	private double gradosAlcohol;
	
	private boolean saludable;
	
	public Vino() {
		super();
	}
	
	public Vino(String tipo, String code, String name, String mark, int capacidadBotella, double precio, int stock,
			String color, String origen, int anio, String tipoDeUva, double gradosAlcohol) {
		super(code, name, mark, capacidadBotella, precio, stock);
		this.color = color;
		this.origen = origen;
		this.anio = anio;
		this.tipoDeUva = tipoDeUva;
		this.gradosAlcohol = gradosAlcohol;
		this.saludable = esSaludable();
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTipoDeUva() {
		return tipoDeUva;
	}

	public void setTipoDeUva(String tipoDeUva) {
		this.tipoDeUva = tipoDeUva;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}

	
	@Override
	public String toString() {
		return "Datos del Vino:\nColor: " + color + "\nOrigen: " + origen + "\nAño: " + anio + "\nTipo de Uva: " + tipoDeUva + "\nGrados de Alcohol: " + gradosAlcohol + "\n" + super.toString();
	}
	
	@Override
	public void visualizarArticulo() {
		JOptionPane.showMessageDialog(null, super.toString() + "\nColor: " + color + "\nOrigen: " + origen + "\nAño: " + anio + "\nTipo de Uva: " + tipoDeUva + "\nGrados de Alcohol: " + gradosAlcohol);
	}

	@Override
	public void precioTotal() {
		int stock = this.getStock();
		double precio = this.getPrecio();
		double total = stock * precio;
		System.out.println("El precio de todas las cervezas es: "+ total);
	}

	@Override
	public boolean esSaludable() {
		boolean saludable = false;
		if((this.origen.toLowerCase().equals("rioja")) && this.gradosAlcohol <= 18) {
			saludable = true;
		}
		return saludable;
	}

	@Override
	public boolean esFuerte() {
		boolean fuerte = false;
		if(this.gradosAlcohol >= 14){
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


}
