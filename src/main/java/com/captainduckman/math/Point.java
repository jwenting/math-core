package com.captainduckman.math;

public class Point extends AbstractTupleProxy<Point> {
    public Point(final double x, final double y, final double z) {
        tuple = new Tuple(x, y, z, Tuple.TYPE_POINT);
    }

    public Point(final Tuple tuple) {
        this.tuple = tuple;
    }

    public Point(final Point o) {
        tuple = new Tuple(o.tuple.x, o.tuple.y, o.tuple.z, Tuple.TYPE_POINT);
    }

    public Point add(final Vector vector) {
        tuple.add(vector.tuple);
        return this;
    }

    public Point subtract(final Vector vector) {
        tuple.subtract(vector.tuple);
        return this;
    }

    public Vector subtract(final Point point) {
        Tuple t = new Tuple(tuple.x, tuple.y, tuple.z, Tuple.TYPE_VECTOR);
        t = t.subtract(point.tuple);
        t.setW(Tuple.TYPE_VECTOR);
        return new Vector(t);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return tuple.equals(point.tuple);
    }

    @Override
    public int hashCode() {
        return tuple.hashCode();
    }

    @Override
    public String toString() {
        return "Point{" +
                "tuple=" + tuple +
                '}';
    }

    public Point translate(final TranslationMatrix matrix) {
        double temp = tuple.w;
        tuple.w = 1;
        tuple = matrix.matrix.multiply(tuple);
        tuple.w = temp;
        return this;
    }

    public Point rotateX(final RotationMatrixX matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Point rotateY(final RotationMatrixY matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Point rotateZ(final RotationMatrixZ matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Point scale(final ScalingMatrix matrix) {
        tuple.x = (tuple.x * matrix.matrix.grid[0][0]);
        tuple.y = (tuple.y * matrix.matrix.grid[1][1]);
        tuple.z = (tuple.z * matrix.matrix.grid[2][2]);
        return this;
    }

    public Point shear(final ShearingMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    public Point transform(final AbstractMutationMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

}
