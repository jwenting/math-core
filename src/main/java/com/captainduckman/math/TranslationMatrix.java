package com.captainduckman.math;

public class TranslationMatrix extends MutationMatrix {

    public TranslationMatrix(final double x, final double y, final double z) {
        super();
        matrix.grid[0][0] = 1;
        matrix.grid[1][1] = 1;
        matrix.grid[2][2] = 1;
        matrix.grid[3][3] = 1;
        matrix.grid[0][3] = x;
        matrix.grid[1][3] = y;
        matrix.grid[2][3] = z;
    }

    public TranslationMatrix(final TranslationMatrix input) {
        super();
        matrix.grid[0][0] = 1;
        matrix.grid[1][1] = 1;
        matrix.grid[2][2] = 1;
        matrix.grid[3][3] = 1;
        matrix.grid[0][3] = input.matrix.grid[0][3];
        matrix.grid[1][3] = input.matrix.grid[1][3];
        matrix.grid[2][3] = input.matrix.grid[2][3];
    }

    @Override
    public String toString() {
        return "TranslationMatrix{" +
                "matrix=" + matrix +
                '}';
    }
}
