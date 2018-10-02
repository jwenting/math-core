package com.captainduckman.math;

/**
 * Base class fcr classes working as proxies for a Tuple.
 *
 * @param <E> the type parameter
 */
public abstract class AbstractTupleProxy<E extends Transformable<E>> implements Transformable<E> {
    // deliberately package private for high performance reference by other classes in this package
    Tuple tuple;

    /**
     * get the X component.
     * @return the X component
     */
    public double getX() {
        return tuple.x;
    }

    /**
     * Set the X component.
     * @param x the X component
     */
    public void setX(double x) {
        tuple.x = x;
    }

    /**
     * get the Y component.
     * @return the Y component
     */
    public double getY() {
        return tuple.y;
    }

    /**
     * Set the Y component.
     * @param y the Y component
     */
    public void setY(double y) {
        tuple.y = y;
    }

    /**
     * get the Z component.
     * @return the Z component
     */
    public double getZ() {
        return tuple.z;
    }

    /**
     * Set the Z component.
     * @param z the Z component
     */
    public void setZ(double z) {
        tuple.z = z;
    }

}
