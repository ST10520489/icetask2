//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] months = {"MONTH 1", "MONTH 2", "MONTH 3", "TOTAL", "AVG", "MIN", "MAX"};
        String[] gym = {"GYM 1", "GYM 2", "GYM 3"};
        int[][] weight = new int[gym.length][months.length - 4];

        File inputFile = new File("gym_input.txt");

        // Create input file if it doesn't exist
        if (!inputFile.exists()) {
            try (FileWriter fw = new FileWriter(inputFile)) {
                fw.write("10 20 27\n");
                fw.write("22 5 20\n");
                fw.write("30 20 10\n");
                System.out.println("Created gym_input.txt with sample data.");
            } catch (IOException e) {
                System.out.println("Error creating input file: " + e.getMessage());
                return;
            }
        }

        // Read data from file
        try (Scanner sc = new Scanner(inputFile)) {
            for (int i = 0; i < gym.length; i++) {
                for (int j = 0; j < 3; j++) { // 3 months
                    if (sc.hasNextInt()) {
                        weight[i][j] = sc.nextInt();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        System.out.println("GYM WEIGHTLOSS APPLICATION");
        System.out.println("*************************************************************************");

        // Write results to file
        try (FileWriter writer = new FileWriter("gym_report.txt")) {

            System.out.printf("%-12s", "");
            writer.write(String.format("%-12s", ""));
            for (String month : months) {
                if (month.equals("TOTAL")) {
                    System.out.printf("| %-12s", month);
                    writer.write(String.format("| %-12s", month));
                } else {
                    System.out.printf("%-12s", month);
                    writer.write(String.format("%-12s", month));
                }
            }
            System.out.println();
            writer.write("\n");
            System.out.println("*************************************************************************");
            writer.write("*************************************************************************\n");

            // Process each gym
            for (int a = 0; a < gym.length; a++) {
                int total = 0;
                int min = weight[a][0];
                int max = weight[a][0];

                System.out.printf("%-12s", gym[a]);
                writer.write(String.format("%-12s", gym[a]));

                for (int b = 0; b < weight[a].length; b++) {
                    int value = weight[a][b];
                    total += value;

                    if (value < min) min = value;
                    if (value > max) max = value;

                    System.out.printf("%-12s", value + "kg");
                    writer.write(String.format("%-12s", value + "kg"));
                }

                double avg = (double) total / weight[a].length;

                System.out.printf("| %-12s", total + "kg");
                writer.write(String.format("| %-12s", total + "kg"));

                System.out.printf("%-12s", String.format("%.2f", avg) + "kg");
                writer.write(String.format("%-12s", String.format("%.2f", avg) + "kg"));

                System.out.printf("%-12s", min + "kg");
                writer.write(String.format("%-12s", min + "kg"));

                System.out.printf("%-12s", max + "kg");
                writer.write(String.format("%-12s", max + "kg"));

                System.out.println();
                writer.write("\n");
            }

            System.out.println("*************************************************************************");
            writer.write("*************************************************************************\n");

            System.out.println("Report successfully written to gym_report.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
