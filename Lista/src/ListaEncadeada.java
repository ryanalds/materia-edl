public class ListaEncadeada<E> implements Lista<E> {
    
    private NoDuplo<E> inicio;
    private NoDuplo<E> fim;
    private int tamanho;
    
    public ListaEncadeada() {
        inicio = null;
        fim = null;
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
        NoDuplo<E> no = (NoDuplo<E>) p;
        return no == inicio;
    }
    
    @Override
    public boolean isLast(Posicao<E> p) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        return no == fim;
    }
    
    @Override
    public Posicao<E> first() {
        if (isEmpty())
            throw new IllegalArgumentException("Lista vazia");
        return inicio;
    }
    
    @Override
    public Posicao<E> last() {
        if (isEmpty())
            throw new IllegalArgumentException("Lista vazia");
        return fim;
    }
    
    @Override
    public Posicao<E> before(Posicao<E> p) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        if (isFirst(p))
            throw new IllegalArgumentException("Não há elemento antes do primeiro");
        return no.getAnterior();
    }
    
    @Override
    public Posicao<E> after(Posicao<E> p) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        if (isLast(p))
            throw new IllegalArgumentException("Não há elemento após o último");
        return no.getProximo();
    }
    
    @Override
    public E replaceElement(Posicao<E> p, E o) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        E antigo = no.getElemento();
        no.setElemento(o);
        return antigo;
    }
    
    @Override
    public void swapElements(Posicao<E> p, Posicao<E> q) {
        NoDuplo<E> no1 = (NoDuplo<E>) p;
        NoDuplo<E> no2 = (NoDuplo<E>) q;
        E temp = no1.getElemento();
        no1.setElemento(no2.getElemento());
        no2.setElemento(temp);
    }
    
    @Override
    public void insertBefore(Posicao<E> p, E o) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        NoDuplo<E> novoNo = new NoDuplo<>(o, no.getAnterior(), no);
        
        if (no.getAnterior() != null) {
            no.getAnterior().setProximo(novoNo);
        } else {
            inicio = novoNo;
        }
        no.setAnterior(novoNo);
        tamanho++;
    }
    
    @Override
    public void insertAfter(Posicao<E> p, E o) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        NoDuplo<E> novoNo = new NoDuplo<>(o, no, no.getProximo());
        
        if (no.getProximo() != null) {
            no.getProximo().setAnterior(novoNo);
        } else {
            fim = novoNo;
        }
        no.setProximo(novoNo);
        tamanho++;
    }
    
    @Override
    public Posicao<E> insertFirst(E o) {
        NoDuplo<E> novoNo = new NoDuplo<>(o, null, inicio);
        
        if (isEmpty()) {
            inicio = fim = novoNo;
        } else {
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        tamanho++;
        return novoNo;
    }
    
    @Override
    public Posicao<E> insertLast(E o) {
        NoDuplo<E> novoNo = new NoDuplo<>(o, fim, null);
        
        if (isEmpty()) {
            inicio = fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
        return novoNo;
    }
    
    @Override
    public void remove(Posicao<E> p) {
        NoDuplo<E> no = (NoDuplo<E>) p;
        
        if (no.getAnterior() != null) {
            no.getAnterior().setProximo(no.getProximo());
        } else {
            inicio = no.getProximo();
        }
        
        if (no.getProximo() != null) {
            no.getProximo().setAnterior(no.getAnterior());
        } else {
            fim = no.getAnterior();
        }
        
        tamanho--;
    }

    private static class NoDuplo<E> implements Posicao<E> {
        private E elemento;
        private NoDuplo<E> anterior;
        private NoDuplo<E> proximo;
        
        NoDuplo(E elemento, NoDuplo<E> anterior, NoDuplo<E> proximo) {
            this.elemento = elemento;
            this.anterior = anterior;
            this.proximo = proximo;
        }
        
        @Override
        public E element() {
            return elemento;
        }
        
        E getElemento() {
            return elemento;
        }
        
        void setElemento(E elemento) {
            this.elemento = elemento;
        }
        
        NoDuplo<E> getAnterior() {
            return anterior;
        }
        
        void setAnterior(NoDuplo<E> anterior) {
            this.anterior = anterior;
        }
        
        NoDuplo<E> getProximo() {
            return proximo;
        }
        
        void setProximo(NoDuplo<E> proximo) {
            this.proximo = proximo;
        }
    }
}

