public interface Lista<E> {
    
    // Métodos genéricos
    int size();
    boolean isEmpty();
    
    // Métodos de posição (validação)
    boolean isFirst(Posicao<E> p);
    boolean isLast(Posicao<E> p);
    
    // Métodos para acessar
    Posicao<E> first();
    Posicao<E> last();
    Posicao<E> before(Posicao<E> p);
    Posicao<E> after(Posicao<E> p);
    
    // Métodos para atualizar
    E replaceElement(Posicao<E> p, E o);
    void swapElements(Posicao<E> p, Posicao<E> q);
    void insertBefore(Posicao<E> p, E o);
    void insertAfter(Posicao<E> p, E o);
    Posicao<E> insertFirst(E o);
    Posicao<E> insertLast(E o);
    void remove(Posicao<E> p);
}
