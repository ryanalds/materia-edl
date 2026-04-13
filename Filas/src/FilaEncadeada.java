public class FilaEncadeada implements Fila {

    private class No {
        Object dado;
        No proxNo;
        
        No(Object dado) {
            this.dado = dado;
            this.proxNo = null;
        }
    }
    
    private No inicio;
    private No fim;
    private int tamanho;
    
    public FilaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    @Override
    public void enqueue(Object o) {
        No novoNo = new No(o);
        
        if (isEmpty()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proxNo = novoNo;
            this.fim = novoNo;
        }
        
        this.tamanho++;
    }
    
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaExcessao("Fila Vazia");
        }

        Object dado = this.inicio.dado;
        this.inicio = this.inicio.proxNo;
        this.tamanho--;

        if (isEmpty()) {
            this.fim = null;
        }
        
        return dado;
    }
    
    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }
    
    @Override
    public int size() {
        return this.tamanho;
    }
}

