package connection_with_C;

import java.io.IOException;

public class GraphDividerWrapper {

    public void get_output_from_C(int parts_amount, int margin) {
        // Path to your C executable
        String cExecutablePath = "src/connection_with_C/graph_divider.exe";

        // Full path to your input graph file, as confirmed working in CMD
        String inputGraphFilePath = "src/connection_with_C/input_graph.txt";
        boolean isBinary = false; // Set to true if you want binary output

        try {
            // Prepare the command to execute
            ProcessBuilder processBuilder = new ProcessBuilder();

            // Pass the full path to the input file, just like in CMD
            processBuilder.command(
                    cExecutablePath,
                    inputGraphFilePath, // Now passing the full path
                    String.valueOf(parts_amount),
                    String.valueOf(margin)
            );
            if (isBinary) {
                processBuilder.command().add("-b");
            }
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing C program: " + e.getMessage());
        }
    }
    public static void main(String[] args, int parts_amount, int margin) {
        new GraphDividerWrapper().get_output_from_C(parts_amount, margin);
    }
}