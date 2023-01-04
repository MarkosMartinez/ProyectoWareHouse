package clases;

public class LineaFactura {
	private int numero;
	private Articulo Articulo;
	public Articulo getArticulo() {
		return Articulo;
	}
	public void setArticulo(Articulo articulo) {
		Articulo = articulo;
	}
	private int cantidad;
	
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

}
