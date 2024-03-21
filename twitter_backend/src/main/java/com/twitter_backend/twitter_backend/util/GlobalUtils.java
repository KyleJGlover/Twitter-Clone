package com.twitter_backend.twitter_backend.util;

import java.util.Collections;
import java.util.List;

public class GlobalUtils {

    private GlobalUtils() {
        throw new AssertionError("Instantiating utility class...");
    }
    
    public static <T extends Comparable<T>> boolean areListsEqual(List<T> list1, List<T> list2) {
        // Check if lists are null or have different sizes
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }

        // Sort both lists if the order doesn't matter
        Collections.sort(list1);
        Collections.sort(list2);

        // Compare elements of both lists
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        // All elements are equal
        return true;
    }
}
