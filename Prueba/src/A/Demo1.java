import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {
   public static void main(String args[]) {
    Person p;
    List<Compra> lista = null;
    String input;
    Scanner leer = new Scanner(System.in);
    if (leer != null)
     {
        lista = new ArrayList<Compra>();
        while(true) {
          Compra una_compra = new Compra();
          System.out.println(" ¿Cómo te llamas?");
          input = leer.nextLine();
          una_compra.setPer(input);
          //while(true) {
          System.out.println(" ¿Qué fue lo último que compraste? ");
          input = leer.nextLine();
          una_compra.setProd(input);
          System.out.println(" ¿En qué tienda lo compraste? ");
          input = leer.nextLine();
          una_compra.setTienda(input);
          System.out.println(" ¿Cuántos/as compraste? ");
          input = leer.nextLine();
          int cant = Integer.parseInt(input);
          una_compra.setCant(cant);
          lista.add(una_compra);
          for (int i = 0; i < lista.size(); i++) {         
         System.out.println(" ¿Has comprado algo más? [s/n]: ");
          if (leer.nextLine().equals("n"))
        	  break; }
                  	  
          System.out.println(" Otra entrada? [s/n]: ");        
          if(leer.nextLine().equals("n"))
               break;
        }
        System.out.println("\n\n");
        for(Compra c: lista){
          System.out.println((c.getPer().getName() + ", ") + "has comprado " +  c.getCant()
          + " unidades de " + c.getProd().getProd() + "en " + c.getTienda() + "." );
          
        
        }
     }
  }

  
}
