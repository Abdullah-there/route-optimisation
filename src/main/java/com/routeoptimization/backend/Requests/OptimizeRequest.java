package com.routeoptimization.backend.Requests;

import com.routeoptimization.backend.Models.RouteEdge;
import java.util.List;

public class OptimizeRequest {
    public List<RouteEdge> routes;
    public int src;
    public int dest;
}
