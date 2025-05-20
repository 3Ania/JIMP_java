package graph_division;

import javax.swing.*;
import java.awt.*;

public class draw_graph {
    public draw_graph(String[] args) {
        JFrame frame = new JFrame("GraphDivider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[][] tablica = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1}
        };

        JPanel main_panel = new JPanel(new BorderLayout());

        JPanel graph_panel = new JPanel(new GridBagLayout());
        graph_panel.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);
        int diameter = 600/(tablica.length+1) - 30 - 9;

        JPanel backpanel = division_menu.create_back_panel(frame, args, 1);
        main_panel.add(backpanel, BorderLayout.NORTH);

        int number_on_node = 0;

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                if (tablica[i][j] == 1) {
                    c.gridx = j;
                    c.gridy = i;
                    graph_panel.add(new circle(diameter, String.valueOf(number_on_node)), c);
                    number_on_node++;
                }
            }
        }

        main_panel.add(graph_panel, BorderLayout.CENTER);

        frame.add(main_panel);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new draw_graph(args));
    }
}
