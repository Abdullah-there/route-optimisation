package com.routeoptimization.backend.dsa;

public class LinkedListMaps<T> {

    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void add(T data) {
        Node<T> n = new Node<>(data);
        if (head == null) head = n;
        else {
            Node<T> c = head;
            while (c.next != null) c = c.next;
            c.next = n;
        }
        size++;
    }

    public T get(int index) {
        Node<T> c = head;
        for (int i = 0; i < index; i++) c = c.next;
        return c.data;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /* 🔹 SAFE traversal */
    public void forEach(java.util.function.Consumer<T> action) {
        Node<T> c = head;
        while (c != null) {
            action.accept(c.data);
            c = c.next;
        }
    }
}
