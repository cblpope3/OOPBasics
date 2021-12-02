package geometry;

import java.util.Arrays;
import java.util.Objects;

/**
 * This object extends {@link Quadrangle} and represents square.
 * Square is defined by four vertexes and four sides.
 * Horizontal square can be constructed by defining its center point and side length {@link #Square(Dot, double)}, or
 * by defining XY coordinates of center point and side length {@link #Square(double, double, double)}.
 * In other way, any square (even rotated) can be constructed by defining its two opposite vertexes. To do so,
 * use {@link #Square(Dot, Dot)} or {@link #Square(double, double, double, double)} constructors.
 * Methods {@link #getPerimeter()} and {@link #getArea()} returns perimeter and area of a square.
 *
 * @see geometry.Quadrangle
 * @see geometry.Dot
 * @see geometry.Line
 */
public class Square extends Quadrangle {

    private double definedSideLength;
    private boolean isSideLengthDefined = false;

    /**
     * Creates horizontal {@link Square} object by defining its center as {@link Dot} object and side length.
     *
     * @param center     Center of square ({@link Dot} object)
     * @param sideLength Length of square sides (double)
     */
    public Square(Dot center, double sideLength) {

        isSideLengthDefined = true;
        definedSideLength = sideLength;

        center.movePoint(-sideLength / 2, -sideLength / 2);

        Dot[] newVertexArray = new Dot[4];

        newVertexArray[0] = center;
        newVertexArray[1] = new Dot(center.getX() + sideLength, center.getY());
        newVertexArray[2] = new Dot(center.getX() + sideLength, center.getY() + sideLength);
        newVertexArray[3] = new Dot(center.getX(), center.getY() + sideLength);

        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates horizontal {@link Square} object by defining its center point XY coordinates and side length.
     *
     * @param centerX    X coordinate of square center (double)
     * @param centerY    Y coordinate of square center (double)
     * @param sideLength Length of square sides (double)
     */
    public Square(double centerX, double centerY, double sideLength) {
        this(new Dot(centerX, centerY), sideLength);
    }

    /**
     * Creates {@link Square} object by defining XY coordinates of its starting vertex, and XY coordinates of
     * opposite (diagonal) vertex.
     *
     * @param xA x coordinate of first vertex of square (double)
     * @param yA y coordinate of first vertex of square (double)
     * @param xC x coordinate of opposite vertex of square (double)
     * @param yC x coordinate of opposite vertex of square (double)
     */
    public Square(double xA, double yA, double xC, double yC) {

        //first, find coordinates of center of square (xm, ym):
        double xCenter = (xA + xC) / 2;
        double yCenter = (yA + yC) / 2;

        //Then find remaining vertex coordinates
        double xB = xCenter + yCenter - yA;
        double yB = yCenter - xCenter + xA;
        double xD = xCenter - yCenter + yA;
        double yD = yCenter + xCenter - xA;

        Dot[] newVertexArray = new Dot[4];

        newVertexArray[0] = new Dot(xA, yA);
        newVertexArray[1] = new Dot(xB, yB);
        newVertexArray[2] = new Dot(xC, yC);
        newVertexArray[3] = new Dot(xD, yD);
        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates {@link Square} object by defining its starting vertex, and opposite (diagonal) vertexes
     * as {@link Dot} objects.
     *
     * @param vertexA first vertex of square ({@link Dot} object)
     * @param vertexC opposite vertex of square ({@link Dot} object)
     */
    public Square(Dot vertexA, Dot vertexC) {
        this(vertexA.getX(), vertexA.getY(), vertexC.getX(), vertexC.getY());
    }

    /**
     * Calculates perimeter of square.
     * If square is constructed using methods that directly defining side length
     * ({@link #Square(Dot, double)} or {@link #Square(double, double, double)}), perimeter is calculated by more accurate formula.
     * Otherwise, perimeter is calculated by inherited universal method {@link Quadrangle#getPerimeter()}.
     *
     * @return perimeter (double)
     */
    @Override
    public double getPerimeter() {
        if (isSideLengthDefined) return definedSideLength * 4;
        else return super.getPerimeter();
    }

    /**
     * Calculates area of square.
     * If square is constructed using methods that directly defining side length
     * ({@link #Square(Dot, double)} or {@link #Square(double, double, double)}), area is calculated by more precise formula.
     * Otherwise, area is calculated by inherited universal method {@link Quadrangle#getArea()}.
     *
     * @return perimeter (double)
     */
    @Override
    public double getArea() {
        if (isSideLengthDefined) return Math.pow(definedSideLength, 2);
        else return super.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Double.compare(square.definedSideLength, definedSideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), definedSideLength);
    }

    @Override
    public String toString() {
        return "Square: (" +
                "vertexes=" + Arrays.toString(vertexArray) +
                ", \nsides=" + Arrays.toString(sideArray) +
                ')';
    }
}
