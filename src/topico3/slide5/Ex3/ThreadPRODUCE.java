/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topico3.slide5.Ex3;

/**
 *
 * @author itsgnegrao
 */
public class ThreadPRODUCE extends Thread {

    Integer disputedCounter = 0;

    public Integer getDisputedCounter() {
        return disputedCounter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                disputedCounter++;
                System.out.println("PRODUZI: " + String.valueOf(disputedCounter));
                this.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
