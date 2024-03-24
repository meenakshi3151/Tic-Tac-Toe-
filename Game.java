import java.util.Scanner;
class Details {
    String name;
    int age;
    String phoneNumber;
    String email;
    String symbol;

    Details(String name, int age, String phoneNumber, String email, String symbol) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symbol = symbol;
    }

}

public class Game{
    // check the board for the winning condition
    public static boolean check(char[][] board, char symbol) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == symbol) {
                    count++;
                }
            }
            if (count == board.length) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == symbol) {
                    count++;
                }
            }
            if (count == board.length) {
                return true;
            }
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == symbol) {
                count++;
            }
        }
        if (count == board.length) {
            return true;
        }
        count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] == symbol) {
                count++;
            }
        }
        return count == board.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of board");
        int size = sc.nextInt();
        char[][] board = new char[size][size];
        Details player1 = new Details("Anuj", 20, "8998839", "Ish@gmail.com", "X");

        Details player2 = new Details("Anu", 20, "8998839", "anu@gmail.com", "O");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
        while (true) {
            System.out.println("Enter the position of player1");
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = player1.symbol.charAt(0);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            if (check(board, player1.symbol.charAt(0))) {
                System.out.println("Player1 wins");
                break;
            }
            System.out.println("Enter the position of player2");
            x = sc.nextInt();
            y = sc.nextInt();
            board[x][y] = player2.symbol.charAt(0);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            if (check(board, player2.symbol.charAt(0))) {
                System.out.println("Player2 wins");
                break;
            }   
            

        }
    }
}