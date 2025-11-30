package com.routeoptimization.backend.Repository;

import com.routeoptimization.backend.Entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    List<RouteEntity> findByUseridAndPlaygroundName(String userid, String playgroundName);
    List<RouteEntity> findByUserid(String userid);
    void deleteByUseridAndPlaygroundName(String userid, String playgroundName);
}
