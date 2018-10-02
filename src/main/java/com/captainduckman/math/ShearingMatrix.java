package com.captainduckman.math;

public class ShearingMatrix extends MutationMatrix {

    public ShearingMatrix(final double xy, final double xz, final double yx, final double yz, final double zx, final double zy) {
        super();
        matrix.grid[0][1] = xy;
        matrix.grid[0][2] = xz;
        matrix.grid[1][0] = yx;
        matrix.grid[1][2] = yz;
        matrix.grid[2][0] = zx;
        matrix.grid[2][1] = zy;
    }
}
