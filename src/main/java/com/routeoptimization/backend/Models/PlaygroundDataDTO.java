package com.routeoptimization.backend.Models;

import com.routeoptimization.backend.Entity.RouteEntity;
import com.routeoptimization.backend.Entity.NodeEntity;


import java.util.List;

public class PlaygroundDataDTO {
    private List<RouteEntity> routes;
    private List<NodeEntity> nodes;

    public PlaygroundDataDTO(List<RouteEntity> routes, List<NodeEntity> nodes) {
        this.routes = routes;
        this.nodes = nodes;
    }

    public List<RouteEntity> getRoutes() { return routes; }
    public void setRoutes(List<RouteEntity> routes) { this.routes = routes; }
    public List<NodeEntity> getNodes() { return nodes; }
    public void setNodes(List<NodeEntity> nodes) { this.nodes = nodes; }
}
