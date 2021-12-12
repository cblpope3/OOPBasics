package geometry;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 * This object extends {@link Quadrangle} and represents rectangle.
 * Rectangle is defined by four vertexes and four sides.
 * Horizontal rectangle can be constructed by defining its center point and side lengths {@link #Rectangle(Dot, double, double)}
 * or {@link #Rectangle(double, double, double, double)}.
 * In other way, any rectangle (even rotated) can be constructed by defining its three vertexes. To do so,
 * use {@link #Rectangle(Dot, Dot, Dot)}, or {@link #Rectangle(double, double, double, double, double, double)} constructor.
 * Methods {@link #getPerimeter()} and {@link #getArea()} returns perimeter and area of a rectangle.
 *
 * @see geometry.Quadrangle
 * @see geometry.Dot
 * @see geometry.Line
 */
public class Rectangle extends Quadrangle {

    private double sideLength1;
    private double sideLength2;
    private boolean isSideLengthDefined = false;

    /**
     * Creates {@link Rectangle} object by defining its center as a {@link Dot} and both sides length.
     *
     * @param center      Center of rectangle ({@link Dot} object)
     * @param sideLength1 Length of horizontal rectangle side (double)
     * @param sideLength2 Length of vertical rectangle side (double)
     */
    public Rectangle(Dot center, double sideLength1, double sideLength2) {

        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.isSideLengthDefined = true;

        center.movePoint(-sideLength1 / 2, -sideLength2 / 2);

        Dot[] newVertexArray = new Dot[4];
        newVertexArray[0] = center;
        newVertexArray[1] = new Dot(center.getX() + sideLength1, center.getY());
        newVertexArray[2] = new Dot(center.getX() + sideLength1, center.getY() + sideLength2);
        newVertexArray[3] = new Dot(center.getX(), center.getY() + sideLength2);

        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates {@link Rectangle} object by defining XY coordinates of its center and both sides length.
     *
     * @param centerX     X coordinate of center of rectangle (double)
     * @param centerY     Y coordinate of center of rectangle (double)
     * @param sideLength1 Length of horizontal rectangle side (double)
     * @param sideLength2 Length of vertical rectangle side (double)
     */
    public Rectangle(double centerX, double centerY, double sideLength1, double sideLength2) {
        this(new Dot(centerX, centerY), sideLength1, sideLength2);
    }

    /**
     * Creates {@link Rectangle} object by defining XY coordinates of its three first vertexes (A, B and C)
     *
     * @param xA x coordinate of vertex A of rectangle (double)
     * @param yA y coordinate of vertex A of rectangle (double)
     * @param xB x coordinate of vertex B of rectangle (double)
     * @param yB y coordinate of vertex B of rectangle (double)
     * @param xC x coordinate of vertex C of rectangle (double)
     * @param yC x coordinate of vertex C of rectangle (double)
     */
    public Rectangle(double xA, double yA, double xB, double yB, double xC, double yC) throws InputMismatchException {

        //TODO refactor this
        double xD;
        double yD;

        Dot[] newVertexArray = new Dot[4];

        //vertex A is middle one
        if ((xB - xA) * (xC - xA) + (yB - yA) * (yC - yA) == 0) {
            xD = xC + xB - xA;
            yD = yC + yB - yA;
            newVertexArray[0] = new Dot(xB, yB);
            newVertexArray[1] = new Dot(xA, yA);
            newVertexArray[2] = new Dot(xC, yC);
            newVertexArray[3] = new Dot(xD, yD);
        }
        //vertex B is middle
        else if ((xA - xB) * (xC - xB) + (yA - yB) * (yC - yB) == 0) {
            xD = xC + xA - xB;
            yD = yC + yA - yB;
            newVertexArray[0] = new Dot(xA, yA);
            newVertexArray[1] = new Dot(xB, yB);
            newVertexArray[2] = new Dot(xC, yC);
            newVertexArray[3] = new Dot(xD, yD);
        }
        //vertex C is middle
        else if ((xA - xC) * (xB - xC) + (yA - yC) * (yB - yC) == 0) {
            xD = xB + xA - xC;
            yD = yB + yA - yC;
            newVertexArray[0] = new Dot(xA, yA);
            newVertexArray[1] = new Dot(xC, yC);
            newVertexArray[2] = new Dot(xB, yB);
            newVertexArray[3] = new Dot(xD, yD);
        }
        //vertexes are positioned incorrect
        else {
            throw new InputMismatchException("Position of given vertexes is wrong!");
        }

        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates {@link Rectangle} object by defining its three first vertexes (A, B and C) as {@link Dot}.
     *
     * @param vertexA vertex A of rectangle ({@link Dot} object)
     * @param vertexB vertex B of rectangle ({@link Dot} object)
     * @param vertexC vertex C of rectangle ({@link Dot} object)
     */
    public Rectangle(Dot vertexA, Dot vertexB, Dot vertexC) {
        this(vertexA.getX(), vertexA.getY(), vertexB.getX(), vertexB.getY(), vertexC.getX(), vertexC.getY());
    }

    /**
     * Calculates perimeter of rectangle.
     * If rectangle is constructed using methods that directly defining sides length
     * ({@link #Rectangle(Dot, double, double)} or {@link #Rectangle(double, double, double, double)}), perimeter is calculated by more accurate formula.
     * Otherwise, perimeter is calculated by inherited universal method {@link Quadrangle#getPerimeter()}.
     *
     * @return perimeter (double)
     */
    @Override
    public double getPerimeter() {
        if (isSideLengthDefined) return (sideLength1 * 2) + (sideLength2 * 2);
        else return super.getPerimeter();
    }

    /**
     * Calculates area of rectangle.
     * If rectangle is constructed using methods that directly defining side length
     * ({@link #Rectangle(Dot, double, double)} or {@link #Rectangle(double, double, double, double)}), area is calculated by more precise formula.
     * Otherwise, area is calculated by inherited universal method {@link Quadrangle#getArea()}.
     *
     * @return perimeter (double)
     */
    @Override
    public double getArea() {
        if (isSideLengthDefined) return sideLength1 * sideLength2;
        else return super.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.sideLength1, sideLength1) == 0 && Double.compare(rectangle.sideLength2, sideLength2) == 0 && isSideLengthDefined == rectangle.isSideLengthDefined;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sideLength1, sideLength2, isSideLengthDefined);
    }

    @Override
    public String toString() {
        return "Rectangle: (" +
                "vertexes=" + Arrays.toString(vertexArray) +
                ", \nsides=" + Arrays.toString(sideArray) +
                ')';
    }
}
