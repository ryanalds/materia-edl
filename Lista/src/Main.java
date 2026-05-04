public class Main {
    
    public static void main(String[] args) {
        System.out.println("===== TESTES DA LISTA COM ARRAY =====\n");
        testarLista(new ListaArray<>(), "ListaArray");
        
        System.out.println("\n===== TESTES DA LISTA ENCADEADA =====\n");
        testarLista(new ListaEncadeada<>(), "ListaEncadeada");
    }
    
    private static void testarLista(Lista<String> lista, String nomeLista) {
        System.out.println("Testando: " + nomeLista);
        System.out.println("--------------------------------------\n");
        
        // Teste 1: Inserção no final (insertLast)
        System.out.println("Teste 1: Inserção no final com insertLast");
        Posicao<String> p1 = lista.insertLast("João");
        Posicao<String> p2 = lista.insertLast("Maria");
        Posicao<String> p3 = lista.insertLast("Pedro");
        System.out.println("Inseridos: João, Maria, Pedro");
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Lista vazia? " + lista.isEmpty());
        System.out.println("Primeiro elemento: " + lista.first().element());
        System.out.println("Último elemento: " + lista.last().element() + "\n");
        
        // Teste 2: Validação de posição
        System.out.println("Teste 2: Validação de posição");
        System.out.println("É o primeiro elemento (João)? " + lista.isFirst(p1));
        System.out.println("É o último elemento (Pedro)? " + lista.isLast(p3));
        System.out.println("É o último elemento (Maria)? " + lista.isLast(p2) + "\n");
        
        // Teste 3: Navegação entre posições
        System.out.println("Teste 3: Navegação entre posições");
        Posicao<String> pNext = lista.after(p1);
        System.out.println("Próximo após João: " + pNext.element());
        Posicao<String> pBefore = lista.before(p3);
        System.out.println("Anterior antes de Pedro: " + pBefore.element() + "\n");
        
        // Teste 4: Substituição de elemento
        System.out.println("Teste 4: Substituição de elemento");
        String antigo = lista.replaceElement(p1, "João Silva");
        System.out.println("Elemento antigo: " + antigo);
        System.out.println("Primeiro elemento agora: " + lista.first().element() + "\n");
        
        // Teste 5: Troca de elementos
        System.out.println("Teste 5: Troca de elementos");
        System.out.println("Antes da troca - Primeiro: " + lista.first().element() + ", Último: " + lista.last().element());
        lista.swapElements(lista.first(), lista.last());
        System.out.println("Depois da troca - Primeiro: " + lista.first().element() + ", Último: " + lista.last().element() + "\n");
        
        // Teste 6: Inserção antes e depois
        System.out.println("Teste 6: Inserção antes e depois");
        Posicao<String> p2Atual = lista.after(lista.first());
        lista.insertBefore(p2Atual, "Ana");
        System.out.println("Inserido 'Ana' antes de Maria");
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elementos em ordem: ");
        percorrerLista(lista);
        
        Posicao<String> pAna = lista.before(p2Atual);
        lista.insertAfter(pAna, "Carlos");
        System.out.println("Inserido 'Carlos' após Ana");
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elementos em ordem: ");
        percorrerLista(lista);
        
        // Teste 7: Inserção no início
        System.out.println("\nTeste 7: Inserção no início com insertFirst");
        lista.insertFirst("Zé");
        System.out.println("Inserido 'Zé' no início");
        System.out.println("Primeiro elemento: " + lista.first().element());
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elementos em ordem: ");
        percorrerLista(lista);
        
        // Teste 8: Remoção de elemento
        System.out.println("\nTeste 8: Remoção de elemento");
        Posicao<String> aRemover = lista.first();
        System.out.println("Removendo primeiro elemento: " + aRemover.element());
        lista.remove(aRemover);
        System.out.println("Tamanho após remoção: " + lista.size());
        System.out.println("Novo primeiro elemento: " + lista.first().element());
        System.out.println("Elementos em ordem: ");
        percorrerLista(lista);
        
        System.out.println("\n--------------------------------------");
        System.out.println("Todos os testes concluídos com sucesso!");
    }
    
    private static void percorrerLista(Lista<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("(lista vazia)");
            return;
        }
        
        Posicao<String> atual = lista.first();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(atual.element());
        
        while (!lista.isLast(atual)) {
            atual = lista.after(atual);
            sb.append(", ").append(atual.element());
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
