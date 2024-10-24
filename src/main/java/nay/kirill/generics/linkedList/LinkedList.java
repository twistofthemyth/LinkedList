package nay.kirill.generics.linkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value, null);
            tail = head;
        } else {
            Node<T> newTail = new Node<>(value, tail);
            tail.next = newTail;
            tail = newTail;
        }
    }

    public void remove(T value) {
        Node<T> node = head;
        while (node.next != null) {
            if(node.value.equals(value)) {
                Node<T> prevNode = node.prev;
                prevNode.next = node.next;
            }
            node = node.next;
        }
    }

    public T get(int index) {
        if(index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            int i = 0;
            Node<T> node = head;
            while (node.next != null) {
                if(index == i) {
                    return node.value;
                } else {
                    i++;
                    node = node.next;
                }
            }
            return node.value;
        }
    }

    public int size() {
        if(head == null) return 0;
        int i = 1;
        Node<T> node = head;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    public void addAll(LinkedList<? extends T> values) {
        for(int i = 0; i < values.size(); i ++) {
            add(values.get(i));
        }
    }


    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private final T value;

        public Node(T value, Node<T> prev) {
            this.prev = prev;
            this.value = value;
        }
    }
}
