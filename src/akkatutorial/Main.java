
package akkatutorial;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public final class Main {
 
    public static ActorRef antonio;
    public static ActorRef blanca;
    public static ActorRef cajero;
    public static ActorSystem actorSystem;
    
    public static int Total = 0;
    
    public static int CantidadAntonioOp;
    public static int[]AntonioOp;
    
    public static int CantidadBlancaOp;
    public static int[]BlancaOp;
    
  
    private Main() {}
 
    public static void main(String[] args) throws InterruptedException, IOException {
        
        int[]Ope=Leer();
                CantidadAntonioOp=Ope[0];
                AntonioOp = new int[Ope[0]];
                for (int j = 0; j < Ope[0]; j++) {
                    AntonioOp[j]=Ope[j+2];
            }
                CantidadBlancaOp=Ope[1];
                BlancaOp = new int[Ope[1]];
                for (int j = 0; j < Ope[1]; j++) {
                    BlancaOp[j]=Ope[j+2+Ope[0]];
                }         
        
        actorSystem = ActorSystem.create("ActorSystem");
        antonio = actorSystem.actorOf(Props.create(Antonio.class), "antonio");
        blanca = actorSystem.actorOf(Props.create(Blanca.class), "blanca");
        cajero = actorSystem.actorOf(Props.create(Cajero.class), "cajero");
        
     
        
    }
    
    
    
        static int []Leer() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader("operaciones.txt"));
                
		int n = 0,i = 0;
	
		String line = "";
                while ((line = in.readLine()) != null&&i<2) {
			n=Integer.parseInt(line)+n;
                        i++;
                        
		}int []Ope = new int[n+2];i=0;
                line = "";
                in = new BufferedReader(new FileReader("operaciones.txt"));
		while ((line = in.readLine()) != null&&i<n+2) {

			Ope[i]=Integer.parseInt(line);
                        i++;
		}System.out.println("Cliente Antonio realiza "+Ope[0]+" ope:");
                 System.out.println("Cliente Blanca realiza "+Ope[1]+" ope:");

		in.close();
                
                
                return Ope;
        }
}