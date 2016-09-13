import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    char[][] board;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    // method to run the game
    public void run() {
        showTable();
        while (!isDraw()) {
            char w = winner();
            if (w == '.') {
                Scanner in = new Scanner(System.in);
                int i = in.nextInt();
                int j = in.nextInt();
                if (p1.getPlayerTurn()) {
                    board[i][j] = 'X';
                    p1.setPlayerTurn(false);
                    p2.setPlayerTurn(true);
                } else {
                    board[i][j] = 'O';
                    p1.setPlayerTurn(true);
                    p2.setPlayerTurn(false);
                }
                showTable();
            }
            else {
                System.out.println("Winner is: " + w);
                break;
            }
        }
        System.out.println("Draw!");
    }

    // show table
    public void showTable() {
        for (int i = 0; i < 3; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                line.append(board[i][j]);
            }
            System.out.println(line.toString());
        }
    }
    // method to check if it is a winner
    public char winner() {
        char w = '.';
        Boolean potentialWinner;

        // line by line
        for (int i = 0; i < 3; i++) {
            char aux = board[i][0];
            potentialWinner = false;
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != aux) {
                    potentialWinner = false;
                    break;
                }
                else
                    potentialWinner = true;
            }
            if (potentialWinner) {
                return aux;
            }
        }

        // column
        for (int i = 0; i < 3; i++) {
            char aux = board[0][i];
            potentialWinner = false;
            for (int j = 1; j < 3; j++) {
                if (board[j][i] != aux) {
                    potentialWinner = false;
                    break;
                }
                else
                    potentialWinner = true;
            }

            if (potentialWinner)
                    return aux;
        }

        // TODO: Check diagonals

       return w;
    }

    public Boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }


}
