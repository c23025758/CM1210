import java.util.Scanner;

public class Q1a_23025758 {

    static void generateMagicSquare(int n) {
        int[][] square = new int[n][n];

        int x = 0;
        int y = n / 2;

        for (int num = 1; num <= n * n; num++) {
            square[x][y] = num;

            int newX = (x - 1 + n) % n;
            int newY = (y + 1) % n;

            if (square[newX][newY] == 0) {
                x = newX;
                y = newY;
            } else {
                x = (x + 1) % n;
            }
        }

        System.out.println("Magic Square of size " + n + ":");
        for (int[] rowArray : square) {
            for (int num : rowArray) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the odd number for magic square:");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("Please enter an odd integer.");
            scanner.close();
            return;
        }

        generateMagicSquare(n);
        scanner.close();
    }
}
