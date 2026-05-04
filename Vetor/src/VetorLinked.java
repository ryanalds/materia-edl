public class VetorLinked implements Vetor {

    private static class Node {
        Object data;
        Node prev;
        Node next;

        Node(Object data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public VetorLinked() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node getNode(int r) throws VetorInvalidaExcecao {
        if (r < 0 || r >= size) {
            throw new VetorInvalidaExcecao("Posição " + r + " inválida. Tamanho do Vetor: " + size);
        }

        Node current;
        if (r < size / 2) {
            current = head;
            for (int i = 0; i < r; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > r; i--) {
                current = current.prev;
            }
        }

        return current;
    }


    @Override
    public Object elemAtRank(int r) throws VetorInvalidaExcecao {
        return getNode(r).data;
    }

    @Override
    public Object replaceAtRank(int r, Object o) throws VetorInvalidaExcecao {
        Node node = getNode(r);
        Object oldData = node.data;
        node.data = o;
        return oldData;
    }


    @Override
    public void insertAtRank(int r, Object o) throws VetorInvalidaExcecao {
        if (r < 0 || r > size) {
            throw new VetorInvalidaExcecao("Posição " + r + " inválida para inserção. Tamanho do Vetor: " + size);
        }

        Node newNode = new Node(o);

        if (size == 0) {
            head = tail = newNode;
        } else if (r == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (r == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node nextNode = getNode(r);
            newNode.next = nextNode;
            newNode.prev = nextNode.prev;
            nextNode.prev.next = newNode;
            nextNode.prev = newNode;
        }

        size++;
    }

    @Override
    public Object removeAtRank(int r) throws VetorInvalidaExcecao {
        Node node = getNode(r);
        Object data = node.data;

        if (size == 1) {
            head = tail = null;
        } else if (r == 0) {
            head = head.next;
            head.prev = null;
        } else if (r == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        size--;
        return data;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

