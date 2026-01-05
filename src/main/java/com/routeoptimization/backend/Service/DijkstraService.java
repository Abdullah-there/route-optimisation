package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Models.RouteEdge;
import com.routeoptimization.backend.dsa.DoublyLinkedListPQ;
import com.routeoptimization.backend.dsa.LinkedListManual;
import com.routeoptimization.backend.dsa.PQNode;
import com.routeoptimization.backend.dsa.StackManual;
import com.routeoptimization.backend.dsa.QueueManual;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DijkstraService {

    private final SortingService sortingService;
    private final SearchingService searchingService;

    public DijkstraService(SortingService sortingService, SearchingService searchingService) {
        this.sortingService = sortingService;
        this.searchingService = searchingService;
    }

    public LinkedListManual<Integer> dijkstra(List<RouteEdge> edges, int start, int end) {
        int maxNode = 0;
        for (int i = 0; i < edges.size(); i++) {
            RouteEdge e = edges.get(i);
            maxNode = Math.max(maxNode, Math.max(e.getFrom(), e.getTo()));
        }

        int[] dist = new int[maxNode + 1];
        int[] parent = new int[maxNode + 1];
        int[] pathLength = new int[maxNode + 1];

        for (int i = 0; i <= maxNode; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        DoublyLinkedListPQ pq = new DoublyLinkedListPQ();
        dist[start] = 0;
        pathLength[start] = 0;
        pq.add(new PQNode(start, 0));

        while (!pq.isEmpty()) {
            PQNode cur = pq.poll();
            int u = cur.node;

            if (cur.cost > dist[u])
                continue;
            if (u == end)
                break;

            for (int i = 0; i < edges.size(); i++) {
                RouteEdge edge = edges.get(i);
                int v = -1;

                if (edge.getFrom() == u)
                    v = edge.getTo();
                else if (edge.getTo() == u)
                    v = edge.getFrom();

                if (v != -1) {
                    int newLen = pathLength[u] + 1;
                    int newCost = dist[u] + edge.getWeight() + (newLen * 2);

                    if (newCost < dist[v]) {
                        dist[v] = newCost;
                        pathLength[v] = newLen;
                        parent[v] = u;
                        pq.add(new PQNode(v, newCost));
                    }
                }
            }
        }

        LinkedListManual<Integer> path = new LinkedListManual<>();
        if (parent[end] == -1 && start != end)
            return path;

        StackManual<Integer> stack = new StackManual<>();
        for (int cur = end; cur != -1; cur = parent[cur]) {
            stack.push(cur);
        }

        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }

        return path;
    }

    public LinkedListManual<Integer> shortestPath(List<RouteEdge> edges, int start, int end) {
        int maxNode = 0;
        for (int i = 0; i < edges.size(); i++) {
            RouteEdge e = edges.get(i);
            if (e.getFrom() > maxNode)
                maxNode = e.getFrom();
            if (e.getTo() > maxNode)
                maxNode = e.getTo();
        }

        int[] parent = new int[maxNode + 1];
        boolean[] visited = new boolean[maxNode + 1];

        for (int i = 0; i <= maxNode; i++) {
            parent[i] = -1;
        }

        QueueManual<Integer> queue = new QueueManual<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end)
                break;

            for (int i = 0; i < edges.size(); i++) {
                RouteEdge edge = edges.get(i);
                int neighbor = -1;

                if (edge.getFrom() == node)
                    neighbor = edge.getTo();
                else if (edge.getTo() == node)
                    neighbor = edge.getFrom();

                if (neighbor != -1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }

        LinkedListManual<Integer> path = new LinkedListManual<>();

        if (!visited[end])
            return path;

        StackManual<Integer> stack = new StackManual<>();
        int curr = end;
        while (curr != -1) {
            stack.push(curr);
            curr = parent[curr];
        }

        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }

        return path;
    }
}
