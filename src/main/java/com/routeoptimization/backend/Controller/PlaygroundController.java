package com.routeoptimization.backend.Controller;

import com.routeoptimization.backend.Requests.PlaygroundRequest;
import com.routeoptimization.backend.Requests.PlaygroundRequestNode;
import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.Service.PlaygroundService;
import com.routeoptimization.backend.Models.PlaygroundDataDTO;
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

    @PostMapping("/saveRoute")
    public String save(@RequestBody PlaygroundRequest req) {
        service.saveRoutes(req);
        return "Playground saved: " + req.getPlaygroundName();
    }

    @PostMapping("/saveNode")
    public String save(@RequestBody PlaygroundRequestNode req) {
        service.saveNodes(req);
        return "Playground saved: " + req.getPlaygroundName();
    }

    @GetMapping("/getplayground")
    public PlaygroundDataDTO getPlayground(
            @RequestParam String userid,
            @RequestParam String playgroundName
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
