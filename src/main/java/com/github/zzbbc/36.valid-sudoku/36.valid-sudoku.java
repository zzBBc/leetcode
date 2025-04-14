/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Runtime: 3 ms
// Memory Usage: 44.47 MB
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowBoards = new HashMap<>(board.length);
        Map<Integer, Set<Character>> columnBoards = new HashMap<>(board.length);
        for(int subBoardI = 0; subBoardI < 3; subBoardI++){
            for(int subBoardJ = 0; subBoardJ < 3; subBoardJ++){
                Set<Character> subBoard = new HashSet<>(board.length);
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        int realI = subBoardI*3 + i;
                        int realJ = subBoardJ*3 + j;
                        char character = board[realI][realJ];

                        if('.' != character){
                            if(subBoard.contains(character)){
                                return false;
                            } else{
                                subBoard.add(character);
                            };

                            Set<Character> rowBoard = rowBoards.get(realI);
                            if(rowBoard == null){
                                rowBoard = new HashSet<>(board.length);
                                rowBoards.put(realI, rowBoard);
                            };

                            if(rowBoard.contains(character)){
                                return false;
                            } else{
                                rowBoard.add(character);
                            };

                            Set<Character> columnBoard = columnBoards.get(realJ);
                            if(columnBoard == null){
                                columnBoard = new HashSet<>(board.length);
                                columnBoards.put(realJ, columnBoard);
                            };

                            if(columnBoard.contains(character)){
                                return false;
                            } else{
                                columnBoard.add(character);
                            };
                        };
                    };
                };
            };
        };

        return true;
    };
}
// @lc code=end

