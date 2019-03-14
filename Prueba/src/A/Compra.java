public class Compra {
  private Person per;
  private Articulo art;
  private int cant;
  public Compra() {
 
    per = new Person();
    art = new Articulo ();
    cant = 0;

  }
  public void setPer(String name) {
    per.setName(name);
  }
  

  public Person getPer() {
    return per;
  		}
  
  public void setArt(String producto, String tienda, int precio) {
	  art.setProd(producto);
	  art.setTienda(tienda);
	  art.setPrecio(precio);
  		}
  public void setProd(String producto) {
	  art.setProd(producto);
  		}
  
  public Articulo getProd() {
	  return art;
  		}
  
  public void setTienda(String tienda) {
	  art.setProd(tienda);
  		}
  
  public Articulo getTienda() {
	  return art;
  		}

  public void setCant(int cant) {
    this.cant = cant;
  		}
  
  public int getCant() {
	    return cant;
	    }
  






}
