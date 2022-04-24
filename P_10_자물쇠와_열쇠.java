public class P_10_자물쇠와_열쇠 {
    static class Solution {
        static int[][] turnRight(int M, int[][] key) {
            int[][] newKey = new int[M][M];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    newKey[i][j] = key[M - 1 - j][i];
                }
            }

            return newKey;
        }

        static boolean check(int N, int M, int[][] key, int[][] board, int xOffset, int yOffset) {
            int start = M - 1;
            int end = N + M - 2;

            for (int i = start; i <= end; i++) {
                for (int j = start; j <= end; j++) {
                    int x = i - xOffset;
                    int y = j - yOffset;

                    if (x < 0 || x >= M || y < 0 || y >= M) {
                        if (board[i][j] != 1) return false;
                    } else {
                        if ((board[i][j] ^ key[x][y]) != 1) return false;
                    }
                }
            }
            return true;
        }

        public boolean solution(int[][] key, int[][] lock) {
            int N = lock.length;
            int M = key.length;
            int size = N + 2 * M - 2;

            // 자물쇠 확장
            int[][] board = new int[size][size];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[M - 1 + i][M - 1 + j] = lock[i][j];
                }
            }

            // 열쇠 복사
            int[][] newKey = new int[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    newKey[i][j] = key[i][j];
                }
            }

            for (int i = 0; i < 4; i++) {
                if (i > 0) newKey = turnRight(M, newKey);

                for (int j = 0; j < N + M - 1; j++) {
                    for (int k = 0; k < N + M - 1; k++) {
                        if (check(N, M, newKey, board, j, k)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
