package com.routeoptimization.backend.Repository;

import com.routeoptimization.backend.Entity.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NodeRepository extends JpaRepository<NodeEntity, Long> {
    List<NodeEntity> findByplaygroundName(String playgroundName);
    void deleteByplaygroundName(String playgroundName);
}
