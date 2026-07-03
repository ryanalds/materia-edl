
public class Pilhax {
    private int topo;
    public int capacidade;
    private int fc;
    private Object[] pilha;

    public Pilhax(int capacidade, int fc) {
        this.capacidade = capacidade;
        this.fc = fc;
        if (fc <= 0){
            fc = 0;
        }
        this.topo = -1;
        pilha = new Object[capacidade];
    }

    public boolean isEmpty(){
        if (topo == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (topo == capacidade){
            return true;
        }
        return false;
    }

    public int size(){
        return topo + 1;
    }

    public void push(Object o){
        if (topo >= capacidade-1){

            if (fc == 0){
                capacidade = capacidade *2;
            }else{
                capacidade = capacidade + fc;
            }

            Object[] novaPilha = new Object[capacidade];
            for (int i = 0; i < pilha.length; i++){
                novaPilha[i] = pilha[i];
            }
            pilha = novaPilha;
        }
        pilha[++topo] = o;
    }

    public Object pop(){
        if (topo == -1){
            return null;
        }
        Object o = pilha[topo];
        topo--;
        return o;
    }
}
