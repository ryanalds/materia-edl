public class SequenciaLinked<E> implements Sequencia<E> {
    
    private NoDuplo<E> inicio;
    private NoDuplo<E> fim;
    private int tamanho;
    
    public SequenciaLinked() {
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
    public E elemAtRank(int r) throws SequenciaExcecao {
        if (r < 0 || r >= tamanho) {
            throw new SequenciaExcecao("Rank " + r + " inválido");
        }
        return getNoDuploAtRank(r).getElemento();
    }
    
    @Override
    public E replaceAtRank(int r, E o) throws SequenciaExcecao {
        if (r < 0 || r >= tamanho) {
            throw new SequenciaExcecao("Rank " + r + " inválido");
        }
        NoDuplo<E> no = getNoDuploAtRank(r);
        E antigo = no.getElemento();
        no.setElemento(o);
        return antigo;
    }
    
    @Override
    public void insertAtRank(int r, E o) throws SequenciaExcecao {
        if (r < 0 || r > tamanho) {
            throw new SequenciaExcecao("Rank " + r + " inválido para inserção");
        }
        
        if (r == 0) {
            insertFirst(o);
        } else if (r == tamanho) {
            insertLast(o);
        } else {
            NoDuplo<E> noAtual = getNoDuploAtRank(r);
            NoDuplo<E> novoNo = new NoDuplo<>(o, noAtual.getAnterior(), noAtual);
            noAtual.getAnterior().setProximo(novoNo);
            noAtual.setAnterior(novoNo);
            tamanho++;
        }
    }
    
    @Override
    public E removeAtRank(int r) throws SequenciaExcecao {
        if (r < 0 || r >= tamanho) {
            throw new SequenciaExcecao("Rank " + r + " inválido");
        }
        
        NoDuplo<E> no = getNoDuploAtRank(r);
        E elemento = no.getElemento();
        
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
        return elemento;
    }

    @Override
    public Posicao<E> first() throws SequenciaExcecao {
        if (isEmpty()) {
            throw new SequenciaExcecao("Sequencia vazia");
        }
        return inicio;
    }
    
    @Override
    public Posicao<E> last() throws SequenciaExcecao {
        if (isEmpty()) {
            throw new SequenciaExcecao("Sequencia vazia");
        }
        return fim;
    }
    
    @Override
    public Posicao<E> before(Posicao<E> p) throws SequenciaExcecao {
        NoDuplo<E> no = (NoDuplo<E>) p;
        if (no == inicio) {
            throw new SequenciaExcecao("Não há elemento antes do primeiro");
        }
        return no.getAnterior();
    }
    
    @Override
    public Posicao<E> after(Posicao<E> p) throws SequenciaExcecao {
        NoDuplo<E> no = (NoDuplo<E>) p;
        if (no == fim) {
            throw new SequenciaExcecao("Não há elemento após o último");
        }
        return no.getProximo();
    }
    
    @Override
    public E replaceElement(Posicao<E> p, E o) throws SequenciaExcecao {
        NoDuplo<E> no = (NoDuplo<E>) p;
        E antigo = no.getElemento();
        no.setElemento(o);
        return antigo;
    }
    
    @Override
    public void swapElements(Posicao<E> p, Posicao<E> q) throws SequenciaExcecao {
        NoDuplo<E> no1 = (NoDuplo<E>) p;
        NoDuplo<E> no2 = (NoDuplo<E>) q;
        E temp = no1.getElemento();
        no1.setElemento(no2.getElemento());
        no2.setElemento(temp);
    }
    
    @Override
    public void insertBefore(Posicao<E> p, E o) throws SequenciaExcecao {
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
    public void insertAfter(Posicao<E> p, E o) throws SequenciaExcecao {
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
    public void remove(Posicao<E> p) throws SequenciaExcecao {
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

    @Override
    public Posicao<E> atRank(int r) throws SequenciaExcecao {
        if (r < 0 || r >= tamanho) {
            throw new SequenciaExcecao("Rank " + r + " inválido");
        }
        return getNoDuploAtRank(r);
    }
    
    @Override
    public int rankOf(Posicao<E> p) throws SequenciaExcecao {
        NoDuplo<E> no = (NoDuplo<E>) p;
        int rank = 0;
        NoDuplo<E> atual = inicio;
        
        while (atual != null) {
            if (atual == no) {
                return rank;
            }
            atual = atual.getProximo();
            rank++;
        }
        
        throw new SequenciaExcecao("Posição não pertence a esta sequencia");
    }

    private NoDuplo<E> getNoDuploAtRank(int r) {
        NoDuplo<E> atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        return atual;
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

