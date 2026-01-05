package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Requests.PlaygroundRequest;
import com.routeoptimization.backend.Requests.PlaygroundRequestNode;
import com.routeoptimization.backend.dsa.LinkedListPlay;
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

    // Save routes from PlaygroundRequest
    public void saveRoutes(PlaygroundRequest request) {
        if (request == null || request.getUserId() == null || request.getPlaygroundName() == null) {
            throw new IllegalArgumentException("Request, userId and playgroundName are required");
        }

        if (request.getRoutes() == null){
            System.out.println("Here");
            return;
        }

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

    // Save nodes from PlaygroundRequestNode
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

    // Get playground with routes & nodes (converted to LinkedListPlay)
    public PlaygroundDataDTO getPlayground(String userid, String playgroundName) {

        List<RouteEntity> dbRoutes = repo.findByUseridAndPlaygroundName(userid, playgroundName);
        List<NodeEntity> dbNodes = repos.findByplaygroundName(playgroundName);

        LinkedListPlay<RouteEntity> routeEntities = new LinkedListPlay<>();
        LinkedListPlay<NodeEntity> nodeEntities = new LinkedListPlay<>();

        for (RouteEntity r : dbRoutes) {
            routeEntities.add(r);
        }
        for (NodeEntity n : dbNodes) {
            nodeEntities.add(n);
        }

        return new PlaygroundDataDTO(routeEntities, nodeEntities);
    }

    // Get all routes for a user
    public LinkedListPlay<RouteEntity> getPlaygroundList(String userid) {
        List<RouteEntity> dbRoutes = repo.findByUserid(userid);

        LinkedListPlay<RouteEntity> routeEntities = new LinkedListPlay<>();
        for (RouteEntity r : dbRoutes) {
            routeEntities.add(r);
        }

        return routeEntities;
    }
}
