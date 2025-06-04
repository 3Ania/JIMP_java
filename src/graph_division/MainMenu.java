package graph_division;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainMenu {

    Color blue = new Color(53, 193, 232);
    Color gray = new Color(180,180,180);

    //suwak
    JButton tog_button_text = new JButton(" ");
    public static JButton tog_button_bin = new JButton(" ");

    public static JTextField p_amount_field = new JTextField();
    JTextField margin_field = new JTextField();

    //tytuł
    private void add_caption(JPanel main_panel){
        JLabel caption = new JLabel("Menu główne");
        caption.setFont(new Font("Inter", Font.BOLD, 50));
        caption.setForeground(blue);
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);
        main_panel.add(caption);
    }

    //przyciski
    private void add_buttons(JPanel main_panel, JFrame frame, String[] args, Graph graph){
        JButton show_graph = new JButton("Wyświetl graf");
        show_graph.setFont(new Font("Inter", Font.PLAIN, 30));
        show_graph.setBackground(gray);
        show_graph.setAlignmentX(Component.CENTER_ALIGNMENT);

        show_graph.addActionListener(_ -> {
            frame.dispose();
            FillGraphWithOutput.main(args, 0, graph, "src\\connection_with_C\\input_graph.txt");
            DrawGraph.main(args, graph, 2);
        });

        Dimension targetSize = show_graph.getPreferredSize();
        targetSize.width += 10;
        show_graph.setPreferredSize(targetSize);
        show_graph.setMaximumSize(new Dimension(targetSize.width, targetSize.height));

        /*show_graph.addActionListener(_ -> {
                frame.dispose();
                draw_graph.main(args, graph);
        });*/

        JButton divide = new JButton("Podziel graf");
        divide.setFont(new Font("Inter", Font.PLAIN, 30));
        divide.setBackground(gray);
        divide.setPreferredSize(targetSize);
        divide.setMaximumSize(new Dimension(targetSize.width, targetSize.height));
        divide.setAlignmentX(Component.CENTER_ALIGNMENT);

        divide.addActionListener(_ -> {
            frame.dispose();
            DivisionMenu.main(args, graph);
        });

        JButton read = new JButton("Wczytaj graf");
        read.setFont(new Font("Inter", Font.PLAIN, 30));
        read.setBackground(gray);
        read.setPreferredSize(targetSize);
        read.setMaximumSize(new Dimension(targetSize.width, targetSize.height));
        read.setAlignmentX(Component.CENTER_ALIGNMENT);

        //to edit!!!
        read.addActionListener(_ -> {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            //kod wczytywania pliku do grafu
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Wczytano plik: " + selectedFile.getAbsolutePath());
            File outputFile = new File("src\\connection_with_C\\input_graph.txt"); // Tworzymy obiekt dla pliku wyjściowego

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine(); // Dodajemy znak nowej linii po każdej przepisanej linii
                }
                System.out.println("Zawartość pliku '" + selectedFile.getName() + "' została pomyślnie przepisana do 'input.txt'.");
                FillGraphWithOutput.main(args, 0, graph, "src\\connection_with_C\\input_graph.txt");
            } catch (IOException e) {
                System.err.println("Wystąpił błąd podczas operacji na plikach: " + e.getMessage());
                // Możesz dodać bardziej szczegółową obsługę błędów, np. okienko dialogowe z komunikatem
            }
        }
        });

        JButton save_graph = new JButton("Zapisz graf");
        save_graph.setFont(new Font("Inter", Font.PLAIN, 30));
        save_graph.setBackground(gray);
        save_graph.setPreferredSize(targetSize);
        save_graph.setMaximumSize(new Dimension(targetSize.width, targetSize.height));
        save_graph.setAlignmentX(Component.CENTER_ALIGNMENT);

        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(read); 
        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(show_graph);
        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(divide);
        main_panel.add(Box.createRigidArea(new Dimension(0, 20)));
        main_panel.add(save_graph);
    }


    //suwak
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

    //konstruktor
    public MainMenu(String[] args, Graph graph) {
        ClosableFrame frame = new ClosableFrame("GraphDivider", "main");
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

        add_caption(main_panel);
        add_buttons(main_panel, frame, args, graph);

        create_toggle_panel(main_panel);

        frame.add(main_panel);
        frame.setVisible(true);
    }
    public static void main(String[] args, Graph graph) {
        SwingUtilities.invokeLater(() -> new MainMenu(args, graph));
    }
}

