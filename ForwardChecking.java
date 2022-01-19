package Project1;

public class ForwardChecking {



    private boolean ForwardCheck(int[][] array, int column) {

        boolean[][] array1 = new boolean[9][9];

        for (int number = 1; number < 10; number++) {
            int row;
            for (row = 0; row < array.length; row++) {
                for (column = 0; column < array.length; column++) {
                    if (array[row][column] == number) {
                        array1[row][column] = false;
                    }
                }
            }
        }

        return true;

    }
    public boolean solveBoard(int[][] board, int row, int column) {




        //check if board is ending, stop backtracking if true
        //base case

        if(row==board.length-1 && column==board.length)
            return true;


        //check if we have reached the end of column

        if(column == board.length)
        {
            column = 0;
            //go next row
            row = row + 1;
            //go back to index 0 of column


        }

        //backtracking code

        //for loop for the number which has to be plugged in
        //number goes from 1=9
        //if the the number is valid, the number is put in that specific index


        //checks if there is black space (0), if not go to next column
        if(board[row][column] > 0)
            return solveBoard(board, row, column+1);

        for(int number = 1; number <=9; number++)
        {

            if (isValid(board, row, column, number)) {

                board[row][column] = number;

                if(solveBoard(board, row, column+1))
                    return true;

            }

            /* if number not valid then put 0 back */

            else
                board[row][column] = 0;

        }
        return false;




    }


    /* these three methods validate the following things

     *  check for duplicates in row, column and the 3x3 grid

     */


    private boolean checkRow(int[][] board, int row, int number)
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[row][i]==number)
                return true;
        }

        return false;
    }

    private boolean checkColumn(int[][] board, int column, int number)
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][column]==number)
                return true;
        }

        return false;
    }



    private boolean checkBox(int[][] board, int row, int column, int number)
    {
        int boxRow = row - (row%3);
        int boxColumn = column - (column%3);

        for(int i = boxRow; i < boxRow+3; i++)
        {
            for(int j = boxColumn; j < boxColumn+3; j++)
            {
                if(board[i][j]==number)
                    return true;
            }
        }

        return false;


    }

    private boolean isValid(int[][] board, int row, int column, int number)
    {
        return !checkRow(board, row, number)&& !checkColumn(board, column, number) && !checkBox(board, row, column, number) && !ForwardCheck(board, column);
    }



}
