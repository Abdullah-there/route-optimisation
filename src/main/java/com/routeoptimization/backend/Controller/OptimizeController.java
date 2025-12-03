package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Models.RouteEdge;
import com.routeoptimization.backend.Requests.OptimizeRequest;
import com.routeoptimization.backend.Service.DijkstraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OptimizeController {

    private final DijkstraService dijkstraService;

    public OptimizeController(DijkstraService dijkstraService) {
        this.dijkstraService = dijkstraService;
    }

    @PostMapping("/optimize")
    public List<Integer> optimize(@RequestBody OptimizeRequest req) {

        if (req.routes == null || req.routes.isEmpty()) {
            throw new IllegalArgumentException("Route list is empty!");
        }

        if (req.src < 0 || req.dest < 0) {
            throw new IllegalArgumentException("Start and end nodes must be provided!");
        }

        System.out.println("Received Start Node: " + req.src);
        System.out.println("Received End Node : " + req.dest);
        System.out.println("Received Routes   : " + req.routes.size());

        List<Integer> path = dijkstraService.dijkstra(req.routes, req.src, req.dest);

        if (path == null || path.isEmpty()) {
            System.out.println("No optimized path found!");
            return List.of(); 
        }

        System.out.println("Optimized Path: " + path);
        return path;
    }

    @PostMapping("/shortest")
    public List<Integer> shortest(@RequestBody OptimizeRequest req) {

        if (req.routes == null || req.routes.isEmpty()) {
            throw new IllegalArgumentException("Route list is empty!");
        }

        if (req.src < 0 || req.dest < 0) {
            throw new IllegalArgumentException("Start and end nodes must be provided!");
        }

        System.out.println("Received Start Node: " + req.src);
        System.out.println("Received End Node : " + req.dest);
        System.out.println("Received Routes   : " + req.routes.size());

        List<Integer> path = dijkstraService.shortestPath(req.routes, req.src, req.dest);

        if (path == null || path.isEmpty()) {
            System.out.println("No optimized path found!");
            return List.of(); 
        }

        System.out.println("Optimized Path: " + path);
        return path;
    }    
}
