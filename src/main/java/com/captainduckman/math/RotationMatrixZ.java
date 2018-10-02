package com.captainduckman.math;

public class RotationMatrixZ extends AbstractRotationMatrix {
    /**
     * Creates a new RotationMatrixX.
     * Rotations in radians.
     *
     * @param rotation Y-axis rotation
     */
    public RotationMatrixZ(final double rotation) {
        super();
        matrix.grid[0][0] = Math.cos(rotation);
        matrix.grid[1][1] = Math.cos(rotation);
        matrix.grid[0][1] = -Math.sin(rotation);
        matrix.grid[1][0] = Math.sin(rotation);
        matrix.grid[2][2] = 1;
        matrix.grid[3][3] = 1;
    }
}
