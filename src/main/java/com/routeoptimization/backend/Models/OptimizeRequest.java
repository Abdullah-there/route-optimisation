package com.routeoptimization.backend.Models; // adjust package as needed

import java.util.List;

public class OptimizeRequest {
    public List<RouteEdge> routes;
    public int start;
    public int end;
}
