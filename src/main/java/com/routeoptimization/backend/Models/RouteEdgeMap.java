package com.routeoptimization.backend.Models;

public class RouteEdgeMap {
    private int from;
    private int to;
    private double weight; // e.g., distance or traffic weight

    public RouteEdgeMap() {}
    public RouteEdgeMap(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() { return from; }
    public void setFrom(int from) { this.from = from; }

    public int getTo() { return to; }
    public void setTo(int to) { this.to = to; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
