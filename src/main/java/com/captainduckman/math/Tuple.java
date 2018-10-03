package com.captainduckman.math;

import java.util.Objects;

/**
 * A tuple.
 */
public class Tuple {
    public static final double TYPE_VECTOR = 0.0;
    public static final double TYPE_POINT = 1.0;

    protected double x;
    protected double y;
    protected double z;
    protected double w;

    /**
     * Create an empty tuple.
     */
    public Tuple() {

    }

    /**
     * Create a new tuple.
     *
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @param w the w component
     */
    public Tuple(final double x, final double y, final double z, final double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Create a new tuple from an existing tuple.
     * @param tuple the original
     */
    public Tuple(final Tuple tuple) {
        this.x = tuple.x;
        this.y = tuple.y;
        this.z = tuple.z;
        this.w = tuple.w;
    }

    /**
     * Generate a Tuple of TYPE_VECTOR.
     *
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @return the resulting Tuple
     */
    public static Tuple vector(final double x, final double y, final double z) {
        return new Tuple(x, y, z, TYPE_VECTOR);
    }

    public void setX(double x) {
        this.x = x;
    }

    /**
     * Generate a Tuple of TYPE_POINT.
     *
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @return the resulting Tuple
     */
    public static Tuple point(final double x, final double y, final double z) {
        return new Tuple(x, y, z, TYPE_POINT);
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the dot product of two tuple.
     *
     * @param a the first
     * @param b the second
     * @return the dot product
     */
    public static double dot(final Tuple a, final Tuple b) {
        return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Get the x component.
     * @return the x component
     */
    public double getX() {
        return x;
    }

    public void setW(double w) {
        this.w = w;
    }

    /**
     * Get the y component.
     * @return the y component
     */
    public double getY() {
        return y;
    }

    /**
     * Get the z component.
     * @return the z component
     */
    public double getZ() {
        return z;
    }

    /**
     * Get the w component.
     * @return the w component
     */
    public double getW() {
        return w;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return MathUtils.compare(x, tuple.x) && MathUtils.compare(y, tuple.y) && MathUtils.compare(z, tuple.z) && MathUtils.compare(w, tuple.w);
    }

    /**
     * Add 2 tuples
     * @param tuple the other tuple
     * @return this tuple after adding the other one to it
     */
    public Tuple add(final Tuple tuple) {
        x = x + tuple.x;
        y = y + tuple.y;
        z = z + tuple.z;
        w = w + tuple.w;
        return this;
    }

    /**
     * Subtract another tuple from this one.
     * @param tuple the other tuple
     * @return this tuple after subtracting the other one from it
     */
    public Tuple subtract(final Tuple tuple) {
        x = x - tuple.x;
        y = y - tuple.y;
        z = z - tuple.z;
        w = w - tuple.w;
        return this;
    }

    /**
     * Negate the tuple.
     * @return this tuple after negating it
     */
    public Tuple negate() {
        x = -x;
        y = -y;
        z = -z;
        w = -w;
        return this;
    }

    /**
     * Multiply the tuple by a factor.
     * @param factor the factor
     * @return this tuple after multiplication
     */
    public Tuple multiply(final double factor) {
        x = x * factor;
        y = y * factor;
        z = z * factor;
        w = w * factor;
        return this;
    }

    /**
     * Divide the tuple by a factor.
     * @param factor the factor
     * @return this tuple after division
     */
    public Tuple divide(final double factor) {
        return multiply(1D / factor);
    }

    /**
     * Normalise the tuple.
     * @return the normalised Tuple
     */
    public Tuple normalise() {
        double m = magnitude();
        x = x / m;
        y = y / m;
        z = z / m;
        w = w / m;
        return this;
    }

    /**
     * Get the magnitude/size of the Tuple.
     * @return the magnitude
     */
    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Get the dot product of this tuple and another one.
     * @param tuple the other tuple
     * @return the resulting dot product
     */
    public double dot(final Tuple tuple) {
        return Tuple.dot(this, tuple);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    public Tuple cross(final Tuple b) {
        if (w != TYPE_VECTOR || b.w != TYPE_VECTOR) {
            throw new UnsupportedOperationException("Can only cross vectors");
        }
        double newx = y * b.z - z * b.y;
        double newy = z * b.x - x * b.z;
        double newz = x * b.y - y * b.x;
        x = newx;
        y = newy;
        z = newz;
        return this;
    }
}
