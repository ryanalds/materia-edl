public class VetorInvalidaExcecao extends Exception {
    public VetorInvalidaExcecao() {
        super("Posição inválida especificada para operação no Vetor");
    }

    public VetorInvalidaExcecao(String mensagem) {
        super(mensagem);
    }
}

