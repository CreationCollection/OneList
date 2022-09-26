package com.newworld.onelist.helpers;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * An atomic wrapper over value to provide a simple way to interact within multiple thread
 * @param <T> value type that need to store
 */
public class Wrapper<T> {
    interface LazyGetter<T> {
        void get(T val);
    }

    AtomicReference<T> val = new AtomicReference<>();
    LinkedList<LazyGetter<T>> lazyListener = new LinkedList<>();
    LinkedList<LazyGetter<T>> listeners = new LinkedList<>();

    public Wrapper() {
        val.set(null);
    }
    public Wrapper(T val) {
        this.val.set(val);
    }

    public void set(T val) {
        this.val.set(val);
        for (LazyGetter<T> v : lazyListener) {
            v.get(val);
        }
        lazyListener.clear();
        for (LazyGetter<T> l : listeners) {
            l.get(val);
        }
    }

    public T get() {
        return val.get();
    }

    /** Get value immediately if available else retrieve it later when value is available
     * @param getter listener for retrieving value
     */
    public void lazyGet(LazyGetter<T> getter) {
        if (val.get() == null) {
            lazyListener.add(getter);
        }
        else {
            getter.get(val.get());
        }
    }

    public void addValueListener(LazyGetter<T> listener) {
        listeners.add(listener);
    }

    public void removeValueListener(LazyGetter<T> listener) {
        listeners.remove(listener);
    }
}
