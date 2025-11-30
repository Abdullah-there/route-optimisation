package com.routeoptimization.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userid;

    @Column(name = "playground_name")
    private String playgroundName;

    @Column(name = "from_node")
    private String fromNode;

    @Column(name = "to_node")
    private String toNode;

    @Column(name = "weight")
    private int weight;

    public RouteEntity() {}

    public RouteEntity(String userid, String playgroundName, String fromNode, String toNode, int weight) {
        this.userid = userid;
        this.playgroundName = playgroundName;
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public Long getId() { return id; }
    public String getUserid() { return userid; }
    public String getPlaygroundName() { return playgroundName; }
    public String getFromNode() { return fromNode; }
    public String getToNode() { return toNode; }
    public int getWeight() { return weight; }

    public void setId(Long id) { this.id = id; }
    public void setUserid(String userid) { this.userid = userid; }
    public void setPlaygroundName(String playgroundName) { this.playgroundName = playgroundName; }
    public void setFromNode(String fromNode) { this.fromNode = fromNode; }
    public void setToNode(String toNode) { this.toNode = toNode; }
    public void setWeight(int weight) { this.weight = weight; }
}

