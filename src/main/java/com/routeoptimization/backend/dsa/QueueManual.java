package com.routeoptimization.backend.dsa;

public class QueueManual<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head; // front
    private Node<T> tail; // rear
    private int size = 0;

    public void add(T data) { // enqueue
        Node<T> node = new Node<>(data);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = node;
        size++;
    }

    public T poll() { // dequeue
        if (head == null) throw new RuntimeException("Queue is empty");
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public T peek() {
        if (head == null) throw new RuntimeException("Queue is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
