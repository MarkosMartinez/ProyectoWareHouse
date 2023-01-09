package clases;

public abstract class Articulo {
	protected String code;
	protected String name;
	protected String mark;
	protected int capacidadBotella;
	protected double precio;
	protected int stock;
		
public Articulo() {
	
}
	
	public Articulo(String code, String name, String mark, int capacidadBotella, double precio, int stock) {
		this.name = name;
		this.code = code;
		this.mark = mark;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getCapacidadBotella() {
		return capacidadBotella;
	}

	public void setCapacidadBotella(int capacidadBotella) {
		this.capacidadBotella = capacidadBotella;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	public void incrementarStock(int cantidad) {
		this.stock += cantidad;
	}
	
	public void disminuirStock(int cantidad) {
		if (cantidad >= this.stock) {
			this.stock -= cantidad;
		}else {
			System.out.println("Error no se puede disminuir mas el Stock.");
		}
	}
	

	
	public abstract void visualizarArticulo();
	public abstract boolean esSaludable();
	public abstract void precioTotal();
	
	@Override
	public String toString() {
		return "Codigo: " + code + ", Nombre: " + name + ", Marca: " + mark + ", Capacidad de la Botella: " + capacidadBotella + ", Precio: " + precio + " y Stock: " + stock;
	}
	
	
	
}
