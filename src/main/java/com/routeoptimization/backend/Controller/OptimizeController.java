package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Models.RouteEdge;
import com.routeoptimization.backend.Requests.OptimizeRequest;
import com.routeoptimization.backend.Service.DijkstraService;
import org.springframework.web.bind.annotation.*;
import com.routeoptimization.backend.dsa.LinkedListManual;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OptimizeController {

    private final DijkstraService dijkstraService;

    public OptimizeController(DijkstraService dijkstraService) {
        this.dijkstraService = dijkstraService;
    }

    @PostMapping("/optimize")
    public int[] optimize(@RequestBody OptimizeRequest req) {

        if (req.routes == null || req.routes.isEmpty()) {
            throw new IllegalArgumentException("Route list is empty!");
        }

        if (req.src < 0 || req.dest < 0) {
            throw new IllegalArgumentException("Start and end nodes must be provided!");
        }

        System.out.println("Received Start Node: " + req.src);
        System.out.println("Received End Node : " + req.dest);
        System.out.println("Received Routes   : " + req.routes.size());
        System.out.println("Optimized");

        LinkedListManual<Integer> path = dijkstraService.dijkstra(req.routes, req.src, req.dest);

        if (path == null || path.isEmpty()) {
            return new int[0];
        }

        Object[] objArr = path.toArray();
        int[] result = new int[objArr.length];

        for (int i = 0; i < objArr.length; i++) {
            result[i] = (Integer) objArr[i];
        }

        return result;
    }

    @PostMapping("/shortest")
    public int[] shortest(@RequestBody OptimizeRequest req) {

        if (req.routes == null || req.routes.isEmpty()) {
            throw new IllegalArgumentException("Route list is empty!");
        }

        if (req.src < 0 || req.dest < 0) {
            throw new IllegalArgumentException("Start and end nodes must be provided!");
        }

        System.out.println("Received Start Node: " + req.src);
        System.out.println("Received End Node : " + req.dest);
        System.out.println("Received Routes   : " + req.routes.size());
        System.out.println("Shortest");

        LinkedListManual<Integer> path = dijkstraService.shortestPath(req.routes, req.src, req.dest);

        if (path == null || path.isEmpty()) {
            return new int[0];
        }

        Object[] objArr = path.toArray();
        int[] result = new int[objArr.length];

        for (int i = 0; i < objArr.length; i++) {
            result[i] = (Integer) objArr[i];
        }

        return result;
    }
}
