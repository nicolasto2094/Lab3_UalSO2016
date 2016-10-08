
package akkatutorial;

import akka.actor.UntypedActor;
 
public class Antonio extends UntypedActor {
    public enum Mensaje {
        STOP,
        START,
    }
    
    int a =0;
    @Override
    public void onReceive(Object o) {
        if(a<Main.CantidadAntonioOp){

            if (o == Mensaje.START) {
                Main.Total=Main.AntonioOp[a]+Main.Total;
                Main.cajero.tell(Cajero.Mensaje.OK_Antonio, getSelf());
                a++;
            }else if (o == Mensaje.STOP) {}
        }else{
            
            Main.cajero.tell(Cajero.Mensaje.OK_Antonio, getSelf());
            Main.cajero.tell(Cajero.Mensaje.Finish_Antonio, getSelf());}
    }

}

