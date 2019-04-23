/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topico6a.slide12.Ex1;

/**
 *
 * @author itsgnegrao
 */
public class Monitor {

    private int buff[];
    private int sizeBuff;
    private int firstPos = 0;
    private int lastPos = 0;
    private boolean cheio = false;

    public Monitor(int sizeBuff) {
        this.sizeBuff = sizeBuff;
        this.buff = new int[sizeBuff];

        for (int i = 0; i < sizeBuff; i++) {
            this.buff[i] = -1;
        }
    }

    public synchronized int consume() {
        while (!cheio) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        cheio = false;
        notifyAll();
        int pos = firstPos++;
        System.out.println(pos % sizeBuff);
        int ret = (pos >= sizeBuff ? buff[pos % sizeBuff] : buff[pos]);
        buff[pos % sizeBuff] = -1;
        return ret;
    }

    public synchronized void produce(int value) {
        while (cheio) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        cheio = true;
        int pos = lastPos++;
        if (pos >= sizeBuff) {
            buff[pos % sizeBuff] = value;
        } else {
            buff[pos] = value;
        }

        notifyAll();
    }

}
