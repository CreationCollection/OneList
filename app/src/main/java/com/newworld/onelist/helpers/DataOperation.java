package com.newworld.onelist.helpers;

import java.util.List;

public class DataOperation {
    public static<T> void linearFilter(List<T> from, List<T> to, Comparable.SingleComparable<T> comparator) {
        for (int i = 0, j = from.size() - 1; i < j; i++, j--) {
            if (comparator.onCompare(from.get(i)))
                to.add(from.get(i));
            if (comparator.onCompare(from.get(j)))
                to.add(from.get(j));
        }
    }

    public static<T> void sort(List<T> list, Comparable.SetComparable<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            T a1 = list.get(i);
            T a2 = list.get(i + 1);
            if (!comparator.onCompare(a1, a2)) {
                list.set(i, a2);
                list.set(i + 1, a1);
                for (int j = i + 1; j > 0; j--) {
                    T b1 = list.get(j);
                    T b2 = list.get(j - 1);
                    if (comparator.onCompare(b1, b2)) {
                        list.set(j, b2);
                        list.set(j - 1, b1);
                    }
                }
            }
        }
    }

    public static<T> boolean contains(T[] arr, T key, Comparable.SetComparable<T> comparator) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (comparator.onCompare(arr[i], key)) return true;
            if (comparator.onCompare(arr[j], key)) return true;
        }
        return false;
    }

    public static<T> boolean contains(T[] arr, T[] keys, Comparable.SetComparable<T> comparator) {
        boolean pass = true;
        for (T key : keys) {
            pass &= contains(arr, key, comparator);
        }
        return pass;
    }

    public static<T> boolean contains(List<T> list, T key, Comparable.SetComparable<T> comparator) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (comparator.onCompare(list.get(i), key)) return true;
            if (comparator.onCompare(list.get(j), key)) return true;
        }
        return false;
    }

    public static<T> boolean contains(List<T> arr, T[] keys, Comparable.SetComparable<T> comparator) {
        boolean pass = true;
        for (T key : keys) {
            pass &= contains(arr, key, comparator);
        }
        return pass;
    }
}
