package topico6.slide16;

/**
 *
 * @author itsgnegrao
 */
public class Consumer extends Thread{

    private static Producer producer;
    
    public Consumer(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run(){
        synchronized(producer){
            while(true){
                try {
                    producer.wait();
                    int buff[] = producer.getvalue();
                    if (buff != null) {
                        System.out.println("Consumer " + this.getName() + " recebi o buff com "+buff.length);
                        for(int i=0; i<buff.length; i++){
                            System.out.println(buff[i]+" ");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}