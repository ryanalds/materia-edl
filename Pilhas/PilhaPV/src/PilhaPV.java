public class PilhaPV {
    private Object[] pilha;
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;

    public PilhaPV(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new Object[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = capacidade;
    }


    public int size() {
        return (topoVermelho + 1) + (topoPreto - capacidade);
    }

    public boolean isEmpty() {
        if (topoVermelho == -1 && topoPreto == capacidade ) {
            return true;
        }
        return false;
    }

    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }
        return pilha[topoVermelho] + " " + pilha[topoPreto];

    }

    public void pushVermelho(Object o) {
        if(topoVermelho + 1 == topoPreto){
            redimencionar(capacidade * 2);
        }
        pilha[++topoVermelho] = o;
    }

    public void pushPreto(Object o) {
        if(topoVermelho + 1 == topoPreto){
            redimencionar(capacidade * 2);
        }
        pilha[++topoPreto] = o;
    }

    public Object popVermelho() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }
        Object elemento = pilha[topoVermelho];
        pilha[topoVermelho--] = null;
        topoVermelho--;
        verificarReducao();
        return elemento;
    }
    public Object popPreto() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }
        Object elemento = pilha[topoPreto];
        pilha[topoPreto] = null;
        topoPreto++;
        verificarReducao();
        return elemento;
    }

    private void redimencionar(int novaCapacidade) {
        if (novaCapacidade < size() + 1) {
            novaCapacidade = size() + 1;
        }

        Object[] novaPilha = new Object[novaCapacidade];
        for (int i = 0; i < novaPilha.length; i++) {
            novaPilha[i] = pilha[i];
        }

        int novoPreto =  novaCapacidade;
        for(int i = capacidade - 1 ; i >= topoPreto; i--) {
            novaPilha[--novoPreto] = pilha[i];
        }
        this.pilha = novaPilha;
        this.topoPreto = novoPreto;
        this.capacidade = novaCapacidade;
    }

    private void verificarReducao() {
        int novaCapacidade = capacidade/2;
        if(size() <= capacidade/3 && novaCapacidade >= size() + 1 ){
            redimencionar(novaCapacidade);
        }
    }
}
