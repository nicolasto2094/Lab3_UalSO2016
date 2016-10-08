/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akkatutorial;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
 
public class Blanca extends UntypedActor {
    public enum Mensaje {
        STOP,
        START,
    }
    public void contar(){
        
        }
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    int a =0;
    @Override
    public void onReceive(Object o) {
        
        if(a<Main.CantidadBlancaOp){
            
            if (o == Mensaje.START) {
                Main.Total=Main.BlancaOp[a]+Main.Total;
                Main.cajero.tell(Cajero.Mensaje.OK_Blanca, getSelf());
                a++;
            }else if (o == Mensaje.STOP){}
        }else{
            Main.cajero.tell(Cajero.Mensaje.OK_Blanca, getSelf());
            Main.cajero.tell(Cajero.Mensaje.Finish_Blanca, getSelf());}}
    }
