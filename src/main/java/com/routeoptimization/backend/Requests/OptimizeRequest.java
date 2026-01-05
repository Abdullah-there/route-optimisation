package com.routeoptimization.backend.Requests;

import com.routeoptimization.backend.Models.RouteEdge;
import java.util.List;

public class OptimizeRequest {
    public List<RouteEdge> routes;
    public int src;
    public int dest;

    public int getSrc() { return src; }
    public void setSrc(int src) { this.src = src; }
    public int getDest() { return dest; }
    public void setDest(int dest) { this.dest = dest; }
    public List<RouteEdge> getRoutes() { return routes; }
    public void setRoutes(List<RouteEdge> routes) { this.routes = routes; }

}
