package com.routeoptimization.backend.Service;

import com.routeoptimization.backend.Models.RouteEdge;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class SortingService {

    /** QuickSort by weight */
    public void quickSort(List<RouteEdge> edges, int low, int high) {
        if (low < high) {
            int pi = partition(edges, low, high);
            quickSort(edges, low, pi - 1);
            quickSort(edges, pi + 1, high);
        }
    }

    private int partition(List<RouteEdge> edges, int low, int high) {
        int pivot = edges.get(high).getWeight();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (edges.get(j).getWeight() <= pivot) {
                i++;
                Collections.swap(edges, i, j);
            }
        }

        Collections.swap(edges, i + 1, high);
        return i + 1;
    }
}
