package com.newworld.onelist.helpers;

public interface Comparable {
    interface SingleComparable<T> {
        boolean onCompare(T compare);
    }
    interface SetComparable<T> {
        boolean onCompare(T from, T to);
    }
    interface VectorComparable<T> {
        int onCompare(T compare);
    }
    interface VectorSetComparable<T> {
        int onCompare(T from, T to);
    }
}
