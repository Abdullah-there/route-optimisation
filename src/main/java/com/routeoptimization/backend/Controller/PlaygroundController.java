package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Requests.PlaygroundRequest;
import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.Service.PlaygroundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playground")
@CrossOrigin
public class PlaygroundController {

    private final PlaygroundService service;

    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@RequestBody PlaygroundRequest req) {
        service.saveRoutes(req);
        return "Playground saved: " + req.getPlaygroundName();
    }

    @GetMapping("/{userid}/{playgroundName}")
    public List<RouteEntity> getPlayground(
            @PathVariable String userid,
            @PathVariable String playgroundName
    ) {
        return service.getPlayground(userid, playgroundName);
    }

    @GetMapping("/list")
    public List<RouteEntity> getPlayground(
            @RequestParam String userid
    ) {
        
        System.out.println(userid.getClass().getName());
        return service.getPlaygroundList(userid);
    }
}
