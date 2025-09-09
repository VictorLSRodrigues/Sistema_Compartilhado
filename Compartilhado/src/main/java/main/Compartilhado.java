package main;

public class Compartilhado {

    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado() {
        this(0, 5);
    }

    public Compartilhado(int buffer, int tamanhoBuffer) {
        setBuffer(buffer);
        setTamanhoBuffer(tamanhoBuffer);
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getTamanhoBuffer() {
        return tamanhoBuffer;
    }

    public void setTamanhoBuffer(int tamanhoBuffer) {
        this.tamanhoBuffer = tamanhoBuffer;
    }

    public synchronized void consumir() {
        while(getBuffer()<= 0){
            System.out.println("buffer vazio");
            try {
            wait();
            }catch(InterruptedException e){}
        }

        setBuffer(getBuffer() - 1);
        System.out.println(getBuffer());
        notify();
    }

    public synchronized void produzir() {
        while(getBuffer()>= 5){
            System.out.println("buffer cheio");
            try {
            wait();
            }catch(InterruptedException e){}
        }
        
        setBuffer(getBuffer() + 1);
        System.out.println(getBuffer());
        notify();
    }

}
