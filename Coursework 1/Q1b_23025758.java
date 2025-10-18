import java.util.Random;
import java.util.Scanner;

public class Q1b_23025758 {
    static class MagicSquare {
        private int[][] arr;
        private int n, moves;

        public MagicSquare(int len) {
            n = len;
            moves = 0;
            arr = new int[n][n];
        }

        public void createMagicSquare() {
            int num = 1;
            int row = 0, col = n / 2;

            while (num <= n * n) {
                arr[row][col] = num;
                num++;

                row--;
                col++;

                if (row < 0 && col >= n) {
                    row += 2;
                    col--;
                } else {
                    if (row < 0)
                        row = n - 1;
                    if (col >= n)
                        col = 0;
                }

                if (arr[row][col] != 0) {
                    row += 2;
                    col--;
                }
            }
        }

        public void shuffleMagicSquare() {
            Random rand = new Random();
            for (int i = 0; i < n * n; i++) {
                int a = rand.nextInt(n);
                int b = rand.nextInt(n);
                int c = rand.nextInt(n);
                int d = rand.nextInt(n);
                while (a == b || c == d) {
                    a = rand.nextInt(n);
                    b = rand.nextInt(n);
                    c = rand.nextInt(n);
                    d = rand.nextInt(n);
                }
                int temp = arr[a][b];
                arr[a][b] = arr[c][d];
                arr[c][d] = temp;
            }
        }

        public void displayMagicSquare() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void swap(int i, int j, String direction) {
            int newI = i;
            int newJ = j;
            if (direction.equals("R")) {
                newJ = (j + 1) % n;
            } else if (direction.equals("L")) {
                newJ = (j - 1 + n) % n;
            } else if (direction.equals("U")) {
                newI = (i - 1 + n) % n;
            } else if (direction.equals("D")) {
                newI = (i + 1) % n;
            }

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                int temp = arr[newI][newJ];
                arr[newI][newJ] = arr[i][j];
                arr[i][j] = temp;
                moves++;
            } else {
                System.out.println("Invalid move! Please enter valid indices.");
            }
        }

        public int getMoves() {
            return moves;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an odd number: ");
        int size = scanner.nextInt();
        MagicSquare m = new MagicSquare(size);
        m.createMagicSquare();
        System.out.println("Magic Square of size " + size + " is created.");

        System.out.println("Magic Square after shuffling:");
        m.shuffleMagicSquare();
        m.displayMagicSquare();

        while (true) {
            System.out.println("\nChoose to continue or to exit.");
            System.out.println("1. Enter position (i, j) in 0-index and a direction (U, R, L, D)");
            System.out.println("2. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter position (i, j) and direction: ");
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                String direction = scanner.next().toUpperCase();
                m.swap(i, j, direction);
                System.out.println("After swapping:");
                m.displayMagicSquare();
            } else {
                System.out.println("\nTotal Moves = " + m.getMoves() + "\nThanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}
