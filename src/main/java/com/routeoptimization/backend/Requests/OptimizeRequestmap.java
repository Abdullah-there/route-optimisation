package com.routeoptimization.backend.Requests;

import java.util.List;

import com.routeoptimization.backend.dsa.LinkedListMaps;

public class OptimizeRequestmap {

    private int src;
    private int dest;
    private List<Route> routes;

    public static class Route {
    private int from;
    private int to;
    private double weight;

    private List<double[]> coords;

    private LinkedListMaps<double[]> coordsLinked;

    public int getFrom() { return from; }
    public void setFrom(int from) { this.from = from; }

    public int getTo() { return to; }
    public void setTo(int to) { this.to = to; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public List<double[]> getCoords() { return coords; }
    public void setCoords(List<double[]> coords) { this.coords = coords; }

    public LinkedListMaps<double[]> getCoordsLinked() { return coordsLinked; }
    public void setCoordsLinked(LinkedListMaps<double[]> coordsLinked) {
        this.coordsLinked = coordsLinked;
    }
}


    public int getSrc() { return src; }
    public void setSrc(int src) { this.src = src; }

    public int getDest() { return dest; }
    public void setDest(int dest) { this.dest = dest; }

    public List<Route> getRoutes() { return routes; }
    public void setRoutes(List<Route> routes) { this.routes = routes; }
}
