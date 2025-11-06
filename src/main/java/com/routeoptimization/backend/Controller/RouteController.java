package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Service.RouteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/route")
    public Map<String, Object> getRoute(
            @RequestParam String start,
            @RequestParam String end) {

        return routeService.calculateRoute(start, end);
    }
}
