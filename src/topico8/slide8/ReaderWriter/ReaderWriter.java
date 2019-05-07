package topico8.slide8.ReaderWriter;

import java.util.concurrent.Semaphore;

/**
 *
 * @author itsgnegrao
 */
public class ReaderWriter {

    int numReaders = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore wlock = new Semaphore(1);


    public void startRead() throws InterruptedException {
        mutex.acquire(); //se tiver alguem lendo espera esse cara terminar de ler
        numReaders++;
        if(numReaders == 1){
            wlock.acquire(); // se tiver alguem escrevendo o leitor é bloqueado
        }
        mutex.release();

    }

    public void endRead() throws InterruptedException {
        mutex.acquire(); //se tiver alguem lendo espera esse cara terminar de ler
        numReaders--;
        if(numReaders == 0){
            wlock.release();// se tiver alguem escrevendo o leitor é bloqueado
        }
        mutex.release();
    }

    public void startWrite() throws InterruptedException {
        wlock.acquire();

    }

    public void endWrite() {
        wlock.release();
    }
    
//    Exemplo de chamadas.
    public Double get() throws InterruptedException {
        startRead();
        endRead();
        return new Double("0");
    }
//    Exemplo de chamadas.
    public void put() throws InterruptedException {
        startWrite();
        endWrite();
    }
    
}
