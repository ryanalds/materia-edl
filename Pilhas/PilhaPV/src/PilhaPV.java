public class PilhaPV {
    private Object[] pilha;
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;

    public PilhaPV(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new Object[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = capacidade + 1;
    }


    public int size() {
        return (topoVermelho + 1) + (topoPreto - capacidade);
    }

    public boolean isEmpty() {
        if (topoVermelho == -1 && topoPreto == capacidade + 1) {
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
        if (topoVermelho + 1 == topoPreto) {
            throw new RuntimeException("Pilha Cheia");

        }
        pilha[++topoVermelho] = o;
    }

    public void pushPreto(Object o) {
        if (topoVermelho + 1 == topoPreto) {
            throw new RuntimeException("Pilha Cheia");
        }
        pilha[--topoPreto] = o;
    }

    public Object pop() throws PilhaVaziaExcecao {
        return null;
    }
}
