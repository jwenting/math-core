package com.captainduckman.math;

/**
 * A mutation matrix.
 */
public class MutationMatrix extends AbstractMutationMatrix {
    /**
     * Create a new MutationMatrix.
     */
    public MutationMatrix() {
        super();
    }

    /**
     * Create a MutationMatrix from another AbstractMutationMatrix.
     *
     * @param input the AbstractMutationMatrix to use as a source
     */
    public MutationMatrix(final AbstractMutationMatrix input) {
        matrix = new Matrix(input.matrix);
    }

    /**
     * Get the underlying Matrix.
     * @return the Matrix underlying this mutation matrix
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Set the underlying matrix for this mutation matrix.
     * @param matrix the new underlying matrix
     */
    public void setMatrix(final Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Determine the cross product of 2 mutation matrices.
     * @param input the other matrix
     * @return this matrix crossed with the other matrix
     */
    public MutationMatrix cross(final MutationMatrix input) {
        matrix = matrix.multiply(input.matrix);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutationMatrix inverse() {
        return (MutationMatrix) super.inverse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "MutationMatrix{" +
                "matrix=" + matrix +
                '}';
    }
}
