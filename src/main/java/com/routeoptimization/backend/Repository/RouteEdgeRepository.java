package com.routeoptimization.backend.Repository;

import com.routeoptimization.backend.Models.RouteEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteEdgeRepository extends JpaRepository<RouteEdge, Long> {

}