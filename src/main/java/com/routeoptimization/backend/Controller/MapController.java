package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Requests.OptimizeRequestmap;
import com.routeoptimization.backend.Service.RouteOptimizationService;
import com.routeoptimization.backend.dsa.LinkedListMaps;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
@CrossOrigin
public class MapController {

    private final RouteOptimizationService service;

    public MapController(RouteOptimizationService service) {
        this.service = service;
    }

    @PostMapping("/optimize")
    public List<double[]> optimize(@RequestBody OptimizeRequestmap request) {

        if (request.getRoutes() == null || request.getRoutes().isEmpty()) {
            throw new IllegalArgumentException("No routes received from frontend");
        }

        LinkedListMaps<OptimizeRequestmap.Route> linkedRoutes = new LinkedListMaps<>();
        for (OptimizeRequestmap.Route r : request.getRoutes()) {
            LinkedListMaps<double[]> coordsLinked = new LinkedListMaps<>();
            if (r.getCoords() != null) {
                for (double[] coord : r.getCoords()) {
                    coordsLinked.add(coord);
                }
            }
            r.setCoordsLinked(coordsLinked); 
            linkedRoutes.add(r);
        }

        LinkedListMaps<double[]> bestCoords = service.findBestRoute(linkedRoutes);

        List<double[]> result = new java.util.ArrayList<>();
        for (int i = 0; i < bestCoords.size(); i++) {
            result.add(bestCoords.get(i));
        }

        return result;
    }
}
