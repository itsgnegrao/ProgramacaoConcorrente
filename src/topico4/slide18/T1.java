package topico4.slide18;

/**
 *
 * @author itsgnegrao
 */
public class T1 extends Thread{

    private static Interval interval;
    
    public T1(Interval interval, String name){
        this.interval = interval;
        this.setName(name);
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
                if(number < 0) this.stop();
                if(isPrimo(number)) System.out.println("Thread "+this.getName()+" ,"+String.valueOf(number)+" - É Primo!");
            }
            catch(Exception e){
                e.printStackTrace();
            } 
        }
    }
}