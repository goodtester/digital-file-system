package com.rohini;

import java.io.File;
import java.util.Objects;

public class Algorithms {
    public static boolean binarySearch(String[] array, String searchedItem) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;

            int compareValue = Objects.compare(searchedItem, array[middle], String::compareToIgnoreCase);
            if (compareValue == 0) {
                return true;
            } else if(compareValue < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }

    public static boolean linearSearch(File[] array, String searchedItem) {
        for (File item : array) {
            if (searchedItem.equalsIgnoreCase(item.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void bubbleSort(String[] array) {
        int n = array.length;

        for(int i = 1; i < n; i++) {
            for(int b = 0; b < n - i; b++) {
                int compareValue = Objects.compare(array[b], array[b+1], String::compareToIgnoreCase);
                if(compareValue > 0) {
                    // swap
                    String temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }
}
