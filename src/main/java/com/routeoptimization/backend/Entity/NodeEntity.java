package com.routeoptimization.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "nodes") 
public class NodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "node_id")
    private int nodeid;

    @Column(name = "x_coord")
    private int x;

    @Column(name = "y_coord")
    private int y;

    @Column(name = "label")
    private String label;

    @Column(name = "playground_name")
    private String playgroundName;

    public NodeEntity() {}

    public NodeEntity(int nodeid, int x, int y, String label, String playgroundName) {
        this.nodeid = nodeid;
        this.x = x;
        this.y = y;
        this.label = label;
        this.playgroundName = playgroundName;
    }

    public int getNodeId() { return nodeid; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getLabel() { return label; }
    public String getPlaygroundName() { return playgroundName; }

    public void setNodeId(int nodeid) { this.nodeid = nodeid; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setLabel(String label) { this.label = label; }
    public void setPlaygroundName(String playgroundName) { this.playgroundName = playgroundName; }
}
