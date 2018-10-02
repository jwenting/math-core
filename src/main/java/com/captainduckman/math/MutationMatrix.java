package com.captainduckman.math;

public class MutationMatrix extends AbstractMutationMatrix {
    public MutationMatrix() {
        super();
    }

    public MutationMatrix(final AbstractMutationMatrix input) {
        matrix = new Matrix(input.matrix);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(final Matrix matrix) {
        this.matrix = matrix;
    }

    public MutationMatrix cross(final MutationMatrix input) {
        matrix = matrix.multiply(input.matrix);
        return this;
    }

    @Override
    public MutationMatrix inverse() {
        return (MutationMatrix) super.inverse();
    }

    @Override
    public String toString() {
        return "MutationMatrix{" +
                "matrix=" + matrix +
                '}';
    }
}
