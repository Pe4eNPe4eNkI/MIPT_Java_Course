package edu.phystech.hw3;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InverseMapKeyValuesTest {

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map) {
        Map<V, Collection<K>> result = new HashMap<>();
        for (var entry : map.entrySet()) {
            result.computeIfAbsent(entry.getValue(), val -> new ArrayList<>()).add(entry.getKey());
        }
        return result;
    }

    @Test
    void noDuplicateValuesTest() {
        Map<Integer, String> originalMap = Map.of(1, "first", 2, "second");
        Map<String, Collection<Integer>> expectedMap = Map.of("first", List.of(1), "second", List.of(2));

        Map<String, Collection<Integer>> actualMap = inverse(originalMap);

        Assertions.assertEquals(expectedMap.size(), actualMap.size());

        expectedMap.forEach((key, value) -> {
            var entry = actualMap.get(key);
            Assertions.assertNotNull(entry);
            Assertions.assertEquals(new HashSet<>(value), new HashSet<>(entry));
        });

    }

    @Test
    void duplicateValuesTest() {
        Map<Integer, String> originalMap = Map.of(1, "first", 2, "second", 3, "second");
        Map<String, Collection<Integer>> expectedMap = Map.of("first", List.of(1), "second", List.of(2, 3));

        Map<String, Collection<Integer>> actualMap = inverse(originalMap);

        Assertions.assertEquals(expectedMap.size(), actualMap.size());

        expectedMap.forEach((key, value) -> {
            var entry = actualMap.get(key);
            Assertions.assertNotNull(entry);
            Assertions.assertEquals(new HashSet<>(value), new HashSet<>(entry));
        });

    }
}

