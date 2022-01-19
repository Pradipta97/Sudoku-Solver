package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleImporter {

    public static int[][] board = new int[9][9];






    //looks for the .csv file and places the values into a 2-d array

    public void readFile() throws FileNotFoundException {
        File file = new File("D:/Downloads/hard1.txt");


        Scanner sc = new Scanner(file);

        board = new int[9][9];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = sc.nextInt();

        }



    }


    //returns the value of the board

    public int[][] getBoard()
    {
        return board;
    }

    //prints the board



}

