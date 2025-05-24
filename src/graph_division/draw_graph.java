package graph_division;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class draw_graph {

    final List<circle> circleComponents = new ArrayList<>();
    Color blue = new Color(53, 193, 232);

    public draw_graph(String[] args, Graph graph) {
        JFrame frame = new JFrame("GraphDivider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        Random random = new Random();

        Color[] colors = {new Color(239, 77, 37), new Color(245, 131, 25), new Color(255, 215, 15), new Color(60, 215, 143), new Color(78, 177, 202), new Color(79, 65, 185)};
        int colors_amount = 6;

        JPanel main_panel = new JPanel(new BorderLayout());

        GraphDisplayPanel graph_panel = new GraphDisplayPanel(new GridBagLayout());
        graph_panel.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);
        int diameter = 600 / (graph.placing.length + 1) - 30 - 9;
        int stroke_size = 3;

        JPanel backpanel = division_menu.create_back_panel(frame, args, 1, graph);
        main_panel.add(backpanel, BorderLayout.NORTH);

        circle new_circle;

        int number_on_node = 0;
        Color current_color = blue;

        for (int i = 0; i < graph.placing.length; i++) {
            for (int j = 0; j < graph.placing[i].length; j++) {
                if (graph.placing[i][j] == 1) {
                    c.gridx = j;
                    c.gridy = i;
                    for(int k = 0; k < graph.parts.length; k++) {
                        for(int l = 0; l < graph.parts[k].length; l++) {
                            if(graph.parts[k][l] == number_on_node) {
                                if(k < colors_amount){
                                    current_color = colors[k];
                                }else{
                                    current_color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                                }
                            }
                        }
                    }
                    new_circle = new circle(diameter, current_color, String.valueOf(number_on_node), stroke_size);
                    graph_panel.add(new_circle, c);
                    number_on_node++;
                    circleComponents.add(new_circle);
                }
            }
        }

        main_panel.add(graph_panel, BorderLayout.CENTER);

        frame.add(main_panel);

        frame.setVisible(true);

        List<Integer> circleX = new ArrayList<>();
        List<Integer> circleY = new ArrayList<>();

        for (circle cir : circleComponents) {
            int x = cir.getX() + stroke_size;
            int y = cir.getY() + stroke_size;

            int middleX = x + (diameter / 2);
            int middleY = y + (diameter / 2);

            circleX.add(middleX);
            circleY.add(middleY);
        }


        for (int i = 0; i < graph.connections.length; i++) {
            for (int j = 0; j < graph.connections[i].length; j++) {
                graph_panel.addConnectionLine(circleX.get(i), circleY.get(i), circleX.get(graph.connections[i][j]), circleY.get(graph.connections[i][j]));
            }
        }

        graph_panel.repaint();
    }

    public static void main(String[] args, Graph graph) {
        SwingUtilities.invokeLater(() -> new draw_graph(args, graph));
    }
}
