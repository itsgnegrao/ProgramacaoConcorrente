package topico3.slide5.Ex3;

import java.util.*;

/**
 * Este exercício trata-se de um produtor/consumidor, onde uma thread é criada com a funcionalidade de incrementar um contador.
 * Outras Threads (quantidade informada pelo usuário) consomen este contador e tentam acessar o mesmo valor concorrentemente (forçando um erro)
 * @author itsgnegrao
 */

public class Ex3 {
    public static void main(String[] args){
        System.out.print("Digite um número de Threads: ");
        String inputString = new Scanner( System.in).nextLine();
        List<Thread> threads;
        ThreadPRODUCE productor = new ThreadPRODUCE();
        
        //primeiro teste
        threads = new ArrayList<Thread>();
        for (int i = 0; i<Integer.parseInt(inputString); i++){
            threads.add(new ThreadCONSUME(productor));
        }
        for(Thread t: threads){t.start();}

        productor.start();        
    }
}


