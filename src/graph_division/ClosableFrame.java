package graph_division;

import connection_with_C.GraphDividerWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosableFrame extends JFrame {
    public ClosableFrame(String nazwa, String where) {
        super(nazwa);
        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dodaj WindowListener, aby przechwycić zdarzenia zamknięcia okna
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String str = "";
                boolean isBinary = false;
                if(where.equals("division")) {
                    str = DivisionMenu.p_amount_field.getText();
                    isBinary = DivisionMenu.tog_button_bin.getBackground().equals(new Color(53, 193, 232));
                }else if (where.equals("main")) {
                    str = MainMenu.p_amount_field.getText();
                    isBinary = MainMenu.tog_button_bin.getBackground().equals(new Color(53, 193, 232));
                }
                int parts_amount = 2;
                if(str != null && !str.isEmpty()) parts_amount = Integer.parseInt(str);
                GraphDividerWrapper.get_output_from_C(parts_amount, 10, isBinary);
            }
        });
        setVisible(true);
    }
}