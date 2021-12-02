package geometry;

import java.util.Objects;

/**
 * Dot object. Extends {@link GenericGeometricFigure} abstract class. Represents point on XY plane.
 * Can be created by defining X and Y coordinates ({@link #Dot(double, double)}).
 * To change position call method {@link #movePoint(double, double)}.
 * To calculate distance to other point call method {@link #calculateDistance(Dot)}.
 *
 * @see geometry.GenericGeometricFigure
 */
public class Dot extends GenericGeometricFigure {

    private double positionX;
    private double positionY;

    /**
     * Creates new {@link Dot} object with coordinates (x, y)
     *
     * @param x Coordinate X of this dot
     * @param y Coordinate Y of this dot
     */
    public Dot(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    /**
     * Returns x coordinate of point
     *
     * @return x coordinate of point (double)
     */
    public double getX() {
        return positionX;
    }

    /**
     * Returns y coordinate of point
     *
     * @return y coordinate of point (double)
     */
    public double getY() {
        return positionY;
    }

    /**
     * Move point from its position
     *
     * @param deltaX distance to move dot on X axis (double)
     * @param deltaY distance to move dot on Y axis (double)
     */
    public void movePoint(double deltaX, double deltaY) {
        this.positionX += deltaX;
        this.positionY += deltaY;
    }

    /**
     * Calculates perimeter of dot
     *
     * @return always zero (double)
     */
    @Override
    public double getPerimeter() {
        return 0d;
    }

    /**
     * Calculates area of dot
     *
     * @return always zero (double)
     */
    @Override
    public double getArea() {
        return 0d;
    }

    /**
     * Calculates distance between this point and another one. Not 100% accurate because of square root extraction.
     *
     * @param otherDot another {@link Dot} object
     * @return distance (double)
     */
    public double calculateDistance(Dot otherDot) {
        if (this.equals(otherDot)) return 0d;
        double distanceX = Math.abs(this.positionX - otherDot.positionX);
        double distanceY = Math.abs(this.positionY - otherDot.positionY);
        return Math.sqrt(Math.pow(distanceX, 2d) + Math.pow(distanceY, 2d));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Double.compare(dot.positionX, positionX) == 0 && Double.compare(dot.positionY, positionY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }

    @Override
    public String toString() {
        return "dot: (" +
                positionX + ", " + positionY + ')';
    }
}
