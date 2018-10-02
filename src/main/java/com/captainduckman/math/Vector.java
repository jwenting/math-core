package com.captainduckman.math;

public class Vector extends AbstractTupleProxy<Vector> {
    public Vector(final double x, final double y, final double z) {
        tuple = new Tuple(x, y, z, Tuple.TYPE_VECTOR);
    }

    public Vector(final Tuple tuple) {
        this.tuple = tuple;
    }

    public Vector(final Point point) {
        this.tuple = new Tuple(point.tuple);
        this.tuple.w = Tuple.TYPE_VECTOR;
    }

    public Vector(final Vector vector) {
        this.tuple = new Tuple(vector.tuple);
        this.tuple.w = Tuple.TYPE_VECTOR;
    }

    public Point add(final Point point) {
        Tuple t = new Tuple(tuple.x, tuple.y, tuple.z, tuple.w);
        t = t.add(point.tuple);
        return new Point(t);
    }

    public Vector add(final Vector point) {
        tuple.add(point.tuple);
        return this;
    }

    public Vector subtract(final Vector vector) {
        tuple.subtract(vector.tuple);
        return this;
    }

    public Vector negate() {
        tuple.negate();
        return this;
    }

    public Vector multiply(final double factor) {
        tuple.multiply(factor);
        return this;
    }

    public Vector divide(final double factor) {
        tuple.divide(factor);
        return this;
    }

    public Vector normalise() {
        tuple.normalise();
        return this;
    }

    public double dot(final Vector vector) {
        return tuple.dot(vector.tuple);
    }

    public Vector cross(final Vector vector) {
        Tuple t = new Tuple(tuple.x, tuple.y, tuple.z, tuple.w);
        return new Vector(t.cross(vector.tuple));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return tuple.equals(vector.tuple);
    }

    @Override
    public int hashCode() {
        return tuple.hashCode();
    }

    @Override
    public String toString() {
        return "Vector{" +
                "tuple=" + tuple +
                '}';
    }


    @Override
    public Vector translate(final TranslationMatrix matrix) {
        double temp = tuple.w;
        tuple.w = 1;
        tuple = matrix.matrix.multiply(tuple);
        tuple.w = temp;
        return this;
    }

    @Override
    public Vector rotateX(final RotationMatrixX matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    @Override
    public Vector rotateY(final RotationMatrixY matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    @Override
    public Vector rotateZ(final RotationMatrixZ matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    @Override
    public Vector scale(final ScalingMatrix matrix) {
        tuple.x = (tuple.x * matrix.matrix.grid[0][0]);
        tuple.y = (tuple.y * matrix.matrix.grid[1][1]);
        tuple.z = (tuple.z * matrix.matrix.grid[2][2]);
        return this;
    }

    @Override
    public Vector shear(final ShearingMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Vector subtract(final Point position) {
        tuple.subtract(position.tuple);
        tuple.w = Tuple.TYPE_VECTOR;
        return this;
    }

    public Vector transform(final AbstractMutationMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Vector reflect(final Vector n) {
        Vector vector = new Vector(n);
        Vector multiply = vector.multiply(2).multiply(this.dot(n));
        tuple = tuple.subtract(multiply.tuple);
        return this;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2));
    }
}
