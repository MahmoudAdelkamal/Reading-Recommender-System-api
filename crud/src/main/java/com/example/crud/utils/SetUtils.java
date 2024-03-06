package com.example.crud.utils;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    public static Set<Integer> stringToSet(String inputString) {
        Set<Integer> set = new HashSet<>();
        inputString = inputString.substring(1, inputString.length() - 1); // Remove brackets
        String[] tokens = inputString.split(",");
        for (String token : tokens) {
            set.add(Integer.parseInt(token.trim()));
        }
        return set;
    }

    public static String setToString(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer element : set) {
            sb.append(element).append(",");
        }
        if (!set.isEmpty()) {
            sb.setLength(sb.length() - 1); // Remove trailing comma
        }
        sb.append("]");
        return sb.toString();
    }
}
