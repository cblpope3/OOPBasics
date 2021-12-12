package geometry;

import java.util.Objects;

/**
 * This object extends {@link GenericGeometricFigure} and represents circle.
 * Center of circle defined by {@link Dot} object, radius defined by double.
 * Can be constructed by defining XY coordinates and radius ({@link #Circle(double, double, double)}) or
 * by defining center as {@link Dot} object and radius ({@link #Circle(Dot, double)}).
 * Methods {@link #getPerimeter()} and {@link #getArea()} returns ark length and area of circle.
 *
 * @see geometry.GenericGeometricFigure
 * @see Dot
 */
public class Circle extends GenericGeometricFigure {

    private final Dot center;
    private final double radius;

    /**
     * Creating {@link Circle} object by defining its center and radius
     *
     * @param center {@link Dot} object that represent center of circle
     * @param radius circle radius (double)
     */
    public Circle(Dot center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Creating {@link Circle} object by defining its center and radius
     *
     * @param centerX X coordinate center of circle
     * @param centerY Y coordinate center of circle
     * @param radius  circle radius (double)
     */
    public Circle(double centerX, double centerY, double radius) {
        this(new Dot(centerX, centerY), radius);
    }

    /**
     * Calculates length of circle arc
     *
     * @return length (double)
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates area of circle
     *
     * @return area (double)
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public String toString() {
        return "circle: (" +
                "center = " + center.toString() +
                ", radius = " + radius +
                ')';
    }
}
