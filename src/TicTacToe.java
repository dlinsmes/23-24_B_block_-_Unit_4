import java.util.Scanner;
public class TicTacToe {


    //class level variables are accessible by all methods
    //in the class
    //-for now, class variables start with public static

    //don't know size until setupBoard() runs
    public static String [][] board;

    public static Scanner s = new Scanner(System.in);

    //we know names will hold 2 values
    public static String [] names = new String [2];

    public static void main(String [] args) {
        setupBoard();
        getNames();
        printBoard();
        int player = 1;
        while(gameOver(player) == false) {
            //pass the old value of player to method and
            //save its return value to the player variable
            player = switchPlayers(player);
            turn(player);
            printBoard();
        }
    }
    public static void setupBoard() {
        System.out.println("how big should the board be? enter a positive number");
        int size = s.nextInt();
        while (size < 1) {
            System.out.println("Invalid board size");
            System.out.println("how big should the board be? enter a positive number");
            size = s.nextInt();
        }
        //initialize the class-level board array
        board = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }
    }
    public static void getNames() {
        s.nextLine();
        System.out.println("enter player 1's name");
        names[0] = s.nextLine();
        System.out.println("enter player 2's name");
        names[1] = s.nextLine();
    }
    public static void printBoard() {

        //size was a var declared in a different method
        //variable scope - size is only available in the method
        //it was declared in
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //if 0 is passed for current, switch to 1
    //if 1 is passed for current, switch to 0
    public static int switchPlayers(int current) {
        if (current == 0)
            return 1;
        return 0;
    }

    //player will be 0 or 1
    //0 places an x, 1 places an o
    public static void turn(int player) {
        String piece = "x";
        if (player == 1)
            piece = "o";
        System.out.println(names[player] + "- place your " + piece);

        System.out.println("enter your row");
        int row = s.nextInt();
        System.out.println("enter your col");
        int col = s.nextInt();

        //validate that row and col are within range
        // and that there's nothing on the board there
        while (row < 0 || row >= board.length ||
                col < 0 || col >= board.length ||
                !board[row][col].equals("_")) {

            System.out.println("invalid");
            System.out.println("enter your row");
            row = s.nextInt();
            System.out.println("enter your col");
            col = s.nextInt();
        }

        //place piece on board
        board[row][col] = piece;
    }
    public static boolean gameOver(int player) {
        String piece = "x";
        if (player == 1)
            piece = "o";

        for (int i = 0; i < board.length; i++) {

            int rowCount = 0;
            int colCount = 0;
            int diag1Count = 0;
            int diag2Count = 0;

            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j].equals(piece)) {
                    rowCount++;
                }
                if(board[j][i].equals(piece)) {
                    colCount++;
                }
                if(board[j][j].equals(piece)) {
                    diag1Count++;
                }
                if(board[j][board.length - 1 - j].equals(piece)) {
                    diag2Count++;
                }
            }

            if (rowCount == board.length || colCount == board.length ||
                    diag1Count == board.length || diag2Count == board.length ) {
                System.out.println(names[player] + " wins!");
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //if there's a blank, there are still places to play
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }


        //if the method reaches this point, nobody has won and there are no more blanks
        //sp there is a tie
        System.out.println("tie game!");
        return true;
    }
}
