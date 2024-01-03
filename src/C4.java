import java.util.Scanner;
public class C4 {


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
//        System.out.println("how big should the board be? enter a positive number");
//        int size = s.nextInt();
//        while (size < 1) {
//            System.out.println("Invalid board size");
//            System.out.println("how big should the board be? enter a positive number");
//            size = s.nextInt();
//        }
        int nRows = 6;
        int nCols = 7;
        //initialize the class-level board array
        board = new String[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                board[i][j] = "_";
            }
        }
    }
    public static void getNames() {
//        s.nextLine();
//        System.out.println("enter player 1's name");
//        names[0] = s.nextLine();
//        System.out.println("enter player 2's name");
//        names[1] = s.nextLine();
        names[0] = "p1";
        names[1] = "p2";
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

        //validate that the col is valid
        //validate that there's room in the col

        //place piece by "dropping" it into the col

        System.out.println(names[player] + "- place your " + piece);

        System.out.println("enter your col");
        int col = s.nextInt();

        //validate
        //a col is full if the top-most position (row 0) is occupied
        while (col < 0 || col >= board[0].length || !board[0][col].equals("_")) {
           System.out.println("enter a new col");
           col = s.nextInt();
        }

        //place piece
        //there's at least one empty spot in the column, which would be row 0
        int row = 0;

        //check if the spot underneath the current row is blank. if so, increment row
        //make sure there IS a next row (not moving past the bottom of the board)
        while (row+1 < board.length && board[row+1][col].equals("_")) {
            row++;
        }

        board[row][col] = piece;

    }
    public static boolean gameOver(int player) {
        String piece = "x";
        if (player == 1)
            piece = "o";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int rowCount = 0;
                int colCount = 0;
                int d1Count = 0;
                int d2Count = 0;

                //use offset to check the 4 adjacent pieces
                for (int offset = 0; offset < 4; offset++) {

                    //check for horizontal rows
                    //make sure j+offset is a valid column number
                    if (j+offset < board[0].length && board[i][j+offset].equals(piece)) {
                        rowCount++;
                    }

                    //check vertical cols
                    if (i+offset < board.length && board[i+offset][j].equals(piece)) {
                        colCount++;
                    }

                    //check diag1
                    if (i+offset < board.length && j+offset < board[0].length &&
                            board[i+offset][j+offset].equals(piece)) {
                        d1Count++;
                    }

                    //check diag2
                    if (i+offset < board.length && j-offset >= 0 &&
                            board[i+offset][j-offset].equals(piece)) {
                        d2Count++;
                    }

                }
                if (rowCount == 4 || colCount == 4 || d1Count == 4 || d2Count == 4) {
                    System.out.println(piece + " wins!");
                    return true;
                }

            }
        }

        return false;

    }
}