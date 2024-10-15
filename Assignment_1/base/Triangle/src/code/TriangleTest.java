package code;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle(1, 1, 1);
    }

    @Test
    void testIsRight() {
        System.out.println("Testing isRight method");
        triangle = new Triangle(3, 4, 5);
        assertEquals(true, triangle.isRight());
    }

    @Test
    void testIsNotRight() {
        System.out.println("Testing isRight method for not right triangle");
        assertEquals(false, triangle.isRight());
    }

    @Test
    void testIsValid() {
        System.out.println("Testing isValid method");
        assertEquals(true, triangle.isValid());
    }

    @Test
    void testIsNotValid()
    {
        System.out.println("Testing isValid method for not valid triangle");
        triangle = new Triangle(0, 1, 1);
        assertEquals(false, triangle.isValid());
    }

    @Test
    void testCheckTypeEquilateral() {
        System.out.println("Testing CheckType method for Equilateral triangle");
        assertEquals(TriangleType.Equilateral, triangle.CheckType());
    }

    @Test
    void testCheckTypeIsosceles() {
        System.out.println("Testing CheckType method for Isosceles triangle");
        triangle = new Triangle(1, 2, 2);
        assertEquals(TriangleType.Isosceles, triangle.CheckType());
    }

    @Test
    void testCheckTypeScalene() {
        System.out.println("Testing CheckType method for Scalene triangle");
        triangle = new Triangle(3, 4, 5);
        assertEquals(TriangleType.Scalene, triangle.CheckType());
    }

    @Test
    void testCheckTypeInvalid() {
        System.out.println("Testing CheckType method for Invalid triangle");
        triangle = new Triangle(1, 2, 3);
        assertEquals(TriangleType.INVALID, triangle.CheckType());
    }
}
