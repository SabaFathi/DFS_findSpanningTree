import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.LinkedList;

/**
 * draw input graph and result of DFS
 * using JavaFX
 *
 * @author SFathi
 */
public class VisualizedTest extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane1 = new Pane();

        DataTest dataTest = new DataTest();
        Graph inputGraph = dataTest.getInputGraph();
        addTree(inputGraph, pane1);

        Pane pane2 = new Pane();
        Graph result = new Graph();
        result.addVertex(inputGraph.getVertices().get(0));
        DFS.depthFirstSpanningTree(inputGraph, result,
                inputGraph.getVertices().get(0));
        addTree(result, pane2);

        VBox layout = new VBox(20);
        layout.getChildren().add(pane1);
        layout.getChildren().add(pane2);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * adding the graph to the pane
     *
     * @param graph the graph requesting to show,
     *              it should has coordinates otherwise it can not drawn!
     * @param root graph added to this pane.
     */
    private void addTree(Graph graph, Pane root){
        LinkedList<Vertex> vertices = graph.getVertices();

        try{
            vertices.get(0).getCoordinate().getX();
        }catch(NullPointerException ex){
            System.out.println("vertices have not coordinate," +
                    " so they can not drawn!");
        }

        for(Vertex vertex : vertices){
            Circle vertexCircle = new Circle(vertex.getCoordinate().x,
                    vertex.getCoordinate().y, 10);
            Label vertexLabel = new Label(vertex.getName());
            vertexLabel.setLayoutX(vertex.getCoordinate().x+5);
            vertexLabel.setLayoutY(vertex.getCoordinate().y+5);
            root.getChildren().add(vertexLabel);
            root.getChildren().add(vertexCircle);
        }

        graph.getEdges().forEach((key, values)->{
            for(Vertex vertex : values){
                Line vertexLine = new Line(
                        key.getCoordinate().x, key.getCoordinate().y,
                        vertex.getCoordinate().x, vertex.getCoordinate().y);
                root.getChildren().add(vertexLine);
            }
        });
    }
}
