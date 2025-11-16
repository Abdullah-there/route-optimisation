package com.routeoptimization.backend.Models;

public class RouteEdge {
    private int from;
    private int to;
    private int weight;

    public int getFrom() { return from; }
    public void setFrom(int from) { this.from = from; }

    public int getTo() { return to; }
    public void setTo(int to) { this.to = to; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
