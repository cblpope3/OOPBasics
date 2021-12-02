package geometry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * This object extends {@link Quadrangle} and represents parallelogram.
 * Parallelogram is defined by four vertexes and four sides.
 * Horizontal parallelogram can be constructed by defining its starting vertex, length of horizontal side, altitude and
 * shift ({@link #Parallelogram(Dot, double, double, double)}.
 * In other way, any parallelogram (even rotated) can be constructed by defining its two diagonals ({@link #Parallelogram(Line, Line)}),
 * or by defining its four vertexes ({@link #Parallelogram(List)}).
 * Methods {@link #getPerimeter()} and {@link #getArea()} returns perimeter and area of a parallelogram.
 *
 * @see geometry.Quadrangle
 * @see geometry.Dot
 * @see geometry.Line
 */
public class Parallelogram extends Quadrangle {

    /**
     * Creates horizontal 'Parallelogram' object by defining its starting vertex (A), length of its horizontal side(AB), it's altitude(h),
     * and it's shift (AL). Watch <a href='https://www.emathzone.com/wp-content/uploads/2015/01/parallelogram-01.gif'>this</a>
     * picture for better understanding.
     *
     * @param startVertex    Starting vertex of parallelogram ({@link Dot} object)
     * @param horizontalSide Length of horizontal parallelogram side (double)
     * @param altitude       Length of parallelogram's altitude (double)
     * @param shift          Length of parallelogram's shift (double)
     * @see Dot
     */
    public Parallelogram(Dot startVertex, double horizontalSide, double altitude, double shift) {
        Dot[] newVertexArray = new Dot[4];
        newVertexArray[0] = startVertex;
        newVertexArray[1] = new Dot(startVertex.getX() + horizontalSide, startVertex.getY());
        newVertexArray[2] = new Dot(newVertexArray[1].getX() + shift, newVertexArray[1].getY() + altitude);
        newVertexArray[3] = new Dot(newVertexArray[2].getX() - horizontalSide, newVertexArray[2].getY());

        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates 'Parallelogram' object by defining its diagonals.
     * Diagonals must intersect in their centers and not be in parallel.
     *
     * @param diagonal1 First diagonal of parallelogram ({@link Line} object)
     * @param diagonal2 Second diagonal of parallelogram ({@link Line} object)
     * @throws IllegalArgumentException If diagonals position is incorrect
     * @see Line
     */
    public Parallelogram(Line diagonal1, Line diagonal2) throws IllegalArgumentException {

        if (areDiagonalsNotValid(diagonal1, diagonal2))
            throw new IllegalArgumentException("Given lines are not valid diagonals!");

        Dot[] newVertexArray = new Dot[4];
        newVertexArray[0] = diagonal1.getLineStart();
        newVertexArray[1] = diagonal2.getLineStart();
        newVertexArray[2] = diagonal1.getLineEnd();
        newVertexArray[3] = diagonal2.getLineEnd();

        this.setVertexArray(newVertexArray);
    }

    /**
     * Creates 'Parallelogram' object by defining its vertexes.
     *
     * @param vertexList List of parallelogram vertexes (List of {@link Dot} objects)
     * @throws IllegalArgumentException is thrown if parallelogram can't be constructed of given vertexes
     * @see Dot
     * @see List
     */
    public Parallelogram(List<Dot> vertexList) throws IllegalArgumentException {

        if (vertexList.size() != 4) throw new IllegalArgumentException("Input array size must be 4.");

        //calculating distances between each pair of dots
        TreeMap<Double, Integer[]> distanceMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < vertexList.size(); i++) {
            for (int j = i + 1; j < vertexList.size(); j++) {
                distanceMap.put(vertexList.get(i).calculateDistance(vertexList.get(j)), new Integer[]{i, j});
            }
        }

        //first diagonal is the longest line
        int diagonalDotIndex1 = distanceMap.firstEntry().getValue()[0];
        int diagonalDotIndex2 = distanceMap.firstEntry().getValue()[1];

        Line diagonal1 = new Line(vertexList.get(diagonalDotIndex1), vertexList.get(diagonalDotIndex2));

        //second diagonal should be composed of remaining vertexes
        vertexList.remove(diagonal1.getLineStart());
        vertexList.remove(diagonal1.getLineEnd());

        Line diagonal2 = new Line(vertexList.get(0), vertexList.get(1));

        //checking that diagonals are correct
        if (areDiagonalsNotValid(diagonal1, diagonal2))
            throw new IllegalArgumentException("Cannot construct parallelogram from given dots");

        Dot[] newVertexArray = new Dot[4];
        newVertexArray[0] = diagonal1.getLineStart();
        newVertexArray[1] = diagonal2.getLineStart();
        newVertexArray[2] = diagonal1.getLineEnd();
        newVertexArray[3] = diagonal2.getLineEnd();

        this.setVertexArray(newVertexArray);
    }

    /**
     * method return false if given lines are valid diagonals of parallelogram
     */
    private boolean areDiagonalsNotValid(Line diagonal1, Line diagonal2) {
        //check if lines are parallel
        boolean areParallel = diagonal1.isParallelToLine(diagonal2);
        //check if line centers in same point
        boolean validIntersect = diagonal1.getCenter().equals(diagonal2.getCenter());

        return areParallel || !validIntersect;
    }

    @Override
    public String toString() {
        return "Parallelogram: (" +
                "vertexes=" + Arrays.toString(vertexArray) +
                ", \nsides=" + Arrays.toString(sideArray) +
                ')';
    }
}
