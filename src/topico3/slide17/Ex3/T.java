package topico3.slide17.Ex3;

import java.io.*;

/**
 *
 * @author itsgnegrao
 */
public class T extends Thread {

    @Override
    public void run() {
        File file = new File("topico3slide17/frases.txt");
        while (true) {
            try {
                System.out.println("Acordei!");
                BufferedReader br = new BufferedReader(new FileReader(file));

                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                    Thread.sleep(200);
                }
                System.out.println("Irei dormir agora por 4 segundos!\n");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Recebi um Interrupt do Pai!");
                this.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
