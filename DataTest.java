/**
 * a sample graph to test the codes
 *
 * @author SFathi
 */
public class DataTest {
    private Graph inputGraph;
    private Vertex[] vertices = new Vertex[11];
    {
        for(int i=0 ; i<vertices.length ; i++){
            vertices[i] = new Vertex("a"+i, i+1);
        }
    }

    public DataTest() {
        inputGraph = new Graph();
        prepareVertices(inputGraph);
        prepareEdges(inputGraph);
        setCoordinates();
    }

    private void prepareVertices(Graph graph){
        for(int i=0 ; i<vertices.length ; i++){
            inputGraph.addVertex(vertices[i]);
        }
    }

    private void prepareEdges(Graph graph){
        inputGraph.addEdge(vertices[0], vertices[1]);
        inputGraph.addEdge(vertices[0], vertices[3]);
        inputGraph.addEdge(vertices[1], vertices[2]);
        inputGraph.addEdge(vertices[2], vertices[3]);
        inputGraph.addEdge(vertices[2], vertices[4]);
        inputGraph.addEdge(vertices[3], vertices[4]);
        inputGraph.addEdge(vertices[4], vertices[5]);
        inputGraph.addEdge(vertices[4], vertices[6]);
        inputGraph.addEdge(vertices[5], vertices[6]);
        inputGraph.addEdge(vertices[5], vertices[7]);
        inputGraph.addEdge(vertices[6], vertices[7]);
        inputGraph.addEdge(vertices[7], vertices[8]);
        inputGraph.addEdge(vertices[7], vertices[9]);
        inputGraph.addEdge(vertices[7], vertices[10]);
        inputGraph.addEdge(vertices[9], vertices[10]);
    }

    private void setCoordinates(){
        vertices[0].setCoordinate(50, 50);
        vertices[1].setCoordinate(50, 250);
        vertices[2].setCoordinate(250, 250);
        vertices[3].setCoordinate(250, 50);
        vertices[4].setCoordinate(450, 150);
        vertices[5].setCoordinate(650, 50);
        vertices[6].setCoordinate(650, 250);
        vertices[7].setCoordinate(850, 150);
        vertices[8].setCoordinate(850, 20);
        vertices[9].setCoordinate(1050, 50);
        vertices[10].setCoordinate(1050, 250);
    }

    public Graph getInputGraph() {
        return inputGraph;
    }
}
