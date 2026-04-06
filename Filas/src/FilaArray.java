public class FilaArray implements Fila {
    int i = 0, f =  0, n, incremento;
    Object[] fila;

    public FilaArray(int n, int  incremento ){
        this.n = n; //tamanho
        this.incremento = incremento;
        fila = new Object[n];
    }

    @Override
    public void enqueue(Object o) {
        if(size() == n-1){
            int novoTamanho;
            if(incremento == 0){novoTamanho = n*2;}
            else{novoTamanho =  n + incremento;}

            Object[] novoFila = new Object[novoTamanho];
            int ii = i;

            for (int ff=0 ; ff < size() ; ff++){
                novoFila[ff] = fila[ii];
                ii = (ii + 1)%n;
            }

            f = size();
            i=0;
            n = novoTamanho;
            fila = novoFila;
        }

        fila[f] = o;
        f = (f + 1)%n;

    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new FilaVaziaExcessao("Fila Vazia");
        }
        Object o = fila[i];
        i = (i + 1)%n;
        return o;
        }

    @Override
    public boolean isEmpty() {
        return f == i;
    }

    @Override
    public int size() {
        return (n - i + f)%n;
    }



}
