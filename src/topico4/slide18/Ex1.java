package topico4.slide18;

import java.util.*;
/**
 * Faca um programa em Java que use Threads para encontrar
 * os nuumeros primos dentro de um intervalo. O metodo que
 * contabiliza os numeros primos deve possuir como entrada:
 * valor inicial e final do intervalo, numero de threads.
 * @author itsgnegrao
 */

public class Ex1 {
    public static void main(String[] args){
        System.out.print("Digite um intervalo separados por espaço: ");
        String inputString[] = new Scanner(System.in).nextLine().split(" ");
        System.out.print("Digite a quantidade de Threads: ");
        String qtde = new Scanner(System.in).nextLine();
        
        Interval interval = new Interval(Integer.valueOf(inputString[0]), Integer.valueOf(inputString[1]));
        ArrayList<T1> threads = new ArrayList<>();
        
        try{
            System.out.println("Iniciando...");
            for (int i =0 ; i<Integer.valueOf(qtde); i++){
                threads.add(new T1(interval, String.valueOf(i)));
            }
            
            threads.forEach((thread) -> {
                thread.start();
            });
            
            System.out.println(qtde+" Threads Inicializadas...");

        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
