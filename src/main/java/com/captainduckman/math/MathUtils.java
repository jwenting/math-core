package com.captainduckman.math;

import static java.lang.Math.PI;
import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.sqrt;

/**
 * Utility methods and constants.
 * <p>
 * Save CPU time, don't calculate all those often used values every time you need them!
 */
public class MathUtils {
    /**
     * The standard precision for floating point comparisons and things like that.
     */
    public static final double PRECISION = 0.0001;
    /** PI/2. */
    public static final double HALF_PI;
    /** PI/4. */
    public static final double QUARTER_PI;
    /** Square root of 2. */
    public static final double SQRT2;
    /** Square root of 2 divided by 2. */
    public static final double HALF_SQRT2;

    static {
        HALF_PI = PI / 2;
        QUARTER_PI = PI / 4;
        SQRT2 = sqrt(2);
        HALF_SQRT2 = sqrt(2) / 2;
    }

    private MathUtils() {
        // nothing to see here, move along citizen
    }

    /**
     * Compare 2 floating point numbers with the standard precision.
     *
     * @param expected first number
     * @param actual second number
     * @return true if they are within precision of each other
     */
    public static boolean compare(final double expected, final double actual) {
        double diff = abs(expected - actual);
        return diff < PRECISION;
    }

    /**
     * Compare two doubles.
     *
     * @param d1 first
     * @param d2 second
     * @return 0 if the same, 1 if first larger, -1 if second larger
     */
    public static int compareTo(final double d1, final double d2) {
        double diff = abs(d1 - d2);
        if (diff < PRECISION) {
            return 0;
        }
        return d1 > d2 ? 1 : -1;
    }

}
