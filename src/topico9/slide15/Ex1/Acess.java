package topico9.slide15.Ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class Acess extends Thread{
    
    private boolean method;
    private Counter counter;

    public Acess(boolean method, Counter counter) {
        this.method = method;
        this.counter = counter;
    }

    @Override
    public void run(){  
        while(this.counter.modify(this.method)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Acess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
