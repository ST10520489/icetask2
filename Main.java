//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] months = {"MONTH 1", "MONTH 2", "MONTH 3", "TOTAL", "AVG", "MIN", "MAX"};
        String[] gym = {"GYM 1", "GYM 2", "GYM 3"};
        int[][] weight = {{10, 20, 27}, {22, 5, 20}, {30, 20, 10}};

        System.out.println("GYM WEIGHTLOSS APPLICATION");
        System.out.println("*************************************************************************");

        System.out.printf("%-12s", "");
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals("TOTAL")) {
                System.out.printf("| %-12s", months[i]);
            } else {
                System.out.printf("%-12s", months[i]);
            }
        }
        System.out.println();
        System.out.println("*************************************************************************");
        for (int a = 0; a < gym.length; a++) {
            int total = 0;
            int min = weight[a][0];
            int max = weight[a][0];

            System.out.printf("%-12s", gym[a]);

            for (int b = 0; b < weight.length; b++) {
                int value = weight[a][b];
                total += value;

                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
                System.out.printf("%-12s", value + "kg");
                }
            double avg = (double) total/ weight[a].length;

            System.out.printf("| %-12s", total + "kg");
            System.out.printf("%-12s", String.format("%.2f",avg) + "kg");
            System.out.printf("%-12s", min + "kg");
            System.out.printf("%-12s", max + "kg");
            System.out.println();
            }
        System.out.println("*************************************************************************");
        }
    }
