package clases;

public abstract class Articulo {
	private String code;
	private String name;
	private String mark;
	private int capacidadBotella;
	private double precio;
	private int stock;
	private String tipo;
		
public Articulo() {
	
}
	
	public Articulo(String tipo, String code, String name, String mark, int capacidadBotella, double precio, int stock) {
		this.tipo = tipo;
		this.name = name;
		this.code = code;
		this.mark = mark;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public abstract boolean saludable();
	public abstract void precioTotal();
	
	@Override
	public String toString() {
		return "Codigo: " + code + "\nNombre: " + name + "\nMarca: " + mark + "\nCapacidad de la Botella: " + capacidadBotella + "\nPrecio: " + precio + "\nStock: " + stock;
	}
	
	
	
}
