package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Requests.OptimizeRequestmap;
import com.routeoptimization.backend.dsa.LinkedListMaps;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationService {

    private static final double LENGTH_FACTOR = 2.0;
    private static final double WEIGHT_FACTOR = 1.0;

    public LinkedListMaps<double[]> findBestRoute(
            LinkedListMaps<OptimizeRequestmap.Route> routes) {

        if (routes == null || routes.isEmpty()) {
            throw new IllegalArgumentException("No routes provided");
        }

        OptimizeRequestmap.Route bestRoute = null;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < routes.size(); i++) {
            OptimizeRequestmap.Route route = routes.get(i);
            LinkedListMaps<double[]> coords = route.getCoordsLinked(); // use LinkedListMaps

            double length = calculateRouteLength(coords);
            double cost = (LENGTH_FACTOR * length) + (WEIGHT_FACTOR * route.getWeight());

            if (cost < minCost) {
                minCost = cost;
                bestRoute = route;
            }
        }

        if (bestRoute == null) {
            throw new IllegalStateException("No valid route found");
        }

        return bestRoute.getCoordsLinked();
    }

    private double calculateRouteLength(LinkedListMaps<double[]> coords) {
        double total = 0.0;
        if (coords == null || coords.size() < 2) return total;

        for (int i = 1; i < coords.size(); i++) {
            double[] p1 = coords.get(i - 1);
            double[] p2 = coords.get(i);
            total += haversine(p1[0], p1[1], p2[0], p2[1]);
        }
        return total;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Earth radius in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        return 2 * R * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
