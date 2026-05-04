public interface Vetor {
    Object elemAtRank(int r) throws VetorInvalidaExcecao;
    Object replaceAtRank(int r, Object o) throws VetorInvalidaExcecao;
    void insertAtRank(int r, Object o) throws VetorInvalidaExcecao;
    Object removeAtRank(int r) throws VetorInvalidaExcecao;
    int size();
    boolean isEmpty();
}
