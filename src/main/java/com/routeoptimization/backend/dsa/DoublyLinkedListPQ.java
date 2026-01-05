package com.routeoptimization.backend.dsa;

public class DoublyLinkedListPQ {
    private PQNode head;
    private PQNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(PQNode newNode) {
        if (head == null) {
            head = tail = newNode;
            return;
        }

        PQNode current = head;
        while (current != null && current.cost <= newNode.cost) {
            current = current.next;
        }

        if (current == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (current == null) { 
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { 
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }

    public PQNode poll() {
        if (head == null) return null;
        PQNode minNode = head;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        minNode.next = null;
        return minNode;
    }
}