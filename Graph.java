import java.util.*;
import java.util.stream.Collectors;

/**
 * it contains vertices and edges of a Graph and useful methods
 *
 * @author SFathi
 */
public class Graph {
    private LinkedList<Vertex> vertices;
    private Map<Vertex, ArrayList<Vertex>> edges;

    /**
     * constructor
     *
     * @param vertices LikedList of tree's vertices.
     */
    public Graph(LinkedList<Vertex> vertices) {
        this();
        this.vertices = vertices;
    }

    /**
     * constructor
     *
     * no parameter leads to no vertices initialization.
     */
    public Graph(){
        this.vertices = new LinkedList<>();
        this.edges = new HashMap<>();
    }

    /**
     * constructor
     *
     * @param vertices Array of vertices which added to the tree in order.
     */
    public Graph(Vertex... vertices){
        this();

        for(Vertex vertex : vertices){
            this.vertices.add(vertex);
        }
    }

    /**
     * this method add the input vertex if it did not exist.
     *
     * @param vertex the vertex requesting to add
     */
    public void addVertex(Vertex vertex){
        if( !vertices.contains(vertex) ){
            vertices.add(vertex);
        }
    }

    /**
     * this method remove the input vertex ift it existed
     *
     * @param vertex the vertex requesting to remove
     */
    public void removeVertex(Vertex vertex){
        if( vertices.contains(vertex) ){
            vertices.remove(vertex);
        }
    }

    /**
     * adding edge between the two input vertices
     * if they existed in vertices list.
     *
     * @param vertex1
     * @param vertex2
     * @return <code>true</code> if input vertices were existed
     * and <code>false</code> if they were not.
     */
    public boolean addEdge(Vertex vertex1, Vertex vertex2){
        if( !(vertices.contains(vertex1) && vertices.contains(vertex2)) ){
            return false;
        }

        if( !edges.containsKey(vertex1) ){
            edges.put(vertex1, new ArrayList<>());
        }
        edges.get(vertex1).add(vertex2);

        if( !edges.containsKey(vertex2) ){
            edges.put(vertex2, new ArrayList<>());
        }
        edges.get(vertex2).add(vertex1);

        return true;
    }

    /**
     * removing the edge between two input vertices if existed.
     *
     * @param vertex1
     * @param vertex2
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2){
        if( !isVertexExist(vertex1) || !isVertexExist(vertex2) ){
            return;
        }

        if( edges.containsKey(vertex1) && edges.get(vertex1).contains(vertex2) ){
            edges.get(vertex1).remove(vertex2);
        }

        if( edges.containsKey(vertex2) && edges.get(vertex2).contains(vertex1) ){
            edges.get(vertex2).remove(vertex1);
        }
    }

    /**
     * check whether an edge is existed between two input vertices or not
     *
     * @param vertex1 a vertex requesting to check if has a common edge
     * @param vertex2 a vertex requesting to check if has a common edge
     * @return <code>true</code> if at least one vertex was existed
     * and also the edge was existed
     * and <code>false</code> if those conditions was not true.
     */
    public boolean isEdgeBetween(Vertex vertex1, Vertex vertex2){
        if( !isVertexExist(vertex1) || !isVertexExist(vertex2) ){
            return false;
        }
        if( edges.containsKey(vertex1) && edges.containsKey(vertex2) ){
            if( edges.get(vertex1).contains(vertex2) &&
                    edges.get(vertex2).contains(vertex1) ){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * check whether the input vertex is existed or not
     *
     * @param vertex the vertex requesting to check existence
     * @return <code>true</code> if the input vertex existed
     * and <code>false</code> if it did not.
     */
    final public boolean isVertexExist(Vertex vertex){
        if( vertices.contains(vertex) ){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return vertices : LinkedList<Vertex>
     */
    public LinkedList<Vertex> getVertices() {
        return vertices;
    }

    /**
     *
     * @return edges : Map<Vertex, ArrayList<Vertex>>
     */
    public Map<Vertex, ArrayList<Vertex>> getEdges() {
        return edges;
    }


    /**
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        List vertexStr = vertices.stream().map(v->v.toString())
                .collect(Collectors.toList());
        return "Graph{" + "\n" +
                "vertices=" + vertexStr.toString() + "\n" +
                ", edges=" + edges.values().toString() +
                '}';
    }
}
