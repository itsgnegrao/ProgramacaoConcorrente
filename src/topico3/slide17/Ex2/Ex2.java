package topico3.slide17.Ex2;

import java.io.*;

/**
 * Faca uma thread Java que realize a leitura de um arquivo
 * texto com frases e exiba as frases a cada 10 segundos.
 * @author itsgnegrao
 */
public class Ex2 {
    public static void main(String[] args){
        new Thread(() -> {
            File file = new File("topico3slide17/frases.txt");
            while(true){
                try{
                    System.out.println("Acordei!");
                    BufferedReader br = new BufferedReader(new FileReader(file)); 
                
                    String str = ""; 
                    while ((str = br.readLine()) != null) {
                      System.out.println(str); 
                      Thread.sleep(200);
                    } 
                    System.out.println("Irei dormir agora por 4 segundos!\n");
                    Thread.sleep(10000);
                }
                catch(Exception e){
                    e.printStackTrace();
                } 
            }
        }).start();
    }
}
