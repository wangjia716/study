package com.example.study.model.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphOperation {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new Map[9];
        Map<Integer, Integer>[] column = new Map[9];
        Map<Integer, Integer>[] box = new Map[9];
        for (int k=0;k<9;k++) {
           rows[k] = new HashMap<>(9);
           column[k] = new HashMap<>(9);
           box[k] = new HashMap<>(9);
        }
        for (int i=0;i<9;i++) {
            for (int j=0; j<9;j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows[i].containsKey(board[i][j]- '0') || column[j].containsKey(board[i][j]-'0') || box[(i/3)*3+j/3].containsKey(board[i][j]-'0')) {
                    return false;
                }
                rows[i].put((board[i][j]-'0'), 1);
                column[j].put((board[i][j]-'0'), 1);
                box[(i/3)*3+j/3].put((board[i][j]-'0'), 1);
            }
        }
        return true;

    }

//    public static void main(String[] args) {
//        char[][] board
//    }
}
