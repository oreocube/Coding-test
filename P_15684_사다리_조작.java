import java.io.*;
import java.util.*;

public class P_15684_사다리_조작 {
    static int N, M, H, Answer;
    static boolean[][] map;

    static void dfs(int len, int k) {
        if (len == k) {
            // 사다리타기
            for (int i = 1; i <= N; i++) {
                if (!equalEnd(i)) return;
            }
            Answer = len;
        } else {
            for (int i = 1; i <= H; i++) {
                for (int j = 1; j < N; j++) {
                    if (map[i][j]) continue;
                    if (j != 1 && map[i][j - 1]) continue;
                    if (j != N - 1 && map[i][j + 1]) continue;
                    map[i][j] = true;
                    dfs(len, k + 1);
                    if (Answer != -1) return;
                    map[i][j] = false;
                }
            }
        }
    }

    static boolean equalEnd(int startColumn) {
        int current = startColumn;
        for (int row = 1; row <= H; row++) {
            if (current != 1 && map[row][current - 1]) {
                current--;
                continue;
            }
            if (current != N && map[row][current]) {
                current++;
            }
        }
        return current == startColumn;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H + 1][N];

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        Answer = -1;
        for (int i = 0; i <= 3; i++) {
            dfs(i, 0);
            if (Answer != -1) break;
        }
        System.out.println(Answer);
    }
}
