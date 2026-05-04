void main() {
    System.out.println("=== Testes da TAD Sequencia ===\n");
    
    try {
        // Teste 1: Operações básicas
        System.out.println("--- Teste 1: Operações Básicas ---");
        Sequencia<String> seq = new SequenciaLinked<>();
        System.out.println("Sequencia criada. Vazia? " + seq.isEmpty() + " | Tamanho: " + seq.size());
        
        // Teste 2: Inserções no final (insertLast)
        System.out.println("\n--- Teste 2: Inserções no Final ---");
        Posicao<String> p1 = seq.insertLast("Primeiro");
        Posicao<String> p2 = seq.insertLast("Segundo");
        Posicao<String> p3 = seq.insertLast("Terceiro");
        System.out.println("Inseridos 3 elementos. Tamanho: " + seq.size());
        imprimirSequencia(seq);
        
        // Teste 3: Inserções no início (insertFirst)
        System.out.println("\n--- Teste 3: Inserções no Início ---");
        Posicao<String> p0 = seq.insertFirst("Inicio");
        System.out.println("Inserido no início. Tamanho: " + seq.size());
        imprimirSequencia(seq);
        
        // Teste 4: Métodos Ponte - atRank e rankOf
        System.out.println("\n--- Teste 4: Métodos Ponte (atRank e rankOf) ---");
        System.out.println("Elemento no rank 0: " + seq.elemAtRank(0));
        System.out.println("Elemento no rank 2: " + seq.elemAtRank(2));
        System.out.println("Rank de p1 ('Primeiro'): " + seq.rankOf(p1));
        System.out.println("Rank de p0 ('Inicio'): " + seq.rankOf(p0));
        
        // Teste 5: Métodos de acesso por posição (first, last)
        System.out.println("\n--- Teste 5: Métodos first() e last() ---");
        System.out.println("Primeiro elemento: " + seq.first().element());
        System.out.println("Último elemento: " + seq.last().element());
        
        // Teste 6: Métodos before e after
        System.out.println("\n--- Teste 6: Métodos before() e after() ---");
        Posicao<String> antes = seq.before(p2);
        Posicao<String> depois = seq.after(p2);
        System.out.println("Elemento antes de 'Segundo': " + antes.element());
        System.out.println("Elemento depois de 'Segundo': " + depois.element());
        
        // Teste 7: replaceElement
        System.out.println("\n--- Teste 7: replaceElement ---");
        String antigo = seq.replaceElement(p2, "2º Modificado");
        System.out.println("Elemento substituído: '" + antigo + "' por '" + p2.element() + "'");
        imprimirSequencia(seq);
        
        // Teste 8: swapElements
        System.out.println("\n--- Teste 8: swapElements ---");
        System.out.println("Antes da troca:");
        imprimirSequencia(seq);
        seq.swapElements(p0, p3);
        System.out.println("Depois de trocar 1º e último elemento:");
        imprimirSequencia(seq);
        
        // Teste 9: insertBefore e insertAfter
        System.out.println("\n--- Teste 9: insertBefore() e insertAfter() ---");
        seq.insertBefore(p2, "[Antes de 2º]");
        seq.insertAfter(p3, "[Depois de último]");
        System.out.println("Após inserções:");
        imprimirSequencia(seq);
        
        // Teste 10: replaceAtRank
        System.out.println("\n--- Teste 10: replaceAtRank ---");
        String antigo2 = seq.replaceAtRank(1, "Rank 1 modificado");
        System.out.println("Rank 1 substituído: '" + antigo2 + "'");
        imprimirSequencia(seq);
        
        // Teste 11: insertAtRank
        System.out.println("\n--- Teste 11: insertAtRank ---");
        seq.insertAtRank(0, "[Novo no início]");
        seq.insertAtRank(seq.size(), "[Novo no final]");
        seq.insertAtRank(5, "[Novo no meio]");
        System.out.println("Após inserções em ranks específicos:");
        imprimirSequencia(seq);
        
        // Teste 12: removeAtRank
        System.out.println("\n--- Teste 12: removeAtRank ---");
        String removido = seq.removeAtRank(0);
        System.out.println("Removido rank 0: '" + removido + "'");
        imprimirSequencia(seq);
        
        // Teste 13: remove por posição
        System.out.println("\n--- Teste 13: remove(Posicao) ---");
        seq.remove(p0);
        System.out.println("Removida posição p0 (Terceiro):");
        imprimirSequencia(seq);
        
        // Teste 14: Testando exceções
        System.out.println("\n--- Teste 14: Tratamento de Exceções ---");
        testarExcecoes(seq);
        
        System.out.println("\n=== Todos os testes realizados com sucesso! ===");
        
    } catch (SequenciaExcecao e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

static void imprimirSequencia(Sequencia<String> seq) throws SequenciaExcecao {
    System.out.print("Sequencia: [");
    for (int i = 0; i < seq.size(); i++) {
        System.out.print(seq.elemAtRank(i));
        if (i < seq.size() - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("] (tamanho: " + seq.size() + ")");
}

static void testarExcecoes(Sequencia<String> seq) {
    // Teste rank inválido negativo
    try {
        seq.elemAtRank(-1);
        System.out.println("ERRO: Deveria ter lançado exceção para rank negativo");
    } catch (SequenciaExcecao e) {
        System.out.println("✓ Capturada exceção para rank negativo: " + e.getMessage());
    }
    
    // Teste rank inválido acima do tamanho
    try {
        seq.elemAtRank(999);
        System.out.println("ERRO: Deveria ter lançado exceção para rank fora do alcance");
    } catch (SequenciaExcecao e) {
        System.out.println("✓ Capturada exceção para rank fora do alcance: " + e.getMessage());
    }
    
    // Teste sequencia vazia
    Sequencia<String> seqVazia = new SequenciaLinked<>();
    try {
        seqVazia.first();
        System.out.println("ERRO: Deveria ter lançado exceção para sequencia vazia");
    } catch (SequenciaExcecao e) {
        System.out.println("✓ Capturada exceção para sequencia vazia: " + e.getMessage());
    }
}

