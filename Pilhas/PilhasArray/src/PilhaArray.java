public class PilhaArray implements Pilha{

    private int capacidade;
    private int topo;
    private Object[] pilha;
    private int fc; // fator de crescimento

    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        this.fc = crescimento;
        if (fc <= 0){
            this.fc = 0;
        }
        this.topo = -1;
        this.pilha = new Object[capacidade];
    }


    @Override
    public int size() {
        return topo + 1;
    }

    @Override
    public boolean isEmpty() {
        if (topo == -1){
            return true;
        }
        return false;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }
        return pilha[topo];
    }

    @Override
    public void push(Object o) {
        if (topo >= capacidade-1){
            if (fc == 0) {
                capacidade*= 2;
            }else{
                capacidade+= fc;
            }
            Object[] novaPilha = new Object[capacidade];
            for (int i = 0; i < pilha.length; i++) {
                novaPilha[i] = pilha[i];
            }
            pilha = novaPilha;
        }
        pilha[++topo] = o;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if(isEmpty()){
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }
        Object o = pilha[topo--];
        return o;
    }
}
