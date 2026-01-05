package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Models.RouteEdge;
import com.routeoptimization.backend.dsa.LinkedListManual;
import com.routeoptimization.backend.dsa.LinkedListMap;
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

    public LinkedListManual<Integer> dijkstra(
            List<RouteEdge> edges,
            int start,
            int end) {

        sortingService.quickSort(edges, 0, edges.size() - 1);

        LinkedListMap<Integer, LinkedListManual<RouteEdge>> graph = new LinkedListMap<>();

        for (RouteEdge e : edges) {
            if (!graph.containsKey(e.getFrom())) {
                graph.put(e.getFrom(), new LinkedListManual<>());
            }
            if (!graph.containsKey(e.getTo())) {
                graph.put(e.getTo(), new LinkedListManual<>());
            }

            graph.get(e.getFrom()).add(e);
            graph.get(e.getTo()).add(
                    new RouteEdge(e.getTo(), e.getFrom(), e.getWeight()));
        }

        LinkedListMap<Integer, Integer> dist = new LinkedListMap<>();
        LinkedListMap<Integer, Integer> parent = new LinkedListMap<>();
        LinkedListMap<Integer, Integer> length = new LinkedListMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (RouteEdge e : edges) {
            dist.put(e.getFrom(), Integer.MAX_VALUE);
            dist.put(e.getTo(), Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        length.put(start, 0);
        parent.put(start, -1);
        pq.add(start);

        while (!pq.isEmpty()) {
            int node = pq.poll();

            if (node == end)
                break;

            for (RouteEdge edge : graph.get(node)) {
                int newLen = length.get(node) + 1;

                int newCost = dist.get(node)
                        + edge.getWeight() * 1
                        + newLen * 2;

                int to = edge.getTo();

                if (newCost < dist.get(to)) {
                    dist.put(to, newCost);
                    length.put(to, newLen);
                    parent.put(to, node);
                    pq.add(to);
                }
            }
        }

        LinkedListManual<Integer> path = new LinkedListManual<>();
        if (!parent.containsKey(end))
            return path;

        Stack<Integer> stack = new Stack<>();
        for (int cur = end; cur != -1; cur = parent.get(cur)) {
            stack.push(cur);
        }

        while (!stack.isEmpty())
            path.add(stack.pop());

        return path;
    }

    public LinkedListManual<Integer> shortestPath(
            List<RouteEdge> edges, int start, int end) {

        LinkedListMap<Integer, LinkedListManual<Integer>> graph = new LinkedListMap<>();

        for (RouteEdge e : edges) {

            if (!graph.containsKey(e.getFrom())) {
                graph.put(e.getFrom(), new LinkedListManual<>());
            }
            if (!graph.containsKey(e.getTo())) {
                graph.put(e.getTo(), new LinkedListManual<>());
            }

            graph.get(e.getFrom()).add(e.getTo());
            graph.get(e.getTo()).add(e.getFrom()); 
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        LinkedListMap<Integer, Integer> parent = new LinkedListMap<>();
        LinkedListManual<Integer> visited = new LinkedListManual<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end)
                break;

            LinkedListManual<Integer> neighbors = graph.get(node);
            if (neighbors == null)
                continue;

            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                    queue.add(neighbor);
                }
            }
        }

        LinkedListManual<Integer> path = new LinkedListManual<>();
        if (!parent.containsKey(end))
            return path;

        Stack<Integer> stack = new Stack<>();
        int curr = end;

        while (curr != -1) {
            stack.push(curr);
            curr = parent.get(curr);
        }

        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }

        return path;
    }
}
