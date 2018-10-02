package com.captainduckman.math;

/**
 * Point represents a point in 3 dimensional space
 */
public class Point extends AbstractTupleProxy<Point> {
    /**
     * Create a new point in space.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     */
    public Point(final double x, final double y, final double z) {
        tuple = new Tuple(x, y, z, Tuple.TYPE_POINT);
    }

    /**
     * Create a new point based on an existing Tuple.
     *
     * @param tuple the Tuple to be contained in this point
     */
    public Point(final Tuple tuple) {
        this.tuple = tuple;
    }

    /**
     * Create a new point based on an existing point.
     * @param o the point to be used as a template
     */
    public Point(final Point o) {
        tuple = new Tuple(o.tuple.x, o.tuple.y, o.tuple.z, Tuple.TYPE_POINT);
    }

    /**
     * Add a vector to a point.
     * Effectively moves the point along the vector.
     * @param vector the Vector
     * @return this point after transformation
     */
    public Point add(final Vector vector) {
        tuple.add(vector.tuple);
        return this;
    }

    /**
     * Substract a vector from a point.
     * Effectively moves the point along the vector.
     * @param vector the Vector
     * @return this point after transformation
     */
    public Point subtract(final Vector vector) {
        tuple.subtract(vector.tuple);
        return this;
    }

    /**
     * Substract a point from a point.
     * Provides a vector pointing from one point to the next
     * @param point the other point
     * @return the vector between the points
     */
    public Vector subtract(final Point point) {
        Tuple t = new Tuple(tuple.x, tuple.y, tuple.z, Tuple.TYPE_VECTOR);
        t = t.subtract(point.tuple);
        t.setW(Tuple.TYPE_VECTOR);
        return new Vector(t);
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
        Point point = (Point) o;
        return tuple.equals(point.tuple);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return tuple.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Point{" +
                "tuple=" + tuple +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    public Point translate(final TranslationMatrix matrix) {
        double temp = tuple.w;
        tuple.w = 1;
        tuple = matrix.matrix.multiply(tuple);
        tuple.w = temp;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Point rotateX(final RotationMatrixX matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Point rotateY(final RotationMatrixY matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Point rotateZ(final RotationMatrixZ matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Point scale(final ScalingMatrix matrix) {
        tuple.x = (tuple.x * matrix.matrix.grid[0][0]);
        tuple.y = (tuple.y * matrix.matrix.grid[1][1]);
        tuple.z = (tuple.z * matrix.matrix.grid[2][2]);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Point shear(final ShearingMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * Transform the point
     * @param matrix the transformation
     * @return the transformed point
     */
    public Point transform(final AbstractMutationMatrix matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

}
