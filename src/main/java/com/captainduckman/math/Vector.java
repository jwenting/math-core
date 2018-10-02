package com.captainduckman.math;

/**
 * Vector represents a vector in 3 dimensional space
 */
public class Vector extends AbstractTupleProxy<Vector> {

    /**
     * Create a new vector.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     */
    public Vector(final double x, final double y, final double z) {
        tuple = new Tuple(x, y, z, Tuple.TYPE_VECTOR);
    }

    /**
     * Create a new vector based on an existing Tuple.
     *
     * @param tuple the Tuple to be contained in this vector
     */
    public Vector(final Tuple tuple) {
        this.tuple = tuple;
    }

    /**
     * Create a new vector based on an existing point.
     * @param point the point to be used as a template
     */
    public Vector(final Point point) {
        this.tuple = new Tuple(point.tuple);
        this.tuple.w = Tuple.TYPE_VECTOR;
    }

    /**
     * Create a new vector based on an existing vector.
     * @param vector the vector to be used as a template
     */
    public Vector(final Vector vector) {
        this.tuple = new Tuple(vector.tuple);
        this.tuple.w = Tuple.TYPE_VECTOR;
    }

    /**
     * Add a point to a point.
     * @param point the point
     * @return this vector after transformation
     */
    public Point add(final Point point) {
        Tuple t = new Tuple(tuple.x, tuple.y, tuple.z, tuple.w);
        t = t.add(point.tuple);
        return new Point(t);
    }

    /**
     * Add a vector to a vector.
     *
     * @param vector the Vector
     * @return this vector after transformation
     */
    public Vector add(final Vector vector) {
        tuple.add(vector.tuple);
        return this;
    }

    /**
     * Substract a vector from a point.
     * Effectively moves the point along the vector.
     * @param vector the Vector
     * @return this point after transformation
     */
    public Vector subtract(final Vector vector) {
        tuple.subtract(vector.tuple);
        return this;
    }

    /**
     * Negate the vector.
     * @return the negated vector
     */
    public Vector negate() {
        tuple.negate();
        return this;
    }

    /**
     * Multiply the vector by a number.
     * @param factor the multiplication factor
     * @return the multiplied vector
     */
    public Vector multiply(final double factor) {
        tuple.multiply(factor);
        return this;
    }

    /**
     * Divide the vector by a number.
     * @param factor the factor
     * @return the divided vector
     */
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
        return "Vector{" +
                "tuple=" + tuple +
                '}';
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Vector translate(final TranslationMatrix matrix) {
        double temp = tuple.w;
        tuple.w = 1;
        tuple = matrix.matrix.multiply(tuple);
        tuple.w = temp;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector rotateX(final RotationMatrixX matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector rotateY(final RotationMatrixY matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector rotateZ(final RotationMatrixZ matrix) {
        tuple = matrix.matrix.multiply(tuple);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector scale(final ScalingMatrix matrix) {
        tuple.x = (tuple.x * matrix.matrix.grid[0][0]);
        tuple.y = (tuple.y * matrix.matrix.grid[1][1]);
        tuple.z = (tuple.z * matrix.matrix.grid[2][2]);
        return this;
    }

    /**
     * {@inheritDoc}
     */
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
