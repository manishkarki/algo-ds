package com.algo.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mkarki
 */
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                System.out.println("i/3:"+(i/3)+" j/3:"+(j/3));
                if (number != '.')
                    if (!seen.add(number + " row " + i) ||
                            !seen.add(number + " column " + j) ||
                            !seen.add(number + " region " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] board = {"53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()};
        System.out.println(sudoku.isValidSudoku(board));
    }

}
