package com.captainduckman.math;

/**
 * Scaling
 */
public class ScalingMatrix extends MutationMatrix {

    /**
     * Create a scaling matrix.
     *
     * @param x x scaling factor
     * @param y y scaling factor
     * @param z z scaling factor
     */
    public ScalingMatrix(final double x, final double y, final double z) {
        super();
        matrix.grid[0][0] = x;
        matrix.grid[1][1] = y;
        matrix.grid[2][2] = z;
        matrix.grid[3][3] = 1;
    }

    /**
     * Copy a scaling matrix to create a new one.
     * @param input the original
     */
    public ScalingMatrix(final ScalingMatrix input) {
        super();
        matrix.grid[0][0] = input.matrix.grid[0][0];
        matrix.grid[1][1] = input.matrix.grid[1][1];
        matrix.grid[2][2] = input.matrix.grid[2][2];
        matrix.grid[3][3] = 1;
    }
}
