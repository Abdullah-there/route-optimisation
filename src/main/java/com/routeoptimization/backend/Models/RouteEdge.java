package com.routeoptimization.backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column; 

@Entity
@Table(name = "route_edges")
public class RouteEdge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_node")
    private int fromNode;
    
    @Column(name = "to_node")
    private int toNode;
    
    private int weight; 

    public RouteEdge() {}

    public RouteEdge(int fromNode, int toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getFrom() {
        return fromNode; 
    }
    public void setFrom(int fromNode) {
        this.fromNode = fromNode;
    }

    public int getTo() {
        return toNode;
    }
    public void setTo(int toNode) {
        this.toNode = toNode;
    }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
