package com.routeoptimization.backend.Requests;

import java.util.List;

public class PlaygroundRequest {

    private String userId;
    private String playgroundName;
    private List<RouteDTO> routes;

    public static class RouteDTO {
        public String from;
        public String to;
        public int weight;

        public RouteDTO() {}
        public RouteDTO(String from, String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String getFrom() { return from; }
        public void setFrom(String from) { this.from = from; }

        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }

        public int getWeight() { return weight; }
        public void setWeight(int weight) { this.weight = weight; }
    }

    public PlaygroundRequest() {}

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPlaygroundName() { return playgroundName; }
    public void setPlaygroundName(String playgroundName) { this.playgroundName = playgroundName; }

    public List<RouteDTO> getRoutes() { return routes; }
    public void setRoutes(List<RouteDTO> routes) { this.routes = routes; }
}
