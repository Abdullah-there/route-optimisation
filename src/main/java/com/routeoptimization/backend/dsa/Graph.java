package com.routeoptimization.backend.dsa;

import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjList = new HashMap<>();

    public void addEdge(String source, String destination, double weight) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>())
                .add(new Edge(destination, weight));
        adjList.computeIfAbsent(destination, k -> new ArrayList<>())
                .add(new Edge(source, weight)); // undirected
    }

    public Map<String, List<Edge>> getAdjList() {
        return adjList;
    }

    public static class Edge {
        public String destination;
        public double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
