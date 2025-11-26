package com.routeoptimization.backend.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchingService {

    /** Binary Search on sorted node list */
    public Integer binarySearch(List<Integer> nodes, int target) {
        int left = 0, right = nodes.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nodes.get(mid) == target) return mid;
            if (nodes.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }
}
