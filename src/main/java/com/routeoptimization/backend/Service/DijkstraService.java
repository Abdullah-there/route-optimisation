package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Models.RouteEdge;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {

    private final SortingService sortingService;
    private final SearchingService searchingService;

    public DijkstraService(SortingService sortingService, SearchingService searchingService) {
        this.sortingService = sortingService;
        this.searchingService = searchingService;
    }

    /** Main shortest path function */
    public List<Integer> dijkstra(List<RouteEdge> edges, int start, int end) {

        if (edges == null || edges.isEmpty())
            throw new IllegalArgumentException("No routes provided");

        // STEP 1 — Sort edges by weight using sorting service
        sortingService.quickSort(edges, 0, edges.size() - 1);

        // STEP 2 — Build adjacency list graph
        Map<Integer, List<RouteEdge>> graph = new HashMap<>();

        for (RouteEdge e : edges) {
            graph.putIfAbsent(e.getFrom(), new ArrayList<>());
            graph.get(e.getFrom()).add(e);

            // Add reverse for undirected
            graph.putIfAbsent(e.getTo(), new ArrayList<>());
            graph.get(e.getTo())
                .add(new RouteEdge(e.getTo(), e.getFrom(), e.getWeight()));
        }

        // STEP 3 — Prepare distance table
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Setup initial distances
        for (RouteEdge e : edges) {
            dist.put(e.getFrom(), Integer.MAX_VALUE);
            dist.put(e.getTo(), Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        parent.put(start, -1);
        pq.add(new int[]{start, 0});

        // STEP 4 — Dijkstra algorithm
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int cost = top[1];

            if (!graph.containsKey(node)) continue;

            for (RouteEdge edge : graph.get(node)) {
                int newCost = cost + edge.getWeight();
                int neighbor = edge.getTo();

                if (newCost < dist.get(neighbor)) {
                    dist.put(neighbor, newCost);
                    parent.put(neighbor, node);
                    pq.add(new int[]{neighbor, newCost});
                }
            }
        }

        // STEP 5 — If unreachable
        if (!parent.containsKey(end)) return Collections.emptyList();

        // STEP 6 — Build path from end → start
        List<Integer> path = new ArrayList<>();
        int curr = end;

        while (curr != -1) {
            path.add(curr);
            curr = parent.get(curr);
        }

        Collections.reverse(path);
        return path;
    }
}
