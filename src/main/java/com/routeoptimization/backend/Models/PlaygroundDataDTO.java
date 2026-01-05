package com.routeoptimization.backend.Models;

import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.dsa.LinkedListPlay;
import com.routeoptimization.backend.Entity.NodeEntity;


public class PlaygroundDataDTO {
    private LinkedListPlay<RouteEntity> routes;
    private LinkedListPlay<NodeEntity> nodes;

    public PlaygroundDataDTO(LinkedListPlay<RouteEntity> routes, LinkedListPlay<NodeEntity> nodes) {
        this.routes = routes;
        this.nodes = nodes;
    }

    public LinkedListPlay<RouteEntity> getRoutes() { return routes; }
    public void setRoutes(LinkedListPlay<RouteEntity> routes) { this.routes = routes; }
    public LinkedListPlay<NodeEntity> getNodes() { return nodes; }
    public void setNodes(LinkedListPlay<NodeEntity> nodes) { this.nodes = nodes; }
}
