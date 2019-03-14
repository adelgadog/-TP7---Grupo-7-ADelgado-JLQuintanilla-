class Articulo {
	private String producto;
	private String tienda;
	private int precio;
	
	
	public Articulo() {
		producto = "";
		tienda = "";
		precio = 0;
		
	}
	
	public Articulo(String producto, String tienda, int precio) {
		System.out.println("");
		this.producto = producto;
		this.tienda = tienda;
		this.precio = precio;
	}
	
	public void setProd(String p) {
		producto = p;
	}
	
	public String getProd() {
		return producto;
	}
	
    public void setTienda(String ti) {
        tienda = ti;
      }
      public String getTienda() {
        return tienda;
      }

	
	 public void setPrecio(int pr) {
	      precio = pr;
	    }
	    public int getPrecio() {
	      return precio;
	    }
	    
	


	
	

}
