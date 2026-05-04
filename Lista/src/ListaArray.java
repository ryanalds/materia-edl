public class ListaArray<E> implements Lista<E> {
    
    private static final int CAPACIDADE = 10;
    private E[] elementos;
    private int tamanho;
    
    @SuppressWarnings("unchecked")
    public ListaArray() {
        elementos = (E[]) new Object[CAPACIDADE];
        tamanho = 0;
    }
    
    @Override
    public int size() {
        return tamanho;
    }
    
    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }
    
    @Override
    public boolean isFirst(Posicao<E> p) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        return nodo.getIndice() == 0;
    }
    
    @Override
    public boolean isLast(Posicao<E> p) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        return nodo.getIndice() == tamanho - 1;
    }
    
    @Override
    public Posicao<E> first() {
        if (isEmpty())
            throw new IllegalArgumentException("Lista vazia");
        return new NodoPosicao<>(elementos[0], 0);
    }
    
    @Override
    public Posicao<E> last() {
        if (isEmpty())
            throw new IllegalArgumentException("Lista vazia");
        return new NodoPosicao<>(elementos[tamanho - 1], tamanho - 1);
    }
    
    @Override
    public Posicao<E> before(Posicao<E> p) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        if (isFirst(p))
            throw new IllegalArgumentException("Não há elemento antes do primeiro");
        int indice = nodo.getIndice();
        return new NodoPosicao<>(elementos[indice - 1], indice - 1);
    }
    
    @Override
    public Posicao<E> after(Posicao<E> p) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        if (isLast(p))
            throw new IllegalArgumentException("Não há elemento após o último");
        int indice = nodo.getIndice();
        return new NodoPosicao<>(elementos[indice + 1], indice + 1);
    }
    
    @Override
    public E replaceElement(Posicao<E> p, E o) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        int indice = nodo.getIndice();
        E antigo = elementos[indice];
        elementos[indice] = o;
        return antigo;
    }
    
    @Override
    public void swapElements(Posicao<E> p, Posicao<E> q) {
        NodoPosicao<E> nodo1 = (NodoPosicao<E>) p;
        NodoPosicao<E> nodo2 = (NodoPosicao<E>) q;
        int ind1 = nodo1.getIndice();
        int ind2 = nodo2.getIndice();
        E temp = elementos[ind1];
        elementos[ind1] = elementos[ind2];
        elementos[ind2] = temp;
    }
    
    @Override
    public void insertBefore(Posicao<E> p, E o) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        int indice = nodo.getIndice();
        verificarCapacidade();
        // Desloca elementos para a direita
        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = o;
        tamanho++;
    }
    
    @Override
    public void insertAfter(Posicao<E> p, E o) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        int indice = nodo.getIndice();
        indice++;
        verificarCapacidade();
        // Desloca elementos para a direita
        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = o;
        tamanho++;
    }
    
    @Override
    public Posicao<E> insertFirst(E o) {
        verificarCapacidade();
        // Desloca todos os elementos para a direita
        for (int i = tamanho; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = o;
        tamanho++;
        return new NodoPosicao<>(o, 0);
    }
    
    @Override
    public Posicao<E> insertLast(E o) {
        verificarCapacidade();
        elementos[tamanho] = o;
        return new NodoPosicao<>(o, tamanho++);
    }
    
    @Override
    public void remove(Posicao<E> p) {
        NodoPosicao<E> nodo = (NodoPosicao<E>) p;
        int indice = nodo.getIndice();
        // Desloca elementos para a esquerda
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }
    
    @SuppressWarnings("unchecked")
    private void verificarCapacidade() {
        if (tamanho == elementos.length) {
            E[] novoArray = (E[]) new Object[elementos.length * 2];
            System.arraycopy(elementos, 0, novoArray, 0, tamanho);
            elementos = novoArray;
        }
    }
    
    /**
     * Classe interna que representa uma posição na lista
     */
    private static class NodoPosicao<E> implements Posicao<E> {
        private E elemento;
        private int indice;
        
        NodoPosicao(E elemento, int indice) {
            this.elemento = elemento;
            this.indice = indice;
        }
        
        @Override
        public E element() {
            return elemento;
        }
        
        int getIndice() {
            return indice;
        }
    }
}

