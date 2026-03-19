public class PilhaArray implements Pilha {
    private int capacidade;
    private Object[] a;
    private int top;
    private int fc; // fator de crescimento

    public PilhaArray (int capacidade, int crescimento){
        this.capacidade = capacidade;
        top = -1;
        fc = crescimento;

        if (crescimento <= 0){
            fc = 0;
        }
        a = new Object[capacidade];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object top() throws pilhaVaziaExcecao {
        return null;
    }

    @Override
    public void push(Object o) {
        if (top >= capacidade-1){
            if (fc == 0){
                capacidade*= 2;
            }
            else {
                capacidade+= fc;
            }

            Object[] b = new Object[capacidade];

            for(int f = 0; f<a.length; f++){
                b[f] = a[f];
            }
            a = b;
        }

        a[++top] = o;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {

        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        Object r = a[--top];
        return r;
    }
}
