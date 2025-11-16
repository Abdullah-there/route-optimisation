package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Models.RouteEdge;
import java.util.*;

public class DijkstraService {

    /**
     * Computes the shortest path between src and dest using Dijkstra's algorithm.
     *
     * @param routes List of edges in the graph
     * @param src    Start node index
     * @param dest   End node index
     * @return List of node indices representing the shortest path, empty if no path
     */
    public static List<Integer> shortestPath(List<RouteEdge> routes, int src, int dest) {
        if (routes == null || routes.isEmpty()) {
            throw new IllegalArgumentException("No routes provided");
        }

        // Determine number of nodes
        int maxNode = 0;
        for (RouteEdge r : routes) {
            maxNode = Math.max(maxNode, Math.max(r.getFrom(), r.getTo()));
        }
        int n = maxNode + 1;

        // Build adjacency matrix
        int[][] graph = new int[n][n];
        for (RouteEdge r : routes) {
            graph[r.getFrom()][r.getTo()] = r.getWeight();
            graph[r.getTo()][r.getFrom()] = r.getWeight(); // undirected
        }

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        parent[src] = -1;

        // Dijkstra's algorithm
        for (int i = 0; i < n - 1; i++) {
            int u = findMin(dist, visited, n);
            if (u == -1) break; // No more reachable nodes
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] > 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // If destination unreachable, return empty list
        if (dist[dest] == Integer.MAX_VALUE) return Collections.emptyList();

        return buildPath(parent, dest);
    }

    // Find unvisited node with minimum distance
    private static int findMin(int[] dist, boolean[] visited, int n) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    // Build path from parent array
    private static List<Integer> buildPath(int[] parent, int dest) {
        List<Integer> path = new ArrayList<>();
        while (dest != -1) {
            path.add(dest);
            dest = parent[dest];
        }
        Collections.reverse(path);
        return path;
    }
}
