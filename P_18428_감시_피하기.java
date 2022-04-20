import java.io.*;
import java.util.*;

public class P_18428_감시_피하기 {
    static Queue<Integer> teachers = new LinkedList<>();
    static boolean answer;
    static int N;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int k, int lastRow) {
        if (answer) return;

        if (k == 3) {
            answer = bfs();
            return;
        }

        for (int i = lastRow; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 'X') continue;
                map[i][j] = 'O';
                dfs(k + 1, i);
                map[i][j] = 'X';
                if (answer) return;
            }
        }
    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>(teachers);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    if (map[nx][ny] == 'S') return false;
                    if (map[nx][ny] != 'X') break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(i);
                    teachers.add(j);
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer ? "YES" : "NO");
    }
}
