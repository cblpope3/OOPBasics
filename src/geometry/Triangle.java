package geometry;

import java.util.Arrays;

/**
 * This object extends {@link GenericGeometricFigure} and represents triangle.
 * Triangle is defined by three vertexes. This object can be constructed by defining three {@link Dot} objects
 * ({@link #Triangle(Dot, Dot, Dot)}) or by defining its vertexes XY coordinates ({@link #Triangle(double, double, double, double, double, double)}).
 * Methods {@link #getPerimeter()} and {@link #getArea()} returns perimeter and area of a triangle.
 *
 * @see geometry.GenericGeometricFigure
 * @see Dot
 * @see Line
 */
public class Triangle extends GenericGeometricFigure {

    private final Dot[] vertexArray = new Dot[3];
    private final Line[] sideArray = new Line[3];

    /**
     * Creates {@link Triangle} object by defining its vertexes
     *
     * @param vertex1 First vertex of triangle ({@link Dot} object)
     * @param vertex2 Second vertex of triangle ({@link Dot} object)
     * @param vertex3 Third vertex of triangle ({@link Dot} object)
     */
    public Triangle(Dot vertex1, Dot vertex2, Dot vertex3) {
        this.vertexArray[0] = vertex1;
        this.vertexArray[1] = vertex2;
        this.vertexArray[2] = vertex3;
        sideArray[0] = new Line(vertexArray[0], vertexArray[1]);
        sideArray[1] = new Line(vertexArray[1], vertexArray[2]);
        sideArray[2] = new Line(vertexArray[2], vertexArray[0]);
    }

    /**
     * Creates {@link Triangle} object by defining coordinates of its vertexes
     *
     * @param x1 X coordinate of vertex 1
     * @param y1 Y coordinate of vertex 1
     * @param x2 X coordinate of vertex 2
     * @param y2 Y coordinate of vertex 2
     * @param x3 X coordinate of vertex 3
     * @param y3 Y coordinate of vertex 3
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Dot(x1, y1), new Dot(x2, y2), new Dot(x3, y3));
    }

    /**
     * Calculates perimeter of triangle
     *
     * @return perimeter (double)
     */
    @Override
    public double getPerimeter() {
        double perimeter = 0d;
        for (Line side : sideArray) {
            perimeter += side.getPerimeter();
        }
        return perimeter;
    }

    /**
     * Calculates area of triangle by Heron's formula
     * https://www.britannica.com/science/Herons-formula
     *
     * @return area (double)
     */
    @Override
    public double getArea() {
        double sideA = this.sideArray[0].getPerimeter();
        double sideB = this.sideArray[1].getPerimeter();
        double sideC = this.sideArray[2].getPerimeter();
        double s = this.getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(vertexArray, triangle.vertexArray) && Arrays.equals(sideArray, triangle.sideArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(vertexArray);
        result = 31 * result + Arrays.hashCode(sideArray);
        return result;
    }

    @Override
    public String toString() {
        return "triangle: (" +
                "vertexes=" + Arrays.toString(vertexArray) +
                ", \nsides=" + Arrays.toString(sideArray) +
                ')';
    }
}
