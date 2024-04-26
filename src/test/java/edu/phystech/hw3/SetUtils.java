package edu.phystech.hw3;

import java.util.HashSet;
import java.util.Set;

class SetUtils<T> {
    public static <T> Set<T> union(Set<T> firstSet, Set<T> secondSet) {
        var result = new HashSet<>(firstSet);
        result.addAll(secondSet);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> firstSet, Set<T> secondSet) {
        var result = new HashSet<>(firstSet);
        result.retainAll(secondSet);
        return result;
    }

    public static <T> Set<T> difference(Set<T> firstSet, Set<T> secondSet) {
        var result = new HashSet<>(firstSet);
        result.removeAll(secondSet);
        return result;
    }

    public static <T> Set<T> symmetricDifference(Set<T> firstSet, Set<T> secondSet) {
        return union(difference(firstSet, secondSet), difference(secondSet, firstSet));
    }
}
