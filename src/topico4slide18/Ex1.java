package topico4slide18;

import java.io.*;
import java.util.*;
/**
 * Fa¸ca um programa em Java que use Threads para encontrar
 * os n´umeros primos dentro de um intervalo. O m´etodo que
 * contabiliza os n´umeros primos deve possuir como entrada:
 * valor inicial e final do intervalo, n´umero de threads.
 * @author itsgnegrao
 */

class T1 extends Thread{

    private static Interval interval;
    
    public T1(Interval interval){
        this.interval = interval;
    }

    public static boolean isPrimo (int x){
		for (int i=2; i<x; i++){
			if (x % i == 0){
                return false;
			}
		}
		return true;
	}

    @Override
    public void run(){
        while(true){
            try{
                int number = this.interval.getNext();
                System.out.println(number);
                if(number < 0) this.stop();
                if(isPrimo(number)) System.out.println("É Primo");
                
            }
            catch(Exception e){
                e.printStackTrace();
            } 
        }
    }
}

class Interval {
    private static int startInterval = 0;
    private static int endInterval = 0;
    private static int value = 0;

    public Interval(int startInterval, int endInterval){
        this.value = startInterval;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

    public int getNext(){
        int ret = value;
        value++;
        return (ret <= endInterval ? ret : -1);
    }
}

public class Ex1 {
    public static void main(String[] args){
        System.out.print("Digite um intervalo separados por espaço: ");
        String inputString[] = new Scanner(System.in).nextLine().split(" ");
        Interval interval = new Interval(Integer.valueOf(inputString[0]), Integer.valueOf(inputString[1]));
        try{
            T1 thread = new T1(interval);
            thread.start();
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
