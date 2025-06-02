package graph_division;

import javax.swing.*;
import java.awt.*;

class Circle extends JPanel {

    private final int circle_diameter;
    private final Color circle_color;
    private final int stroke_size;
    private final String text_in_circle;

    public Circle(int diameter, Color color, String text, int str_size) {
        this.circle_color = color;
        this.circle_diameter = diameter;
        this.text_in_circle = text;
        this.stroke_size = str_size;
        setOpaque(false);
    }

//    public circle(int diameter, String text, int str_size) {
//        this.circle_color = new Color(53, 193, 232);
//        this.circle_diameter = diameter;
//        this.text_in_circle = text;
//        this.stroke_size = str_size;
//        setOpaque(false);
//    }

    // Domyślny konstruktor, jeśli chcesz mieć domyślną średnicę
//    public circle() {
//        this(100, ""); // Wywołuje powyższy konstruktor z domyślną średnicą 100
//        setOpaque(false);
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ważne, aby wywołać metodę klasy nadrzędnej!

//        // Ustaw kolor tła na biały
//        g.setColor(Color.WHITE);
//        // Wypełnij cały obszar panelu tym kolorem (tworząc "kwadrat za kołem")
//        g.fillRect(0, 0, getWidth(), getHeight());

        // Rysowanie wypełnionego koła
        // Ustawienie koloru rysowania
        g.setColor(this.circle_color);

        int x = stroke_size;       // Współrzędna X lewego górnego rogu prostokąta opisującego koło
        int y = stroke_size;       // Współrzędna Y lewego górnego rogu prostokąta opisującego koło

        g.fillOval(x, y, this.circle_diameter, this.circle_diameter); // Rysuje wypełnione koło

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(stroke_size));
        Color border_color = circle_color.darker();
        g.setColor(border_color);
        g.drawOval(x, y, this.circle_diameter, this.circle_diameter);

        if (this.text_in_circle != null && !this.text_in_circle.isEmpty()) {
            g2d.setColor(Color.BLACK); // Kolor tekstu (możesz dostosować)

            // Ustawienie fontu (opcjonalne, możesz dostosować rozmiar i styl)
            // Rozmiar fontu można uzależnić od średnicy koła
            int fontSize = Math.max(10, circle_diameter / 3); // Prosta heurystyka
            Font font = new Font("Inter", Font.PLAIN, fontSize);
            g2d.setFont(font);

            // Pobranie metryk fontu, aby wycentrować tekst
            FontMetrics metrics = g2d.getFontMetrics(font);
            int textWidth = metrics.stringWidth(this.text_in_circle);
            int textHeight = metrics.getHeight();
            int textAscent = metrics.getAscent();

            // Obliczenie pozycji tekstu, aby był na środku
            int textX = x + (circle_diameter - textWidth) / 2;
            int textY = y + (circle_diameter - textHeight) / 2 + textAscent;

            g2d.drawString(this.text_in_circle, textX, textY);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(circle_diameter+(2*stroke_size), circle_diameter+(2*stroke_size)); // Dostosuj rozmiar według potrzeb
    }
}