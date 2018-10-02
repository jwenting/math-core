package com.captainduckman.math;

class MockMutationMatrix extends MutationMatrix {
    public MockMutationMatrix() {
        matrix = Matrix.getIdentityMatrix(4);
    }

    public MockMutationMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
