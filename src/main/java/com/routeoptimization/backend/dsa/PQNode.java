package com.routeoptimization.backend.dsa;

public class PQNode {
    public int node;
    public int cost;
    PQNode prev;
    PQNode next;

    public PQNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

