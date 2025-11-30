package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Requests.PlaygroundRequest;
import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.Repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {

    private final RouteRepository repo;

    public PlaygroundService(RouteRepository repo) {
        this.repo = repo;
    }

    public void saveRoutes(PlaygroundRequest request) {

        System.out.println("DEBUG -> userId = " + request.getUserId());
        System.out.println("DEBUG -> playgroundName = " + request.getPlaygroundName());

        if (request == null || request.getUserId() == null || request.getPlaygroundName() == null) {
            throw new IllegalArgumentException("Request, userId and playgroundName are required");
        }

        repo.deleteByUseridAndPlaygroundName(
                request.getUserId(),
                request.getPlaygroundName()
        );

        if (request.getRoutes() == null) return;

        for (PlaygroundRequest.RouteDTO r : request.getRoutes()) {
            RouteEntity entity = new RouteEntity(
                request.getUserId(),
                request.getPlaygroundName(),
                r.getFrom(),
                r.getTo(),
                r.getWeight()
            );
            repo.save(entity);
        }
    }

    public List<RouteEntity> getPlayground(String userid, String playgroundName) {
        return repo.findByUseridAndPlaygroundName(userid, playgroundName);
    }

    public List<RouteEntity> getPlaygroundList(String userid) {
        return repo.findByUserid(userid);
    }
}
