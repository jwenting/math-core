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

    public Tuple() {

    }

    public Tuple(final double x, final double y, final double z, final double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Tuple(final Tuple tuple) {
        this.x = tuple.x;
        this.y = tuple.y;
        this.z = tuple.z;
        this.w = tuple.w;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return compare(x, tuple.x) && compare(y, tuple.y) && compare(z, tuple.z) && compare(w, tuple.w);
    }

    private boolean compare(final double expected, final double actual) {
        return MathUtils.compare(expected, actual);
    }

    public Tuple add(final Tuple tuple) {
        x = x + tuple.x;
        y = y + tuple.y;
        z = z + tuple.z;
        w = w + tuple.w;
        return this;
    }

    public Tuple subtract(final Tuple tuple) {
        x = x - tuple.x;
        y = y - tuple.y;
        z = z - tuple.z;
        w = w - tuple.w;
        return this;
    }

    public Tuple negate() {
        x = -x;
        y = -y;
        z = -z;
        w = -w;
        return this;
    }

    public Tuple multiply(final double factor) {
        x = x * factor;
        y = y * factor;
        z = z * factor;
        w = w * factor;
        return this;
    }

    public Tuple divide(final double factor) {
        return multiply(1D / factor);
    }

    public static Tuple vector(final double x, final double y, final double z) {
        return new Tuple(x, y, z, TYPE_VECTOR);
    }

    public static Tuple point(final double x, final double y, final double z) {
        return new Tuple(x, y, z, TYPE_POINT);
    }

    public Tuple normalise() {
        double m = magnitude();
        x = x / m;
        y = y / m;
        z = z / m;
        w = w / m;
        return this;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double dot(final Tuple a, final Tuple b) {
        return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
    }

    public double dot(final Tuple tuple) {
        return Tuple.dot(this, tuple);
    }


    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

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
