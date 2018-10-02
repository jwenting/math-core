package com.captainduckman.math;

/**
 * Abstract base for all mustation matrices
 */
public abstract class AbstractMutationMatrix {
    Matrix matrix;

    protected AbstractMutationMatrix() {
        matrix = Matrix.getIdentityMatrix(4);
    }

    /**
     * Calculate the inverse of the matrix.
     *
     * @return the matrix, inverted
     */
    public AbstractMutationMatrix inverse() {
        matrix = matrix.inverse();
        return this;
    }

    /**
     * Calculate the transposed matrix.
     * @return the matrix, transposed
     */
    public AbstractMutationMatrix transpose() {
        matrix = matrix.transpose();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return matrix.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        AbstractMutationMatrix other;
        if (obj instanceof AbstractMutationMatrix) {
            other = (AbstractMutationMatrix) obj;
        } else {
            return false;
        }
        return matrix.equals(other.matrix);
    }

    /**
     * Multiply the matrix with a Point.
     *
     * @param point the Point to be multiplied with
     * @return the resulting Point
     */
    public Point multiply(final Point point) {
        Tuple tuple = matrix.multiply(point.tuple);
        tuple.w = Tuple.TYPE_POINT;
        return new Point(tuple);
    }

    /**
     * Multiply the matrix with a Vector.
     * @param vector the Vector to be multiplied with
     * @return the resulting Vector
     */
    public Vector multiply(final Vector vector) {
        Tuple tuple = matrix.multiply(vector.tuple);
        tuple.w = Tuple.TYPE_VECTOR;
        return new Vector(tuple);
    }

}
