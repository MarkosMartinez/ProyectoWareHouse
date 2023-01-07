package clases;

public class Refresco extends Articulo {
	
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	public Refresco() {
    	super();
	}
	
	public Refresco(String code, String name,String mark, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar, int capacidadBotella, double precio, int stock) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void precioTotal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean esSaludable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void visualizarPropiedades() {
		//sysout
	}
	

}
