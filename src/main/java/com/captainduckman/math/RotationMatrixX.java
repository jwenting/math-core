package com.captainduckman.math;

/**
 * Rotation around the X axis.
 */
public class RotationMatrixX extends AbstractRotationMatrix {

    /**
     * Creates a new RotationMatrixX.
     * Rotations in radians.
     *
     * @param rotX X-axis rotation
     */
    public RotationMatrixX(final double rotX) {
        super();
        matrix.grid[0][0] = 1;
        matrix.grid[1][1] = Math.cos(rotX);
        matrix.grid[1][2] = -Math.sin(rotX);
        matrix.grid[2][1] = Math.sin(rotX);
        matrix.grid[2][2] = Math.cos(rotX);
        matrix.grid[3][3] = 1;
    }
}
