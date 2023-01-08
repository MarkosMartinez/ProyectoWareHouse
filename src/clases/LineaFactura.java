package clases;

public class LineaFactura {
	private int numero;
	private Articulo articulo;
	private int cantidad;
	
	public LineaFactura(int numero, Articulo articulo, int cantidad) {
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public LineaFactura() {
		
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	public double precioTotal(){
		double total = 0.0;
		total = cantidad * articulo.getPrecio();
		return total;
	}
}
