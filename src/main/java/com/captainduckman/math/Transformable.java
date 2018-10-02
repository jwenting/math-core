package com.captainduckman.math;

public interface Transformable<E extends Transformable<E>> {
    E translate(TranslationMatrix matrix);

    E rotateX(RotationMatrixX matrix);

    E rotateY(RotationMatrixY matrix);

    E rotateZ(RotationMatrixZ matrix);

    E scale(ScalingMatrix matrix);

    E shear(ShearingMatrix matrix);
}
