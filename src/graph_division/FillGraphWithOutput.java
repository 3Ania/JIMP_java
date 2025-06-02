package graph_division;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FillGraphWithOutput {
    public static void main(String[] args, int parts_amount, Graph graph, String path) {
        String filePath = path; // Zmień na faktyczną ścieżkę do pliku

        int line_nr = 0;
        int[][] placing = {{}};
        int[][] parts = {{}};
        int[][] connections = {{}};
        String[] splitted_line2 = {};
        String[] splitted_line4 = {};
        int size = 0, sizep;
        int i, j = 0;
        int idxj, idxi = -1, idxjp = 0;
        int node_amount = 0;
        int node = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line_nr == 0){
                    size = Integer.parseInt(line);
                    placing = new int[size][size];
                    for(i = 0; i < size; i++){
                        for(j = 0; j < size; j++){
                            placing[i][j] = 0;
                        }
                    }
                }else if(line_nr == 1){
                    splitted_line2 = line.split(";");
                }
                else if(line_nr == 2){
                    String[] splitted = line.split(";");
                    for(i = 1; i < splitted.length; i++){
                        for(j = Integer.parseInt(splitted[i-1]); j < Integer.parseInt(splitted[i]); j++){
                            placing[i-1][Integer.parseInt(splitted_line2[j])] = 1;
                            node_amount++;
                        }
                    }
                    for(j = Integer.parseInt(splitted[splitted.length - 1]); j < splitted_line2.length; j++){
                        placing[size-1][Integer.parseInt(splitted_line2[j])] = 1;
                        node_amount++;
                    }
                }
                else if(line_nr == 3){
                    splitted_line4 = line.split(";");
                    connections = new int[node_amount][];
                    parts = new int[parts_amount][];
                }
                else{
                    String[] splitted_line = line.split(";");
                    sizep = splitted_line.length;

                    idxj = 0;

                    if(line_nr != 4){
                        for(int k = j; k < splitted_line4.length && k < Integer.parseInt(splitted_line[0]); k++){
                            if(k == j){
                                size = Integer.parseInt(splitted_line[0]) - j - 1;
                                node = Integer.parseInt(splitted_line4[j]);
                                parts[idxi][idxjp] = node;
                                idxjp++;
                                connections[node] = new int[size];
                            }
                            else {
                                connections[node][idxj] = Integer.parseInt(splitted_line4[k]);
                                idxj++;
                            }
                        }
                    }
                    idxi++;
                    parts[idxi] = new int[sizep];
                    idxjp = 0;
                    for(i = 1; i < splitted_line.length; i++){
                        idxj = 0;
                        for(j = Integer.parseInt(splitted_line[i-1]); j < Integer.parseInt(splitted_line[i]); j++){
                            if(j == Integer.parseInt(splitted_line[i-1]))  {
                                node = Integer.parseInt(splitted_line4[j]);
                                size = Integer.parseInt(splitted_line[i]) - Integer.parseInt(splitted_line[i-1]) - 1;
                                parts[idxi][idxjp] = node;
                                idxjp++;
                                connections[node] = new int[size];
                            }
                            else {
                                connections[node][idxj] = Integer.parseInt(splitted_line4[j]);
                                idxj++;
                            }
                        }
                    }
                }
                line_nr++;
            }
            idxj = 0;
            for(int k = j; k < splitted_line4.length; k++){
                if(k == j){
                    size = splitted_line4.length - j - 1;
                    node = Integer.parseInt(splitted_line4[j]);
                    parts[idxi][idxjp] = node;
                    idxjp++;
                    connections[node] = new int[size];
                }
                else {
                    connections[node][idxj] = Integer.parseInt(splitted_line4[k]);
                    idxj++;
                }
            }

//            System.out.println("Connections: ");
//            for(i = 0; i < node_amount; i++){
//                for(j = 0; j < connections[i].length; j++){
//                    System.out.print(connections[i][j] + " ");
//                }System.out.println();
//            }
//            System.out.println("Parts: ");
//            for(i = 0; i < parts_amount; i++){
//                for(j = 0; j < parts[i].length; j++){
//                    System.out.print(parts[i][j] + " ");
//                }System.out.println();
//            }
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
           // e.printStackTrace();
        }
        graph.connections = connections;
        graph.parts = parts;
        graph.placing = placing;
    }
}
