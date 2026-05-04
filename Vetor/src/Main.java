public class Main {
    static void main() {
        System.out.println("=== TESTES DA CLASSE VetorLinked ===\n");

        VetorLinked vetor = new VetorLinked();

        // Teste 1: Verificar se vetor está vazio
        System.out.println("Teste 1: isEmpty() - Vetor vazio");
        System.out.println("Resultado: " + vetor.isEmpty());
        System.out.println("Esperado: true\n");

        // Teste 2: size() em vetor vazio
        System.out.println("Teste 2: size() - Vetor vazio");
        System.out.println("Resultado: " + vetor.size());
        System.out.println("Esperado: 0\n");

        // Teste 3: Inserir elementos no final
        System.out.println("Teste 3: insertAtRank() - Inserir elementos no final");
        try {
            vetor.insertAtRank(0, "A");
            vetor.insertAtRank(1, "B");
            vetor.insertAtRank(2, "C");
            System.out.println("Vetor: " + vetor);
            System.out.println("Size: " + vetor.size());
            System.out.println("Esperado: [A, B, C], Size: 3\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 4: elemAtRank()
        System.out.println("Teste 4: elemAtRank() - Acessar elementos");
        try {
            System.out.println("Elemento na posição 0: " + vetor.elemAtRank(0));
            System.out.println("Elemento na posição 1: " + vetor.elemAtRank(1));
            System.out.println("Elemento na posição 2: " + vetor.elemAtRank(2));
            System.out.println("Esperado: A, B, C\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 5: replaceAtRank()
        System.out.println("Teste 5: replaceAtRank() - Substituir elemento");
        try {
            Object antigo = vetor.replaceAtRank(1, "B_NOVO");
            System.out.println("Elemento antigo na posição 1: " + antigo);
            System.out.println("Vetor após substituição: " + vetor);
            System.out.println("Esperado: B_NOVO na posição 1\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 6: Inserir no início
        System.out.println("Teste 6: insertAtRank() - Inserir no início");
        try {
            vetor.insertAtRank(0, "INICIO");
            System.out.println("Vetor: " + vetor);
            System.out.println("Esperado: [INICIO, A, B_NOVO, C]\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 7: Inserir no meio
        System.out.println("Teste 7: insertAtRank() - Inserir no meio");
        try {
            vetor.insertAtRank(2, "MEIO");
            System.out.println("Vetor: " + vetor);
            System.out.println("Esperado: [INICIO, A, MEIO, B_NOVO, C]\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 8: removeAtRank()
        System.out.println("Teste 8: removeAtRank() - Remover elemento");
        try {
            Object removido = vetor.removeAtRank(2);
            System.out.println("Elemento removido: " + removido);
            System.out.println("Vetor: " + vetor);
            System.out.println("Size: " + vetor.size());
            System.out.println("Esperado: MEIO removido, [INICIO, A, B_NOVO, C], Size: 4\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 9: Remover primeiro
        System.out.println("Teste 9: removeAtRank() - Remover primeiro");
        try {
            Object removido = vetor.removeAtRank(0);
            System.out.println("Elemento removido: " + removido);
            System.out.println("Vetor: " + vetor);
            System.out.println("Esperado: INICIO removido, [A, B_NOVO, C]\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 10: Remover último
        System.out.println("Teste 10: removeAtRank() - Remover último");
        try {
            Object removido = vetor.removeAtRank(vetor.size() - 1);
            System.out.println("Elemento removido: " + removido);
            System.out.println("Vetor: " + vetor);
            System.out.println("Esperado: C removido, [A, B_NOVO]\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 11: isEmpty() e size() após operações
        System.out.println("Teste 11: isEmpty() e size() após operações");
        System.out.println("isEmpty: " + vetor.isEmpty());
        System.out.println("size: " + vetor.size());
        System.out.println("Esperado: false, 2\n");

        // Teste 12: Remover todos os elementos
        System.out.println("Teste 12: Remover todos os elementos");
        try {
            while (!vetor.isEmpty()) {
                Object removido = vetor.removeAtRank(0);
                System.out.println("Removido: " + removido + ", Vetor agora: " + vetor);
            }
            System.out.println("isEmpty: " + vetor.isEmpty());
            System.out.println("Esperado: true\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 13: Tentar acessar posição inválida (deve lançar exceção)
        System.out.println("Teste 13: Acessar posição inválida");
        try {
            vetor.elemAtRank(0);
            System.out.println("Erro: Deveria ter lançado exceção");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage() + "\n");
        }

        // Teste 14: Inserir números
        System.out.println("Teste 14: Inserir números");
        try {
            vetor.insertAtRank(0, 10);
            vetor.insertAtRank(1, 20);
            vetor.insertAtRank(2, 30);
            vetor.insertAtRank(1, 15);
            System.out.println("Vetor com números: " + vetor);
            System.out.println("Esperado: [10, 15, 20, 30]\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 15: Operações misturadas
        System.out.println("Teste 15: Operações misturadas");
        try {
            System.out.println("Vetor inicial: " + vetor);
            System.out.println("Replace 20 por 25 na posição 2: " + vetor.replaceAtRank(2, 25));
            System.out.println("Vetor após replace: " + vetor);
            System.out.println("Remove posição 1: " + vetor.removeAtRank(1));
            System.out.println("Vetor final: " + vetor);
            System.out.println("Size: " + vetor.size());
            System.out.println("Esperado: [10, 25, 30], Size: 3\n");
        } catch (VetorInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("=== TODOS OS TESTES FINALIZADOS ===");
    }
}
