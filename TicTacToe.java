
import java.util.Scanner;

public class TicTacToe {
    public static String tableValue[][] = { { "00", "01", "02" }, { "10", "11", "12" }, { "20", "21", "22" } };
    public static int playerCount = 0;

    public static void table() {
        for (int i = 0; i < tableValue.length; i++) {
            for (int j = 0; j < tableValue[i].length; j++) {
                System.out.print(tableValue[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void greetingMsg(Scanner sc) {
        int x = 0;
        int y = 0;
        System.out.println(playerCount % 2 == 0 ? "Player X" : "Player Y");
        System.out.println("Enter the x value:");
        x = sc.nextInt();
        System.out.println("Enter the Y value:");
        y = sc.nextInt();
        System.out.println(insert(x, y, playerCount % 2 == 0 ? "X" : "0"));

    }

    public static String insert(int x, int y, String PlayerName) {
        if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
            if (tableValue[x][y] != "X" && tableValue[x][y] != "0") {
                tableValue[x][y] = PlayerName;
                table();
                playerCount++;
                if (check()) {
                    System.out.printf(PlayerName + "Wins");
                    System.exit(0);
                } else if (playerCount == 9) {
                    System.out.println("its a draw!!!!");
                }
                return "Inserted";

            } else {
                return "Already instered";
            }

        }
        return "Unexpected value";
    }

    public static boolean check() {
        // row
        for (int i = 0; i < 3; i++) {
            if (tableValue[i][0].equals(tableValue[i][1])
                    && tableValue[i][0].equals(tableValue[i][2])
                    && !tableValue[i][0].equals("")) {

                return true;
            }
        }
        // column
        for (int i = 0; i < 3; i++) {
            if (tableValue[0][i].equals(tableValue[1][i])
                    && tableValue[0][i].equals(tableValue[2][i])
                    && !tableValue[0][i].equals("")) {

                return true;
            }
        }

        // digonal
        // column

        if (tableValue[0][0].equals(tableValue[1][1])
                && tableValue[1][1].equals(tableValue[2][2])
                && !tableValue[0][0].equals("")) {
            return true;
        }

        if (tableValue[2][0].equals(tableValue[1][1])
                && tableValue[1][1].equals(tableValue[2][0])
                && !tableValue[2][0].equals("")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            greetingMsg(sc);
        }

    }
}