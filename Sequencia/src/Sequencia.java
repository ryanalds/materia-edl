public interface Sequencia<E> {

    int size();
    boolean isEmpty();
    E elemAtRank(int r) throws SequenciaExcecao;
    E replaceAtRank(int r, E o) throws SequenciaExcecao;
    void insertAtRank(int r, E o) throws SequenciaExcecao;
    E removeAtRank(int r) throws SequenciaExcecao;
    Posicao<E> first() throws SequenciaExcecao;
    Posicao<E> last() throws SequenciaExcecao;
    Posicao<E> before(Posicao<E> p) throws SequenciaExcecao;
    Posicao<E> after(Posicao<E> p) throws SequenciaExcecao;
    E replaceElement(Posicao<E> p, E o) throws SequenciaExcecao;
    void swapElements(Posicao<E> p, Posicao<E> q) throws SequenciaExcecao;
    void insertBefore(Posicao<E> p, E o) throws SequenciaExcecao;
    void insertAfter(Posicao<E> p, E o) throws SequenciaExcecao;
    Posicao<E> insertFirst(E o);
    Posicao<E> insertLast(E o);
    void remove(Posicao<E> p) throws SequenciaExcecao;
    Posicao<E> atRank(int r) throws SequenciaExcecao;
    int rankOf(Posicao<E> p) throws SequenciaExcecao;
}

