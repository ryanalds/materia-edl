public class FilaReverse implements Fila {
    int i = 0, f = 0, n, incremento;
    Object[] fila;
    boolean reversed = false;

    public FilaReverse(int n, int incremento) {
        this.n = n; // tamanho
        this.incremento = incremento;
        fila = new Object[n];
    }

    public void reverse() {
        reversed = !reversed;
    }

    @Override
    public void enqueue(Object o) {
        // Verifica se precisa reduzir (quando tamanho < 1/3 da capacidade)
        if (size() > 0 && size() < n / 3 && n > 10) {
            reduzirArray();
        }

        // Verifica se precisa duplicar
        if (size() == n - 1) {
            duplicarArray();
        }

        if (!reversed) {
            // Comportamento normal: adiciona no final
            fila[f] = o;
            f = (f + 1) % n;
        } else {
            // Comportamento revertido: adiciona no início
            i = (i - 1 + n) % n;
            fila[i] = o;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaExcessao("Fila Vazia");
        }

        Object o;

        if (!reversed) {

            o = fila[i];
            i = (i + 1) % n;
        } else {

            f = (f - 1 + n) % n;
            o = fila[f];
        }

        return o;
    }

    @Override
    public boolean isEmpty() {
        return f == i;
    }

    @Override
    public int size() {
        return (n - i + f) % n;
    }


    private void duplicarArray() {
        int novoTamanho;
        if (incremento == 0) {
            novoTamanho = n * 2;
        } else {
            novoTamanho = n + incremento;
        }

        Object[] novaFila = new Object[novoTamanho];
        int ii = i;


        for (int ff = 0; ff < size(); ff++) {
            novaFila[ff] = fila[ii];
            ii = (ii + 1) % n;
        }


        f = size();
        i = 0;
        reversed = false;
        n = novoTamanho;
        fila = novaFila;
    }


    private void reduzirArray() {
        int novoTamanho = n / 2;
        if (novoTamanho < 10) {
            novoTamanho = 10;
        }

        Object[] novaFila = new Object[novoTamanho];
        int ii = i;


        for (int ff = 0; ff < size(); ff++) {
            novaFila[ff] = fila[ii];
            ii = (ii + 1) % n;
        }


        f = size();
        i = 0;
        reversed = false;
        n = novoTamanho;
        fila = novaFila;
    }
}

