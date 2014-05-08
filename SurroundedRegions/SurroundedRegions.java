//============================================================================
// Given a 2D board containing 'X' and 'O', capture all regions surrounded 
// by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
// region.
//
// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:
//
// X X X X
// X X X X
// X X X X
// X O X X
//
// Complexity:
// O(n^2) time, O(n) space
//============================================================================

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O')
                bfs(board, M, N, i, 0);
            if (board[i][N - 1] == 'O')
                bfs(board, M, N, i, N - 1);
        }
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                bfs(board, M, N, 0, j);
            if (board[M - 1][j] == 'O')
                bfs(board, M, N, M - 1, j);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'D')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void bfs(char[][] board, int M, int N, int i, int j) {
        board[i][j] = 'D';
        Queue<Integer> qs = new LinkedList<Integer>();
        qs.add(i * N + j);
        while (!qs.isEmpty()) {
            i = qs.peek() / N;
            j = qs.poll() % N;
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = 'D';
                qs.add((i - 1) * N + j);
            }
            if (i + 1 < M && board[i + 1][j] == 'O') {
                board[i + 1][j] = 'D';
                qs.add((i + 1) * N + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = 'D';
                qs.add(i * N + j - 1);
            }
            if (j + 1 < N && board[i][j + 1] == 'O') {
                board[i][j + 1] = 'D';
                qs.add(i * N + j + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        sol.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}