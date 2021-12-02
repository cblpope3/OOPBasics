package geometry;

import java.util.Arrays;

/**
 * Abstract class that extends {@link GenericGeometricFigure} and implements basic common methods
 * to work with 4-sided geometric figures. Quadrangle contains array of four vertexes of geometric figure
 * (array of {@link Dot} objects with length of 4) and array of four quadrangle sides (array of four {@link Line} objects).
 * It implements methods {@link #getPerimeter()} and {@link #getArea()} with basic functional.
 *
 * @see geometry.GenericGeometricFigure
 * @see Dot
 * @see Line
 */
public abstract class Quadrangle extends GenericGeometricFigure {

    protected Dot[] vertexArray = new Dot[4];
    protected Line[] sideArray = new Line[4];

    protected void setVertexArray(Dot[] newVertexArray) {
        this.vertexArray = newVertexArray;
        setSideArray();
    }

    protected void setSideArray() {
        sideArray[0] = new Line(vertexArray[0], vertexArray[1]);
        sideArray[1] = new Line(vertexArray[1], vertexArray[2]);
        sideArray[2] = new Line(vertexArray[2], vertexArray[3]);
        sideArray[3] = new Line(vertexArray[3], vertexArray[0]);
    }

    /**
     * Calculates perimeter of quadrangle by calculation length of each side using
     * {@link Line#getPerimeter()} method.
     *
     * @return perimeter (double)
     * @see Line#getPerimeter()
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
     * Calculates area of quadrangle.
     * Breaking quadrangle into two {@link Triangle} objects, calculating areas of triangles using method
     * {@link Triangle#getArea()} and returns sum of these areas.
     *
     * @return area (double)
     */
    @Override
    public double getArea() {
        //this method works with any 4-sided geometric figure, but not 100% precise. Better override if possible.
        Triangle triangle1 = new Triangle(vertexArray[0], vertexArray[1], vertexArray[2]);
        Triangle triangle2 = new Triangle(vertexArray[2], vertexArray[3], vertexArray[0]);

        return triangle1.getArea() + triangle2.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle that = (Quadrangle) o;
        return Arrays.equals(vertexArray, that.vertexArray) && Arrays.equals(sideArray, that.sideArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(vertexArray);
        result = 31 * result + Arrays.hashCode(sideArray);
        return result;
    }
}
