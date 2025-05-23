import graph_division.Graph;
import graph_division.division_menu;
//import graph_division.draw_graph;

//import javax.swing.*;

public class Main {
    private static Graph set_graph_elements(Graph graph){
        graph.placing = new int[][]{
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1}
        };
        graph.parts = new int[][]{
                {0, 2, 5},
                {1, 3, 4},
                {7, 8, 9},
                {6, 10, 11}
        };
        graph.connections = new int[][]{
                {2, 5},
                {3, 4},
                {0, 5},
                {1},
                {1},
                {0, 2},
                {10, 11},
                {9},
                {9},
                {7, 8},
                {6},
                {6}
        };
        return graph;
    }
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph = set_graph_elements(graph);
        division_menu.main(args, graph);
    }
}
