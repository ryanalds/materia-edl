public interface Lista<E> {

    int size();
    boolean isEmpty();
    boolean isFirst(Posicao<E> p);
    boolean isLast(Posicao<E> p);
    Posicao<E> first();
    Posicao<E> last();
    Posicao<E> before(Posicao<E> p);
    Posicao<E> after(Posicao<E> p);
    E replaceElement(Posicao<E> p, E o);
    void swapElements(Posicao<E> p, Posicao<E> q);
    void insertBefore(Posicao<E> p, E o);
    void insertAfter(Posicao<E> p, E o);
    Posicao<E> insertFirst(E o);
    Posicao<E> insertLast(E o);
    void remove(Posicao<E> p);
}
