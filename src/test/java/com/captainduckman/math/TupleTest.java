package com.captainduckman.math;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.captainduckman.math.Tuple.TYPE_POINT;
import static com.captainduckman.math.Tuple.TYPE_VECTOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tuple Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 12, 2018</pre>
 */
@DisplayName("Tuple Test")
class TupleTest extends AbstractMathTest {

    /**
     * Method: point(final double x, final double y, final double z)
     */
    @Test
    void testTuple() {
        Tuple point = Tuple.point(1.0, 2.0, 3.0);
        assertTrue(compare(TYPE_POINT, point.getW()));
        assertTrue(compare(1.0, point.getX()));
        assertTrue(compare(2.0, point.getY()));
        assertTrue(compare(3.0, point.getZ()));
    }

    @Test
    void testTuple2() {
        Tuple point = new Tuple(new Tuple(1.0, 2.0, 3.0, TYPE_POINT));
        assertTrue(compare(TYPE_POINT, point.getW()));
        assertTrue(compare(1.0, point.getX()));
        assertTrue(compare(2.0, point.getY()));
        assertTrue(compare(3.0, point.getZ()));
    }
    /**
     * Method: vector(final double x, final double y, final double z)
     */
    @Test
    void testVector() {
        Tuple tuple = Tuple.vector(1.0, 2.0, 3.0);
        assertTrue(compare(TYPE_VECTOR, tuple.getW()));
        assertTrue(compare(1.0, tuple.getX()));
        assertTrue(compare(2.0, tuple.getY()));
        assertTrue(compare(3.0, tuple.getZ()));
    }

    @Test
    void testSetters() {
        Tuple tuple = new Tuple(1.0, 2.0, 3.0, TYPE_VECTOR);
        assertTrue(compare(TYPE_VECTOR, tuple.getW()));
        assertTrue(compare(1.0, tuple.getX()));
        assertTrue(compare(2.0, tuple.getY()));
        assertTrue(compare(3.0, tuple.getZ()));

        tuple.setW(1.0);
        tuple.setX(1.5);
        tuple.setY(2.5);
        tuple.setZ(3.5);

        assertTrue(compare(1.0, tuple.getW()));
        assertTrue(compare(1.5, tuple.getX()));
        assertTrue(compare(2.5, tuple.getY()));
        assertTrue(compare(3.5, tuple.getZ()));
    }

    @Test
    void testNegate() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple result = tuple.negate();
        assertTrue(compare(4.0, result.getW()));
        assertTrue(compare(-1.0, result.getX()));
        assertTrue(compare(-2.0, result.getY()));
        assertTrue(compare(3.0, result.getZ()));
    }

    @Test
    void add() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple tuple2 = new Tuple(1.0, 2.0, -3.0, -4.0);

        Tuple result = tuple.add(tuple2);
        assertTrue(compare(2.0, result.getX()));
        assertTrue(compare(4.0, result.getY()));
        assertTrue(compare(-6.0, result.getZ()));
        assertTrue(compare(-8.0, result.getW()));
    }

    @Test
    void subtract() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple tuple2 = new Tuple(2.0, -4.0, 6.0, -4.0);

        Tuple result = tuple.subtract(tuple2);
        assertTrue(compare(-1.0, result.getX()));
        assertTrue(compare(6.0, result.getY()));
        assertTrue(compare(-9.0, result.getZ()));
        assertTrue(compare(0.0, result.getW()));
    }

    @Test
    void testToString() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        assertEquals("{x=1.0, y=2.0, z=-3.0, w=-4.0}", tuple.toString());
    }

    @Test
    void testEquals() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple tuple2 = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple tuple3 = new Tuple(2.0, 2.0, -3.0, -4.0);
        Tuple tuple4 = new Tuple(1.0, 2.0, 3.0, -4.0);
        Tuple tuple5 = new Tuple(2.0, 4.0, -3.0, -4.0);
        Tuple tuple6 = new Tuple(1.0, 2.0, -3.0, 4.0);

        assertEquals(tuple, tuple);
        assertEquals(tuple, tuple2);
        assertNotEquals(tuple, tuple3);
        assertNotEquals(tuple, tuple4);
        assertNotEquals(tuple, tuple5);
        assertNotEquals(tuple, tuple6);
        assertNotEquals(tuple, new Object());
        assertNotEquals(tuple, null);
    }

    @Test
    void testHashcode() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        assertEquals(Objects.hash(1.0, 2.0, -3.0, -4.0), tuple.hashCode());
    }

    @Test
    void multiply() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple result = tuple.multiply(2.0);
        assertTrue(compare(2.0, result.x));
        assertTrue(compare(4.0, result.y));
        assertTrue(compare(-6.0, result.z));
        assertTrue(compare(-8.0, result.w));
    }

    @Test
    void divide() {
        Tuple tuple = new Tuple(1.0, 2.0, -3.0, -4.0);
        Tuple result = tuple.divide(2.0);
        assertTrue(compare(0.5, result.x));
        assertTrue(compare(1.0, result.y));
        assertTrue(compare(-1.5, result.z));
        assertTrue(compare(-2.0, result.w));
    }

    @Test
    void magnitude() {
        Tuple vector = new Tuple(10.0, -6.0, 6.0, TYPE_VECTOR);
        double result = vector.magnitude();
        assertEquals(Math.sqrt(172), result);
    }

    @Test
    void normalise() {
        Tuple vector = new Tuple(4, 0, 0, TYPE_VECTOR);
        Tuple expected = new Tuple(1, 0, 0, TYPE_VECTOR);
        assertEquals(expected, vector.normalise());
        vector = new Tuple(1, 2, 3, TYPE_VECTOR);
        expected = new Tuple(0.2672612, 0.5345225, 0.8017837, TYPE_VECTOR);
        Tuple result = vector.normalise();
        assertEquals(expected, result);
        assertEquals(1.0, result.magnitude());
    }

    @Test
    void dot() {
        Tuple a = Tuple.vector(1, 2, 3);
        Tuple b = Tuple.vector(2, 3, 4);
        assertTrue(compare(20, a.dot(b)));
    }

    @Test
    void cross() {
        Tuple a = Tuple.vector(1, 2, 3);
        Tuple b = Tuple.vector(2, 3, 4);
        Tuple expected = Tuple.vector(-1, 2, -1);
        Tuple result = a.cross(b);
        assertEquals(expected, result);
        expected = Tuple.vector(1, -2, 1);
        a = Tuple.vector(1, 2, 3);
        b = Tuple.vector(2, 3, 4);
        result = b.cross(a);
        assertEquals(expected, result);
    }

    @Test
    void crossError() {
        Tuple a = Tuple.vector(1, 2, 3);
        Tuple b = new Tuple(2, 3, 4, 5);
        assertThrows(UnsupportedOperationException.class, () -> a.cross(b));
        a.w = 10;
        assertThrows(UnsupportedOperationException.class, () -> a.cross(b));
    }

    @Test
    void defaultConstructor() {
        Tuple tuple = new Tuple();
        assertTrue(compare(0, tuple.x));
        assertTrue(compare(0, tuple.y));
        assertTrue(compare(0, tuple.z));
        assertTrue(compare(0, tuple.w));
    }
}
