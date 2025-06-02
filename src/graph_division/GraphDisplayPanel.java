package graph_division; // Upewnij się, że jest w tym samym pakiecie

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D; // Zaimportuj klasę Line2D
import java.util.ArrayList;   // Zaimportuj ArrayList
import java.util.List;        // Zaimportuj List

class GraphDisplayPanel extends JPanel {
    // Lista do przechowywania wielu linii
    private final List<Line2D.Double> connectionLines = new ArrayList<>();

    public GraphDisplayPanel(LayoutManager layout) {
        super(layout);
    }

    // Metoda do dodawania nowej linii do listy
    public void addConnectionLine(int x1, int y1, int x2, int y2) {
        connectionLines.add(new Line2D.Double(x1, y1, x2, y2));
        repaint(); // przerysowuje, aby nowa linia była widoczna
    }

    // Metoda do czyszczenia wszystkich narysowanych linii
//    public void clearAllConnectionLines() {
//        connectionLines.clear();
//        repaint(); // przerysowuje, aby linie już nie były widoczne
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Najpierw rysuje tło i komponenty-dzieci (koła)

        Graphics2D g2d = (Graphics2D) g.create(); // Użyj kopii Graphics dla bezpieczeństwa
        g2d.setColor(Color.BLACK); // Kolor linii
        g2d.setStroke(new BasicStroke(1)); // szerokość linii

        // Iteruj po liście linii i rysuj każdą z nich
        for (Line2D.Double line : connectionLines) {
            g2d.draw(line);
        }

        g2d.dispose(); // Zwolnij zasoby kopii Graphics
    }
}