class Apple {
	private String elemento;
    private String color;
    private String tipo;
    private int peso;
    public Apple() {
    	 elemento = "";
         peso = 0;
         color = "";
         tipo = "";
    }
    public Apple(String elemento, String color, int peso, String tipo) {
        System.out.println("Ejec. Banana constructor");
        this.elemento = elemento;
        this.color = color;
        this.peso = peso;
        this.tipo = tipo;
    }
    public void setElemento(String el) {
    	elemento = el;
    }
    
    public String getElemento() {
    	return elemento;
    }
    
    public void setPeso(int p) {
      peso = p;
    }
    public int getPeso() {
      return peso;
    }
    public void setTipo(String t) {
      tipo = t;
    }
    public String getTipo() {
      return tipo;
    }
    public void setColor(String c) {
      color = c;
    }
    public String getColor() {
      return color;
    }
}
