package com.captainduckman.math;

/**
 * Translation transformation.
 */
public class TranslationMatrix extends MutationMatrix {

    /**
     * Creates a new translation
     *
     * @param x x component
     * @param y y component
     * @param z z component
     */
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

    /**
     * Create a new translation as a copy of an existing one.
     * @param input the original
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TranslationMatrix{" +
                "matrix=" + matrix +
                '}';
    }
}
