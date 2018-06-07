/**
 * implementation of Depth First Search Algorithm in Graphs
 * to find "Spanning Tree"
 *
 * @author SFathi
 */
public class DFS {

    /**
     *
     * @param inputGraph primary tree as input,
     *                  it can not be null otherwise this method do nothing!
     * @param resultGraph result tree as first input should be a tree
     *                    that just contain first vertex in "inputGraph"
     *                    and the method changes it with DFS algorithm
     *                    to be spanning tree,
     *                   it can not be null otherwise this method do nothing!
     * @param start start vertex which should be the first vertex of
     *              "inputGraph", it can not be null otherwise
     *              this method do nothing!
     */
    public static void depthFirstSpanningTree(final Graph inputGraph,
                                              Graph resultGraph, Vertex start){
        if( inputGraph ==null || start==null || resultGraph ==null ){
            return;
        }

        for(int i=start.getPriority(); i<inputGraph.getVertices().size(); i++){
            if(inputGraph.isEdgeBetween(start, inputGraph.getVertices().get(i))
                    && !inputGraph.getVertices().get(i).isSeen() ){
                Vertex vertex = inputGraph.getVertices().get(i);
                vertex.setSeen(true);
                resultGraph.addVertex(vertex);
                resultGraph.addEdge(start, vertex);
                vertex.setSeen(true);

                depthFirstSpanningTree(inputGraph, resultGraph, vertex);
            }
        }
    }
}
