package com.captainduckman.math;

public abstract class AbstractMutationMatrix {
    Matrix matrix;

    protected AbstractMutationMatrix() {
        matrix = Matrix.getIdentityMatrix(4);
    }

    public AbstractMutationMatrix inverse() {
        matrix = matrix.inverse();
        return this;
    }

    public AbstractMutationMatrix transpose() {
        matrix = matrix.transpose();
        return this;
    }

    @Override
    public int hashCode() {
        return matrix.hashCode();
    }

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

    public Point multiply(final Point vector) {
        Tuple tuple = matrix.multiply(vector.tuple);
        tuple.w = Tuple.TYPE_POINT;
        return new Point(tuple);
    }

    public Vector multiply(final Vector vector) {
        Tuple tuple = matrix.multiply(vector.tuple);
        tuple.w = Tuple.TYPE_VECTOR;
        return new Vector(tuple);
    }

}
