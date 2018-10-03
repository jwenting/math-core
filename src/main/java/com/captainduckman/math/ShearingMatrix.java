package com.captainduckman.math;

/**
 * Shearing transformation.
 */
public class ShearingMatrix extends MutationMatrix {

    /**
     * Create a shearing matrix.
     *
     * @param xy xz component
     * @param xz xz component
     * @param yx yx component
     * @param yz yz component
     * @param zx zx component
     * @param zy zy component
     */
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
