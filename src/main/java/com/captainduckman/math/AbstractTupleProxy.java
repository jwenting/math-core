package com.captainduckman.math;

public abstract class AbstractTupleProxy<E extends Transformable<E>> implements Transformable<E> {
    // deliberately package private for high performance reference by other classes in this package
    Tuple tuple;

    public double getX() {
        return tuple.x;
    }

    public void setX(double x) {
        tuple.x = x;
    }

    public double getY() {
        return tuple.y;
    }

    public void setY(double y) {
        tuple.y = y;
    }

    public double getZ() {
        return tuple.z;
    }

    public void setZ(double z) {
        tuple.z = z;
    }

}
