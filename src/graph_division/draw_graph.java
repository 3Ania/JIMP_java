package graph_division;

import javax.swing.*;
import java.awt.*;

public class draw_graph {
    public draw_graph() {
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

        JPanel main_panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);
        int diameter = 600/(tablica.length+1) - 30;

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                if (tablica[i][j] == 1) {
                    c.gridx = j;
                    c.gridy = i;
                    main_panel.add(new circle(diameter), c);
                }
            }
        }

        frame.add(main_panel);

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {

            }
        }

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new draw_graph();
            }
        });
    }
}
