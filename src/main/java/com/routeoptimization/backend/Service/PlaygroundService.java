package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Requests.PlaygroundRequest;
import com.routeoptimization.backend.Requests.PlaygroundRequestNode;
import com.routeoptimization.backend.Entity.NodeEntity;
import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.Models.PlaygroundDataDTO;
import com.routeoptimization.backend.Repository.RouteRepository;
import com.routeoptimization.backend.Repository.NodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {

    private final RouteRepository repo;
    private final NodeRepository repos;

    public PlaygroundService(RouteRepository repo, NodeRepository repos) {
        this.repo = repo;
        this.repos = repos;
    }

    public void saveRoutes(PlaygroundRequest request) {
        if (request == null || request.getUserId() == null || request.getPlaygroundName() == null) {
            throw new IllegalArgumentException("Request, userId and playgroundName are required");
        }

        if (request.getRoutes() == null)
            return;
        System.out.println(request.getRoutes());

        for (PlaygroundRequest.RouteDTO r : request.getRoutes()) {
            RouteEntity entity = new RouteEntity(
                    request.getUserId(),
                    request.getPlaygroundName(),
                    r.getFrom(),
                    r.getTo(),
                    r.getWeight());
            repo.save(entity);
        }
    }

    public void saveNodes(PlaygroundRequestNode request) {
        if (request == null || request.getPlaygroundName() == null) {
            throw new IllegalArgumentException("Request and playgroundName are required");
        }

        if (request.getNodes() == null)
            return;

        for (PlaygroundRequestNode.NodeDTO n : request.getNodes()) {
            NodeEntity entity = new NodeEntity(
                    n.getNodeId(),
                    n.getX(),
                    n.getY(),
                    n.getLabel(),
                    request.getPlaygroundName());
            repos.save(entity);
        }
    }

    public PlaygroundDataDTO getPlayground(String userid, String playgroundName) {

        List<RouteEntity> routeEntities = repo.findByUseridAndPlaygroundName(userid, playgroundName);
        List<NodeEntity> nodeEntities = repos.findByplaygroundName(playgroundName);

        return new PlaygroundDataDTO(routeEntities, nodeEntities);
    }

    public List<RouteEntity> getPlaygroundList(String userid) {
        return repo.findByUserid(userid);
    }
}
