package geometry;

import java.util.Objects;

/**
 * Object extends {@link GenericGeometricFigure} and represents line. Contains two points (start point and end point).
 * Line can be created by defining two points ({@link #Line(Dot, Dot)}) or coordinates of start and end ({@link #Line(double, double, double, double)}).
 * To get center of line call method {@link #getCenter()}. To check is other line in parallel with this one,
 * call method {@link #isParallelToLine(Line)}.
 *
 * @see GenericGeometricFigure
 * @see Dot
 */
public class Line extends GenericGeometricFigure {

    private final Dot lineStart;
    private final Dot lineEnd;

    /**
     * Creating new {@link Line} object by defining start and end points
     *
     * @param start Start of line ({@link Dot} object)
     * @param end   End of line ({@link Dot} object)
     */
    public Line(Dot start, Dot end) {
        this.lineStart = start;
        this.lineEnd = end;
    }

    /**
     * Creating new {@link Line} object by defining start and end points coordinates
     *
     * @param startX Line start X coordinate
     * @param startY Line start Y coordinate
     * @param endX   Line end X coordinate
     * @param endY   Line end Y coordinate
     */
    public Line(double startX, double startY, double endX, double endY) {
        this(new Dot(startX, startY), new Dot(endX, endY));
    }

    public Dot getLineStart() {
        return lineStart;
    }

    public Dot getLineEnd() {
        return lineEnd;
    }

    /**
     * Returns center point of the line
     *
     * @return center point of line ({@link Dot} object)
     */
    public Dot getCenter() {
        double centerX = (this.lineStart.getX() + this.lineEnd.getX()) / 2;
        double centerY = (this.lineStart.getY() + this.lineEnd.getY()) / 2;
        return new Dot(centerX, centerY);
    }

    /**
     * Checks if other line is parallel to this one
     *
     * @param otherLine other line ({@link Line} object)
     * @return true if lines are parallel (boolean)
     */
    public boolean isParallelToLine(Line otherLine) {
        double slope1 = (this.lineStart.getX() - this.lineEnd.getX()) / (this.lineStart.getY() - this.lineEnd.getY());
        double slope2 = (otherLine.lineStart.getX() - otherLine.lineEnd.getX()) / (otherLine.lineStart.getY() - otherLine.lineEnd.getY());

        return slope1 == slope2;
    }

    /**
     * Calculates length of line. Not 100% accurate because of using method {@link Dot#calculateDistance(Dot)}.
     *
     * @return length (double)
     */
    @Override
    public double getPerimeter() {
        return lineStart.calculateDistance(lineEnd);
    }

    /**
     * Calculates area of line
     *
     * @return always zero (double)
     */
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lineStart, line.lineStart) && Objects.equals(lineEnd, line.lineEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineStart, lineEnd);
    }

    @Override
    public String toString() {
        return "line: (from " + lineStart +
                ", to " + lineEnd + ')';
    }
}
