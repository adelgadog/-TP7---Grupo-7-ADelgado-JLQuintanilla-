package Clases;

public class Compra {
  private Person per;
  private int cant;
  public Compra() {
    // constructor por defecto
    per = new Person();
    cant = 0;
  }
  public void setPer(String name) {
    per.setName(name);
  }

  public void setCant(int cant) {
    this.cant = cant;
  }
  public Person getPer() {
    return per;
  }

  public int getCant() {
    return cant;
  }
}
