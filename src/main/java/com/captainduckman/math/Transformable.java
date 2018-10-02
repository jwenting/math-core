package com.captainduckman.math;

/**
 * Represents something that can be transformed.
 *
 * @param <E> the type parameter
 */
public interface Transformable<E extends Transformable<E>> {
    /**
     * Translate a item according to a translation matrix
     * @param matrix the translation matrix
     * @return the moved item
     */
    E translate(TranslationMatrix matrix);

    /**
     * Rotate around the X axis.
     * @param matrix the rotation
     * @return the rotated item
     */
    E rotateX(RotationMatrixX matrix);

    /**
     * Rotate around the Y axis.
     * @param matrix the rotation
     * @return the rotated item
     */
    E rotateY(RotationMatrixY matrix);

    /**
     * Rotate around the Z axis.
     * @param matrix the rotation
     * @return the rotated item
     */
    E rotateZ(RotationMatrixZ matrix);

    /**
     * Scale.
     * @param matrix the scaling
     * @return the scaled item
     */
    E scale(ScalingMatrix matrix);

    /**
     * Shear.
     * @param matrix the shear
     * @return the sheared item
     */
    E shear(ShearingMatrix matrix);
}
