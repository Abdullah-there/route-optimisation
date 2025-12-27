package com.routeoptimization.backend.dsa;

public class LinkedListMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> head;

    public void put(K key, V value) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        head = newNode;
    }

    public V get(K key) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) return true;
            node = node.next;
        }
        return false;
    }
}