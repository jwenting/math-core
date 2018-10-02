package com.captainduckman.math;

public class ScalingMatrix extends MutationMatrix {

    public ScalingMatrix(final double x, final double y, final double z) {
        super();
        matrix.grid[0][0] = x;
        matrix.grid[1][1] = y;
        matrix.grid[2][2] = z;
        matrix.grid[3][3] = 1;
    }

    public ScalingMatrix(final ScalingMatrix input) {
        super();
        matrix.grid[0][0] = input.matrix.grid[0][0];
        matrix.grid[1][1] = input.matrix.grid[1][1];
        matrix.grid[2][2] = input.matrix.grid[2][2];
        matrix.grid[3][3] = 1;
    }
}
