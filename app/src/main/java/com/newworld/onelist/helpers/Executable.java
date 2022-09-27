package com.newworld.onelist.helpers;

/**
 * Interface to replace plain parameter-less Runnable
 */
public interface Executable {
    /**
     * @param values (Optional) parameter list that passed in this method, might be null
     * @return (Optional) might be a value that caller wants
     */
    int execute(Object... values);
}
