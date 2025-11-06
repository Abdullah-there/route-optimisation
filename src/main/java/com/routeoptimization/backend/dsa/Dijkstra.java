package com.routeoptimization.backend.dsa;

import java.util.*;

public class Dijkstra {

    public static class Node implements Comparable<Node> {
        String name;
        double distance;

        public Node(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public static List<String> findShortestPath(Graph graph, String start, String end) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String node : graph.getAdjList().keySet())
            distances.put(node, Double.MAX_VALUE);

        distances.put(start, 0.0);
        pq.add(new Node(start, 0.0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.name.equals(end)) break;

            for (Graph.Edge edge : graph.getAdjList().getOrDefault(current.name, List.of())) {
                double newDist = distances.get(current.name) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current.name);
                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        // Build path
        List<String> path = new ArrayList<>();
        String curr = end;
        while (curr != null) {
            path.add(0, curr);
            curr = previous.get(curr);
        }
        return path;
    }
}
