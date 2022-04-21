import java.io.*;
import java.util.*;

public class P_2615_오목 {
    static int N = 19;
    static int[][] board = new int[N][N];
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};

    static void solve() {
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int color = board[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                int count = 1;

                int px = nx - dx[i], py = ny - dy[i];
                if (!(px < 0 || px >= N || py < 0 || py >= N) && board[px][py] == color) continue;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    if (board[nx][ny] != color) break; // 다른 색이면 그만
                    if (++count > 5) break;
                }

                if (count == 5) {
                    sb.append(color).append('\n');
                    sb.append(x + 1).append(' ').append(y + 1);
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 흰돌이나 검은돌이면 큐에 넣기
                if (board[i][j] != 0) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        solve();
    }
}
