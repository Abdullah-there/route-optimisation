package com.routeoptimization.backend.dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListManual<T> implements Iterable<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;

        return curr.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (T val : this) {
            arr[i++] = val;
        }
        return arr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> curr = head;

            public boolean hasNext() {
                return curr != null;
            }

            public T next() {
                if (curr == null)
                    throw new NoSuchElementException();
                T data = curr.data;
                curr = curr.next;
                return data;
            }
        };
    }
}