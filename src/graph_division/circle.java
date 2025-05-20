package graph_division;

import javax.swing.*;
import java.awt.*;

class circle extends JPanel {

    private int circle_diameter;
    private Color circle_color = new Color(53, 193, 232);

    public circle(int diameter, Color color) {
        this.circle_color = color;
        this.circle_diameter = diameter;
    }

    public circle(int diameter) {
//        this.circle_color = new Color(53, 193, 232);
        this.circle_diameter = diameter;
    }

    // Domyślny konstruktor, jeśli chcesz mieć domyślną średnicę
    public circle() {
        this(100); // Wywołuje powyższy konstruktor z domyślną średnicą 100
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ważne, aby wywołać metodę klasy nadrzędnej!

        // Rysowanie wypełnionego koła
        // Ustawienie koloru rysowania
        g.setColor(this.circle_color);

        int x = 0;       // Współrzędna X lewego górnego rogu prostokąta opisującego koło
        int y = 0;       // Współrzędna Y lewego górnego rogu prostokąta opisującego koło

        g.fillOval(x, y, this.circle_diameter, this.circle_diameter); // Rysuje wypełnione koło

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(circle_diameter, circle_diameter); // Dostosuj rozmiar według potrzeb
    }
}