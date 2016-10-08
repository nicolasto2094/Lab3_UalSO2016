
package akkatutorial;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

 
public class Cajero extends UntypedActor {
    public enum Mensaje {
        WAIT_Antonio,
        OK_Antonio,
        WAIT_Blanca,
        OK_Blanca,
        Finish_Blanca,
        Finish_Antonio
    }
 
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
 
 
    @Override
    public void preStart() {
         Main.antonio.tell(Antonio.Mensaje.START, getSelf());
    }
    
     boolean Ant=false,Bla=false;
    
    @Override
    public void onReceive(Object o) throws InterruptedException {
        
        if(o == Mensaje.Finish_Antonio){Ant=true;}
        if(o == Mensaje.Finish_Blanca){Bla=true;}
        
        if(Ant==true && Bla==true){System.out.println("El Total es: "+Main.Total);
             System.exit(0);
        }else{
         
            if (o == Mensaje.OK_Blanca) {
               Main.antonio.tell(Antonio.Mensaje.START, getSelf());
                Main.blanca.tell(Blanca.Mensaje.STOP, getSelf());
            }
            else if (o == Mensaje.OK_Antonio) {
                Main.antonio.tell(Antonio.Mensaje.STOP, getSelf());
                Main.blanca.tell(Blanca.Mensaje.START, getSelf());
            }

        
        }}
 

}