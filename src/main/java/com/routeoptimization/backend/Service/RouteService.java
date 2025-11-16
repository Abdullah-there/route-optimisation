package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.dsa.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RouteService {

    public Map<String, Object> calculateRoute(String start, String end) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("E", "D", 4);
        graph.addEdge("D", "F", 11);

        List<String> path = Dijkstra.findShortestPath(graph, start, end);

        Map<String, Object> result = new HashMap<>();
        result.put("path", path);
        result.put("distance", path.size() * 2.5);
        return result;
    }
}
