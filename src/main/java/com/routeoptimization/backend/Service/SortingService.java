package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Entity.RouteEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SortingService {

    public void quickSortEntitiesDesc(List<RouteEntity> entities, int low, int high) {
        if (low < high) {
            int pi = partitionEntities(entities, low, high);
            quickSortEntitiesDesc(entities, low, pi - 1);
            quickSortEntitiesDesc(entities, pi + 1, high);
        }
    }

    private int partitionEntities(List<RouteEntity> entities, int low, int high) {
        Long pivot = entities.get(high).getId();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (entities.get(j).getId() >= pivot) {
                i++;
                swap(entities, i, j);
            }
        }

        swap(entities, i + 1, high);
        return i + 1;
    }

    private void swap(List<RouteEntity> entities, int i, int j) {
        RouteEntity temp = entities.get(i);
        entities.set(i, entities.get(j));
        entities.set(j, temp);
    }
}