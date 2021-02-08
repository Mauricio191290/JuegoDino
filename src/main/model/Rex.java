package main.model;

import java.util.Observable;
import java.util.Random;


public class Rex extends Observable implements Runnable {
    private Nodo nodo;
    private boolean status;
    private final Random random;

    public Rex(int x) {
        nodo = new Nodo();
        nodo.x = x;
        random = new Random(System.currentTimeMillis());
        status = true;
    }

    @Override
    public void run() {
        while (status){
            nodo.desplazamiento = random.nextInt(6) + 4;
            this.setChanged();
            this.notifyObservers(nodo);
            try {
                Thread.sleep(random.nextInt(100) + 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setStatus(boolean status){
        this.status = status;
    }
}




