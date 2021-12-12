package geometry;

/**
 * Abstract class declares basic methods {@link #getPerimeter()} and {@link #getArea()} for all geometric figures.
 * Also implements method {@link #getType()} that return object type as a {@link String}.
 */
public abstract class GenericGeometricFigure {

    protected final String type = this.getClass().getSimpleName().toLowerCase();

    public abstract double getPerimeter();

    public abstract double getArea();

    /**
     * @return Geometric figure type (String)
     */
    public String getType() {
        return type;
    }
}