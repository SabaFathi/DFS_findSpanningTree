import java.awt.Point;

/**
 * it contains vertex's name, priority, seenState, coordinate
 *
 * @author SFathi
 */
public class Vertex {
    private String name;
    private int priority;
    private boolean isSeen = false;
    private Point coordinate;

    /**
     * constructor
     *
     * @param name name of the vertex
     * @param priority priority of the vertex
     */
    public Vertex(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    /**
     * set Coordinate of the vertex if needs visualization
     *
     * @param x
     * @param y
     */
    public void setCoordinate(int x, int y) {
        coordinate = new Point(x, y);
    }

    /**
     *
     * @return Point containing coordinate(x, y)
     */
    public Point getCoordinate() {
        return coordinate;
    }

    /**
     *
     * @return name of the vertex
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return priority of the vertex
     */
    public int getPriority() {
        return priority;
    }

    /**
     *
     * @return <code>true</code> if the vertex was seen
     * and <code>false</code> if was not.
     */
    public boolean isSeen() {
        return isSeen;
    }

    /**
     *
     * @param seen
     */
    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    /**
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = this.name.hashCode();
        hash *= 31;
        hash += this.priority * 37;

        return hash;
    }

    /**
     *
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if( this==obj ){
            return true;
        }
        if( obj==null ){
            return false;
        }
        if( ! (obj instanceof Vertex) ){
            return false;
        }
        if( ! this.name.equals(((Vertex)obj).name) ){
            return false;
        }
        if( this.priority != ((Vertex)obj).priority ){
            return false;
        }

        return true;
    }


    /**
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", isSeen=" + isSeen +
                '}' + '\n';
    }
}
