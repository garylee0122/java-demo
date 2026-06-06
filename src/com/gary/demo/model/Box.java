package com.gary.demo.model;

/**
 * Generic Class
 *
 * T 代表任何型別
 */
public class Box<T> {

    private T data;

    /**
     * 建構子
     */
    public Box(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }

    public void set(T data) {
        this.data = data;
    }
}