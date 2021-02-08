package main.model;

import java.util.Observable;
import java.util.Random;

public class ObstaculoVirus extends Observable implements Runnable{
    private Nodo nodo;
    public static boolean status;
    private final Random random;

    public ObstaculoVirus(int x) {
        nodo = new Nodo();
        nodo.x = x;
        random = new Random(System.currentTimeMillis());
        status = true;
    }

    @Override
    public void run() {
        while(status){
            nodo.desplazamientoVirus = random.nextInt(10)-50;
            this.setChanged();
            this.notifyObservers(nodo);
            try {
                Thread.sleep(random.nextInt(90) + 90L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void setStatus(boolean status){
        this.status = status;
    }
}
