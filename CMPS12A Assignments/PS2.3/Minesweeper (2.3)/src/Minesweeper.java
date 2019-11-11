import java.util.Scanner;

//
// THE INTEGER VALUE -1 REPRESENTS A BOMB
//
public class Minesweeper {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int rows = scnr.nextInt();
        int columns = scnr.nextInt();
        int[][] board = new int[rows][columns];
        int numBombs = scnr.nextInt();
        int bombLocationRow = scnr.nextInt();
        int bombLocationCol = scnr.nextInt();
        board[bombLocationRow][bombLocationCol] = -1;

        while (numBombs >= 2) {
            bombLocationRow = scnr.nextInt();
            bombLocationCol = scnr.nextInt();
            board[bombLocationRow][bombLocationCol] = -1; //aka bomb
            numBombs--;
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                if (board[i][k] != -1) {
                    count = neighborCount(i, k, board);
                    board[i][k] = count;
                }
            }
        }

        for(int i = 0; i < board.length ; i ++) {
            System.out.println();
            for(int j = 0 ; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    if (j == board[i].length - 1)
                        System.out.print('*');
                    else
                        System.out.print("* ");
                } else {
                    if (j == board[i].length - 1)
                        System.out.print(board[i][j]);
                    else {
                        System.out.print(board[i][j] + " ");
                    }
                }
            }
        }
    }

    public static int neighborCount(int row, int col, int[][] board ) {
        int count = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < board.length)
                for(int j = col - 1; j <= col + 1; j++)
                    if (j >= 0 && j < board[i].length)
                        if (i != row || j != col)
                            if (board[i][j] == -1)
                                count++;
        }
        return count;
    }
}
