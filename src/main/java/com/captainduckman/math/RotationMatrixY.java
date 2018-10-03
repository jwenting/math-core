package com.captainduckman.math;

/**
 * Rotation around the Y axis.
 */
public class RotationMatrixY extends AbstractRotationMatrix {

    /**
     * Creates a new RotationMatrixX.
     * Rotations in radians.
     *
     * @param rotY Y-axis rotation
     */
    public RotationMatrixY(final double rotY) {
        super();
        matrix.grid[0][0] = Math.cos(rotY);
        matrix.grid[1][1] = 1;
        matrix.grid[0][2] = Math.sin(rotY);
        matrix.grid[2][0] = -Math.sin(rotY);
        matrix.grid[2][2] = Math.cos(rotY);
        matrix.grid[3][3] = 1;
    }
}
