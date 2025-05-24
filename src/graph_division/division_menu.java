package graph_division;

import connection_with_C.GraphDividerWrapper;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;



public class division_menu {
    Color blue = new Color(53, 193, 232);
    Color gray = new Color(180,180,180);

    JButton tog_button_text = new JButton(" ");
    JButton tog_button_bin = new JButton(" ");

    JTextField p_amount_field = new JTextField();
    JTextField margin_field = new JTextField();

    public static JPanel create_back_panel(JFrame frame, String[] args, int where_to, Graph graph){
        JPanel back_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back_panel.setBackground(Color.WHITE);
        JButton back = new JButton("Powrót");
        back.setFont(new Font("Inter", Font.PLAIN, 20));
        back.setBackground(new Color(180,180,180));
        back_panel.add(back);
        back_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, back.getPreferredSize().height));
        back.addActionListener(_ -> {
                frame.dispose();
                if(where_to == 1){
                    division_menu.main(args, graph);
                }
        });
        return back_panel;
    }

    private void add_caption(JPanel main_panel){
        JLabel caption = new JLabel("Podział grafu");
        caption.setFont(new Font("Inter", Font.BOLD, 50));
        caption.setForeground(blue);
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);
        main_panel.add(caption);
    }

    private void add_buttons(JPanel main_panel, JFrame frame, String[] args, Graph graph){
        JButton show_graphs = new JButton("Wyświetl grafy po podziale");
        show_graphs.setFont(new Font("Inter", Font.PLAIN, 30));
        show_graphs.setBackground(gray);
        show_graphs.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension targetSize = show_graphs.getPreferredSize();
        targetSize.width += 10;
        show_graphs.setPreferredSize(targetSize);
        show_graphs.setMaximumSize(new Dimension(targetSize.width, targetSize.height));

        show_graphs.addActionListener(_ -> {
                frame.dispose();
                draw_graph.main(args, graph);
        });

        JButton divide = new JButton("Podziel graf");
        divide.setFont(new Font("Inter", Font.PLAIN, 30));
        divide.setBackground(gray);
        divide.setPreferredSize(targetSize);
        divide.setMaximumSize(new Dimension(targetSize.width, targetSize.height));
        divide.setAlignmentX(Component.CENTER_ALIGNMENT);

        divide.addActionListener(_ -> {
            int parts_amount = 2;
            int margin = 10;
            if(!p_amount_field.getText().isEmpty()){
                parts_amount = Integer.parseInt(p_amount_field.getText());
            }
            if(!margin_field.getText().isEmpty()){
                margin = Integer.parseInt(margin_field.getText());
            }
            GraphDividerWrapper.main(args, parts_amount, margin);
            fill_Graph_with_output.main(args, parts_amount, graph);
        });

        JButton save_graphs = new JButton("Zapisz grafy po podziale");
        save_graphs.setFont(new Font("Inter", Font.PLAIN, 30));
        save_graphs.setBackground(gray);
        save_graphs.setPreferredSize(targetSize);
        save_graphs.setMaximumSize(new Dimension(targetSize.width, targetSize.height));
        save_graphs.setAlignmentX(Component.CENTER_ALIGNMENT);

        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(divide);
        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(show_graphs);
        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(save_graphs);
    }

    private void create_toggle_panel(JPanel main_panel){
        JLabel format = new JLabel("Format");
        format.setFont(new Font("Inter", Font.PLAIN, 25));
        format.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel toggle_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        toggle_panel.setBackground(Color.WHITE);

        tog_button_text.setFont(new Font("Inter", Font.PLAIN, 10));
        tog_button_text.setBackground(gray);

        tog_button_bin.setFont(new Font("Inter", Font.PLAIN, 10));
        tog_button_bin.setBackground(gray);

        tog_button_text.addActionListener(_ -> {
                if (!tog_button_text.getBackground().equals(blue)) {
                    tog_button_text.setBackground(blue); // Przykładowa zmiana wyglądu
                    tog_button_bin.setBackground(gray); // Powrót do początkowego koloru
                    tog_button_bin.setSelected(false);
                } else {
                    tog_button_text.setBackground(gray); // Powrót do początkowego koloru
                    tog_button_bin.setBackground(blue); // Przykładowa zmiana wyglądu
                    tog_button_text.setSelected(false);
                }
        });
        tog_button_bin.addActionListener(_ -> {
            if (!tog_button_bin.getBackground().equals(blue)) {
                tog_button_bin.setBackground(blue); // Przykładowa zmiana wyglądu
                tog_button_text.setBackground(gray); // Powrót do początkowego koloru
                tog_button_text.setSelected(false);
            } else {
                tog_button_bin.setBackground(gray); // Powrót do początkowego koloru
                tog_button_text.setBackground(blue); // Przykładowa zmiana wyglądu
                tog_button_bin.setSelected(false);
            }
        });

        JLabel text = new JLabel("tekstowy ");
        text.setFont(new Font("Inter", Font.PLAIN, 25));

        JLabel bin = new JLabel(" binarny  ");
        bin.setFont(new Font("Inter", Font.PLAIN, 25));

        toggle_panel.add(text);
        toggle_panel.add(tog_button_text);
        toggle_panel.add(tog_button_bin);
        toggle_panel.add(bin);

        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(format);
        main_panel.add(toggle_panel);
    }

    private void create_bottom_panel(JPanel main_panel){
        JPanel bottom_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottom_panel.setBackground(gray);

        JLabel parameters = new JLabel("Parametry podziału:   ");
        parameters.setFont(new Font("Inter", Font.PLAIN, 25));
        bottom_panel.add(parameters);

        JLabel parts_amount = new JLabel("Liczba części: ");
        parts_amount.setFont(new Font("Inter", Font.PLAIN, 25));
        bottom_panel.add(parts_amount);

        p_amount_field.setFont(new Font("Inter", Font.PLAIN, 25));
        p_amount_field.setColumns(2);
        bottom_panel.add(p_amount_field);

        JLabel margin = new JLabel(" Margines: ");
        margin.setFont(new Font("Inter", Font.PLAIN, 25));
        bottom_panel.add(margin);

        margin_field.setFont(new Font("Inter", Font.PLAIN, 25));
        margin_field.setColumns(2);
        bottom_panel.add(margin_field);

        JLabel percentage = new JLabel("%");
        percentage.setFont(new Font("Inter", Font.PLAIN, 25));
        bottom_panel.add(percentage);

        bottom_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, (margin_field.getPreferredSize().height)+1000));

        main_panel.add(bottom_panel);
    }

    public division_menu(String[] args, Graph graph) {
        JFrame frame = new JFrame("GraphDivider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        try {
            // Ustawienie Nimbus Look and Feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Obsługa błędu, jeśli Nimbus nie jest dostępny
            System.err.println("Nimbus LaF not found, using default.");
        }

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        main_panel.setBackground(Color.WHITE);

        JPanel back_panel = create_back_panel(frame, args, 1, graph);
        main_panel.add(back_panel);
        add_caption(main_panel);
        add_buttons(main_panel, frame, args, graph);

        create_toggle_panel(main_panel);
        create_bottom_panel(main_panel);

        frame.add(main_panel);
        frame.setVisible(true);
    }
    public static void main(String[] args, Graph graph) {
        SwingUtilities.invokeLater(() -> new division_menu(args, graph));
    }
}
