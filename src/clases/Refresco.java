package clases;

public class Refresco extends Articulo {
	
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	/*public Refresco() {
    	super();
	}*/
	
	public Refresco(String tipo, String code, String name, String mark, int capacidadBotella,
			double precio, int stock, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super(code, name, mark, capacidadBotella, precio, stock);	
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
		System.out.println(toString()); //this.toSting()?
	}

	@Override
	public void precioTotal() {
		int stock = this.getStock();
		double precio = this.getPrecio();
		double total = stock * precio;
		System.out.println("El precio de todos los refrescos es: "+ total);
	}

	@Override
	public boolean esSaludable() {
		boolean saludable = false;
		if(cantidadAzucar < 20) {
			saludable = true;
		}
		return saludable;
	}
	
	public void visualizarPropiedades() {
		System.out.println("Sabor: " + sabor + ", Zumo: " + zumo + ", Gaseoso: " + gaseoso + ", Cantidad de azucar: " + cantidadAzucar);
	}
	
	@Override
	public String toString() {
		return "Datos del Refresco:\nSabor: " + sabor + "\nZumo: " + zumo + "\nGaseoso: " + gaseoso + "\nCantidad de azucar: " + cantidadAzucar+","+ super.toString();
	}
	

}
