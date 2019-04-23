package topico6a.slide12.Ex4;

/**
 * Implemente uma solução para o problema do Barbeiro
 * Dorminhoco usando monitores.
 * 
 * Monitor = barbearia
 * cadeiras = fila (número fixo)
 * barbeiro = consumidor
 * fregues = produtor
 * 
 * @author itsgnegrao
 */
public class Ex4 {
    
    public static void main(String[] args) {
        
        Monitor monitor = new Monitor();
        Producer producer = new Producer(monitor);
        Consumer consumer = new Consumer(monitor);
//        Consumer consumer2 = new Consumer(monitor);

        producer.start();
        consumer.start();
//        consumer2.start();
    }
    
}
