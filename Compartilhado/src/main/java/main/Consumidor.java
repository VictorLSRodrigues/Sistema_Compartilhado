package main;

public class Consumidor implements Runnable{

    private Compartilhado x;
    private int tempo;

    public Consumidor(Compartilhado x) {
        this.x = x;
    }
    
    public Compartilhado getX() {
        return x;
    }
    
    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * getTempo()));
            } catch (InterruptedException e) {
            }
            x.consumir();
        }
    }


    
}

