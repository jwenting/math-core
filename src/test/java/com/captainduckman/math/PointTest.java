package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest extends AbstractMathTest {

    @Test
    void add() {
        Vector vector = new Vector(1, 2, 3);
        Point point = new Point(1, 2, 3);
        Point result = point.add(vector);
        Point expected = new Point(2, 4, 6);
        assertEquals(expected, result);
    }

    @Test
    void create() {
        Point p = new Point(1, 2, 3);
        Point result = new Point(p);
        assertEquals(p, result);
    }

    @Test
    void subtract() {
        Vector vector = new Vector(2, 3, 4);
        Point point = new Point(1, 2, 3);
        Point result = point.subtract(vector);
        Point expected = new Point(-1, -1, -1);
        assertEquals(expected, result);
    }

    @Test
    void subtract1() {
        Point point = new Point(1, 2, 3);
        Point point2 = new Point(4, 3, 6);
        Vector result = point.subtract(point2);
        Vector expected = new Vector(-3, -1, -3);
        assertEquals(expected, result);
    }

    @Test
    void getSetX() {
        Point point = new Point(3, 6, 9);
        assertEquals(point.tuple.x, point.getX());
        point.setX(4.5);
        assertEquals(point.tuple.x, point.getX());
        assertEquals(4.5, point.getX(), .0001);
    }

    @Test
    void getSetY() {
        Point point = new Point(3, 6, 9);
        assertEquals(point.tuple.y, point.getY());
        point.setY(4.5);
        assertEquals(point.tuple.y, point.getY());
        assertEquals(4.5, point.getY(), .0001);
    }

    @Test
    void getSetZ() {
        Point point = new Point(3, 6, 9);
        assertEquals(point.tuple.z, point.getZ());
        point.setZ(4.5);
        assertEquals(point.tuple.z, point.getZ());
        assertEquals(4.5, point.getZ(), .0001);
    }

    @Test
    void equals() {
        Point point = new Point(3, 6, 9);
        Point point1 = new Point(3, 6, 9);
        Point point2 = new Point(4, 2, -2);

        assertEquals(point, point);
        assertEquals(point, point1);
        assertNotEquals(point, point2);
        assertNotEquals(point, new OutOfMemoryError());
        assertNotEquals(point, null);
    }

    @Test
    void testHashCode() {
        Point point = new Point(3, 6, 9);
        assertEquals(point.tuple.hashCode(), point.hashCode());
    }

    @Test
    void testToString() {
        Point point = new Point(3, 6, 9);
        assertTrue(point.toString().startsWith("Point{tuple"));
    }

    @Test
    void transform() {
        Point point = new Point(1, 1, 1);
        Tuple tuple = new Tuple(1, 1, 1, 1);
        AbstractMutationMatrix mutationMatrix = new MockMutationMatrix();
        point.transform(mutationMatrix);
        Tuple expected = mutationMatrix.matrix.multiply(tuple);
        assertEquals(expected, point.tuple);
    }

}