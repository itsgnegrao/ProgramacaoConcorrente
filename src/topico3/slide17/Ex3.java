package topico3.slide17;

import java.io.*;

/**
 * Faca um programa Java que envia interru¸coes para as 
 * threads dos exercicios anteriores. As threads devem fazer o
 * tratamento dessas interrupcoes e realizar uma finalizacao
 * limpa.
 * @author itsgnegrao
 */

class T extends Thread{

    @Override
    public void run(){
        File file = new File("topico3slide17/frases.txt");
        while(true){
            try{
                System.out.println("Acordei!");
                BufferedReader br = new BufferedReader(new FileReader(file)); 
            
                String str; 
                while ((str = br.readLine()) != null) {
                    System.out.println(str); 
                    Thread.sleep(200);
                } 
                System.out.println("Irei dormir agora por 4 segundos!\n");
                Thread.sleep(4000);
            }
            catch(InterruptedException e){
                System.out.println("Recebi um Interrupt do Pai!");
                this.stop();
            }
            catch(Exception e){
                e.printStackTrace();
            } 
            
        }
}
}

public class Ex3 {
    public static void main(String[] args){
        try{
            Thread t1 = new T();
            t1.start();
            Thread.sleep(5000);
            t1.interrupt();
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
