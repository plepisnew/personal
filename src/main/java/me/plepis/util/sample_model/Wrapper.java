package me.plepis.util.sample_model;

import java.io.Serializable;

public class Wrapper<T> implements Serializable {

    private T box;

    public Wrapper(T box) {
        this.box = box;
    }

    public T getBox() {
        return this.box;
    }

    public void setBox(T box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return box.toString();
    }
}
