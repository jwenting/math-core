package com.captainduckman.math;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.StrictMath.abs;

/**
 * A square matrix.
 * Supports only square matrices at the moment.
 */
public class Matrix {
    // package private for performance reasons (quick access from same package)
    final int dimension;
    double[][] grid;

    /**
     * Create a new matrix with the given dimension.
     *
     * @param dimension the required dimension
     */
    public Matrix(final int dimension) {
        this.dimension = dimension;
        grid = new double[dimension][dimension];
    }

    /**
     * Create a new matrix as a copy of an existing one.
     *
     * @param input the matrix to be copied
     */
    public Matrix(final Matrix input) {
        this.dimension = input.dimension;
        grid = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j] = input.grid[i][j];
            }
        }
    }

    /**
     * Set a cell to a specific value.
     *
     * @param row   row for the cell.
     * @param col   column for the cell.
     * @param value the new value.
     */
    public void set(final int row, final int col, final double value) {
        if (row < 0 || row >= dimension || col < 0 || col >= dimension) {
            throw new ArrayIndexOutOfBoundsException("attempting to set value outside of matrix");
        }
        grid[row][col] = value;
    }

    /**
     * Get the value of a cell.
     *
     * @param row row for the cell.
     * @param col column for the cell.
     * @return the value of the cell.
     */
    public double get(final int row, final int col) {
        if (row < 0 || row >= dimension || col < 0 || col >= dimension) {
            throw new ArrayIndexOutOfBoundsException("attempting to get value outside of matrix");
        }
        return grid[row][col];
    }

    /**
     * Matrix multiplication.
     *
     * @param matrix the second matrix
     * @return a new matrix that's the product of this and the other matrix
     */
    public Matrix multiply(final Matrix matrix) {
        if (dimension != matrix.dimension) {
            throw new IllegalArgumentException("Can't multiply matrices with different dimensions. This matrix has dimension " + dimension);
        }
        Matrix result = new Matrix(dimension);
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                result.grid[r][c] = calculateMultiplyR(r, c, matrix);
            }
        }
        return result;
    }

    private double calculateMultiplyR(final int row, final int col, final Matrix matrix) {
        double result = 0;

        for (int i = 0; i < dimension; i++) {
            result += (grid[row][i] * matrix.grid[i][col]);
        }
        return result;
    }

    /**
     * Generate an identity matrix with the desired size.
     *
     * @param dimension the desired size
     * @return a new identity matrix
     */
    public static Matrix getIdentityMatrix(final int dimension) {
        Matrix matrix = new Matrix(dimension);
        for (int i = 0; i < dimension; i++) {
            matrix.grid[i][i] = 1;
        }
        return matrix;
    }

    /**
     * Multiply the Matrix by a Tuple.
     *
     * @param tuple the Tuple
     * @return a new Tuple
     */
    public Tuple multiply(final Tuple tuple) {
        if (dimension != 4) {
            throw new IllegalArgumentException("Can only multiply with Tuple if dimension is 4");
        }
        double x = grid[0][0] * tuple.x + grid[0][1] * tuple.y + grid[0][2] * tuple.z + grid[0][3] * tuple.w;
        double y = grid[1][0] * tuple.x + grid[1][1] * tuple.y + grid[1][2] * tuple.z + grid[1][3] * tuple.w;
        double z = grid[2][0] * tuple.x + grid[2][1] * tuple.y + grid[2][2] * tuple.z + grid[2][3] * tuple.w;
        double w = grid[3][0] * tuple.x + grid[3][1] * tuple.y + grid[3][2] * tuple.z + grid[3][3] * tuple.w;
        return new Tuple(x, y, z, w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Matrix{" +
                "dimension=" + dimension +
                ",grid=\n" + printGrid() +
                '}';
    }

    /**
     * Return a String representation of the matrix.
     * @return a String representation of the matrix
     */
    public String printGrid() {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < dimension; r++) {
            builder.append(Arrays.toString(grid[r])).append('\n');
        }
        return builder.toString();
    }

    /**
     * Transpose the matrix.
     * @return the transposed matrix.
     */
    public Matrix transpose() {
        double[][] tempGrid = new double[dimension][dimension];
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                tempGrid[c][r] = grid[r][c];
            }
        }
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                grid[c][r] = tempGrid[c][r];
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) o;
        boolean result = dimension == matrix.dimension;
        if (result) {
            for (int r = 0; r < dimension; r++) {
                for (int c = 0; c < dimension; c++) {
                    result = abs(grid[r][c] - matrix.grid[r][c]) < 0.0001;
                    if (!result) {
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(grid);
        return result;
    }

    /**
     * Determine the determinant.
     * @return the determinant
     */
    public double determinant() {
        if (dimension == 2) {
            return (grid[0][0] * grid[1][1]) - (grid[0][1] * grid[1][0]);
        }
        double result = 0;
        for (int col = 0; col < dimension; col++) {
            result += grid[0][col] * cofactor(0, col);
        }
        return result;
    }

    /**
     * Find the submatrix given by removing the indicated row and column.
     * @param stripRow the column to remove
     * @param stripColumn the row to remove
     * @return the resulting submatrix
     */
    public Matrix subMatrix(final int stripRow, final int stripColumn) {
        Matrix result = new Matrix(dimension - 1);
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                double val = grid[r][c];
                if (r < stripRow) {
                    if (c < stripColumn) {
                        result.grid[r][c] = val;
                    } else {
                        if (c > stripColumn) {
                            result.grid[r][c - 1] = val;
                        }
                    }
                } else {
                    if (r > stripRow) {
                        if (c < stripColumn) {
                            result.grid[r - 1][c] = val;
                        } else {
                            if (c > stripColumn) {
                                result.grid[r - 1][c - 1] = val;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Determine the minor (determinant) of the submatrix given by removing the indicated row and column.
     * @param stripRow the column to remove
     * @param stripCol the row to remove
     * @return the minor
     */
    public double minor(final int stripRow, final int stripCol) {
        Matrix sub = subMatrix(stripRow, stripCol);
        return sub.determinant();
    }

    /**
     * Determine the cofactor of the submatrix given by removing the indicated row and column.
     * @param stripRow the column to remove
     * @param stripCol the row to remove
     * @return the cofactor
     */
    public double cofactor(final int stripRow, final int stripCol) {
        Matrix sub = subMatrix(stripRow, stripCol);
        double result = sub.determinant();
        if ((stripCol + stripRow) % 2 != 0) {
            result = -result;
        }
        return result;
    }

    /**
     * Determine whether the matrix can be inverted.
     * @return true if the matrix can be inverted
     */
    public boolean isInvertible() {
        return determinant() != 0;
    }

    /**
     * Determine the inverse of the matrix.
     * @return the inverted matrix
     */
    public Matrix inverse() {
        Matrix coFactors = new Matrix(dimension);
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                coFactors.grid[row][col] = cofactor(row, col);
            }
        }
        coFactors.transpose();
        double determinant = determinant();
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                coFactors.grid[row][col] /= determinant;
            }
        }
        this.grid = coFactors.grid;
        return this;
    }
}
