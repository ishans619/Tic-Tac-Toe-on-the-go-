import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        char[][] board = new char[3][3];
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[row].length ; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);

            if(isBoardFull(board)){
                System.out.println("It's a tie!!");
                break;
            }

            System.out.print("Player " + player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won!!");
                }
                else if(player == 'X'){
                    player = 'O';
                }
                else{
                    player = 'X';
                }
            }
            else{
                System.out.println("Invalid Move!!, Try Again!");
            }
        }

        printBoard(board);
        sc.close();
    }

    //function to check if the board is full yet
    public static boolean isBoardFull(char[][] board){
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[row].length ; col++){
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //function to check who has won//
    public static boolean hasWon(char[][] board, char player){
        //for checking rows
        for(int row = 0 ; row < board.length ; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //for checking col
        for(int col = 0 ; col < board[0].length ; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;

    }

    //function to print the board
    public static void printBoard(char[][] board){
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[row].length ; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}