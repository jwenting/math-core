package com.captainduckman.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Vector Test")
class VectorTest extends AbstractMathTest {

    @Test
    void add() {
        Vector vector = new Vector(1, 2, 3);
        Point point = new Point(1, 2, 3);
        Point result = vector.add(point);
        Point expected = new Point(2, 4, 6);
        assertEquals(expected, result);
    }

    @Test
    void create() {
        Vector vector = new Vector(1, 2, 3);
        Point point = new Point(1, 2, 3);

        Vector result = new Vector(vector);
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(3, result.getZ());
        result = new Vector(point);
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(3, result.getZ());
    }

    @Test
    void addVector() {
        Vector vector = new Vector(1, 2, 3);
        Vector add = new Vector(1, 2, 3);
        Vector result = vector.add(add);
        Vector expected = new Vector(2, 4, 6);
        assertEquals(expected, result);

    }

    @Test
    void subtract() {
        Vector vector = new Vector(3, 6, 9);
        Vector sub = new Vector(1, 2, 3);
        Vector result = vector.subtract(sub);
        Vector expected = new Vector(2, 4, 6);
        assertEquals(expected, result);
    }

    @Test
    void negate() {
        Vector vector = new Vector(3, 6, 9);
        vector.negate();
        Vector expected = new Vector(-3, -6, -9);
        assertEquals(expected, vector);

    }

    @Test
    void multiply() {
        Vector vector = new Vector(3, 6, 9);
        vector.multiply(2);
        Vector expected = new Vector(6, 12, 18);
        assertEquals(expected, vector);
    }

    @Test
    void divide() {
        Vector vector = new Vector(3, 6, 9);
        vector.divide(2);
        Vector expected = new Vector(1.5, 3, 4.5);
        assertEquals(expected, vector);
    }

    @Test
    void normalise() {
        Vector vector = new Vector(3, 6, 9);
        vector.normalise();
        Vector expected = new Vector(.2673, .5345, .8018);
        assertEquals(expected, vector);
    }

    @Test
    void dot() {
        Vector vector = new Vector(3, 6, 9);
        Vector vector2 = new Vector(4, 2, -2);
        double result = vector.dot(vector2);
        assertEquals(result, 6, .0001);
    }

    @Test
    void dot2() {
        Vector vector = new Vector(0, 0, 1);
        Vector vector2 = new Vector(0, 0, -5);
        double result = vector.dot(vector2);
        assertEquals(result, -5, .0001);
    }

    @Test
    void cross() {
        Vector vector = new Vector(3, 6, 9);
        Vector vector2 = new Vector(4, 2, -2);
        Vector result = vector.cross(vector2);
        Vector expected = new Vector(-30, 42, -18);
        assertEquals(expected, result);
        Vector result2 = vector2.cross(vector);
        Vector expected2 = new Vector(30, -42, 18);
        assertEquals(expected2, result2);
        // crossing itself should yield null vector
        Vector result3 = vector.cross(vector);
        Vector expected3 = new Vector(0, 0, 0);
        assertEquals(expected3, result3);
    }

    @Test
    void equals() {
        Vector vector = new Vector(3, 6, 9);
        Vector vector2 = new Vector(3, 6, 9);
        Vector vector3 = new Vector(4, 2, -2);

        assertEquals(vector, vector);
        assertEquals(vector, vector2);
        assertNotEquals(vector, vector3);
        assertNotEquals(vector, new OutOfMemoryError());
        assertNotEquals(vector, null);
    }

    @Test
    void testHashCode() {
        Vector vector = new Vector(3, 6, 9);
        assertEquals(vector.tuple.hashCode(), vector.hashCode());
    }

    @Test
    void testToString() {
        Vector vector = new Vector(3, 6, 9);
        assertTrue(vector.toString().startsWith("Vector{tuple"));
    }

    @Test
    void getSetX() {
        Vector vector = new Vector(3, 6, 9);
        assertEquals(vector.tuple.x, vector.getX());
        vector.setX(4.5);
        assertEquals(vector.tuple.x, vector.getX());
        assertEquals(4.5, vector.getX(), .0001);
    }

    @Test
    void getSetY() {
        Vector vector = new Vector(3, 6, 9);
        assertEquals(vector.tuple.y, vector.getY());
        vector.setY(4.5);
        assertEquals(vector.tuple.y, vector.getY());
        assertEquals(4.5, vector.getY(), .0001);
    }

    @Test
    void getSetZ() {
        Vector vector = new Vector(3, 6, 9);
        assertEquals(vector.tuple.z, vector.getZ());
        vector.setZ(4.5);
        assertEquals(vector.tuple.z, vector.getZ());
        assertEquals(4.5, vector.getZ(), .0001);
    }

    @Test
    void subtract2() {
        Vector vector = new Vector(3, 6, 9);
        Point sub = new Point(1, 2, 3);
        Vector result = vector.subtract(sub);
        Vector expected = new Vector(2, 4, 6);
        assertEquals(expected, result);
    }

    @Test
    void dot42() {
        Vector vector = new Vector(1, 1, 1);
        System.out.println(vector.dot(vector));

        vector = new Vector(2.54, 2.54, 2.54);
        System.out.println(vector.dot(vector));
    }

    @Test
    void transform() {
        Vector vector = new Vector(1, 1, 1);
        Tuple tuple = new Tuple(1, 1, 1, 0);
        AbstractMutationMatrix mutationMatrix = new MockMutationMatrix();
        vector.transform(mutationMatrix);
        Tuple expected = mutationMatrix.matrix.multiply(tuple);
        assertEquals(expected, vector.tuple);
    }

    @Test
    @DisplayName("magnitude")
    void magnitude() {
        Vector vector = new Vector(-20, 20, -10);
        double val = vector.magnitude();
        assertEquals(30, val, 0.0001);
    }

    @Test
    @DisplayName("reflect")
    void reflect() {
        Vector vector = new Vector(-20, 20, -10);
        Vector vector2 = new Vector(.1, .1, .1);
        vector.reflect(vector2);
        assertEquals(new Vector(-19.8, 20.2, -9.8), vector);
    }
}