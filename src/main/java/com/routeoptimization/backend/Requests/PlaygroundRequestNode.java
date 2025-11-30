package com.routeoptimization.backend.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PlaygroundRequestNode {

    private String playgroundName;
    private List<NodeDTO> nodes;

    public static class NodeDTO {

        @JsonProperty("nodeid")
        private int nodeid;
        private int x;
        private int y;
        private String label;

        public NodeDTO() {}

        public NodeDTO(int nodeid, int x, int y, String label) {
            this.nodeid = nodeid;
            this.x = x;
            this.y = y;
            this.label = label;
        }

        public int getNodeId() { return nodeid; }
        public void setNodeId(int nodeid) { this.nodeid = nodeid; }

        public int getX() { return x; }
        public void setX(int x) { this.x = x; }

        public int getY() { return y; }
        public void setY(int y) { this.y = y; }

        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
    }

    public PlaygroundRequestNode() {}

    public String getPlaygroundName() { return playgroundName; }
    public void setPlaygroundName(String playgroundName) { this.playgroundName = playgroundName; }

    public List<NodeDTO> getNodes() { return nodes; }
    public void setNodes(List<NodeDTO> nodes) { this.nodes = nodes; }
}
