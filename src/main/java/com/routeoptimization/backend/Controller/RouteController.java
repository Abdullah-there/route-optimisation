package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Models.OptimizeRequest;
import com.routeoptimization.backend.Service.DijkstraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RouteController {

   @PostMapping("/optimize")
public List<Integer> optimize(@RequestBody OptimizeRequest data) {
    if (data.routes == null || data.routes.isEmpty()) {
        throw new IllegalArgumentException("Routes list is empty!");
    }

    if (data.start < 0 || data.end < 0) {
        throw new IllegalArgumentException("Start and end nodes must be provided!");
    }

    return DijkstraService.shortestPath(data.routes, data.start, data.end);
}


}
