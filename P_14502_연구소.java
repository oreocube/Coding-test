import java.io.*;
import java.util.*;

public class P_14502_연구소 {
    static int N, M, wall, Answer;
    static int[][] map;
    static ArrayList<Point> virus;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // 0은 빈칸, 1은 벽, 2는 바이러스가 있는 곳
    // 벽을 3개 세워서 안전 영역 크기 최댓값 구하기

    // 1. 벽을 세울 위치를 고른다.
    static void dfs(int k, int nowX) {
        if (k >= 3) {
            Answer = Math.max(Answer, bfs());
        } else {
            for (int i = nowX; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) continue;
                    map[i][j] = 1;
                    dfs(k + 1, i);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 2. 바이러스를 퍼뜨린다.
    static int bfs() {
        boolean[][] visited = new boolean[N][M];
        int count = virus.size();

        Queue<Point> queue = new LinkedList<>();
        for (Point v : virus) {
            queue.add(new Point(v.x, v.y));
        }

        while (!queue.isEmpty()) {
            Point v = queue.poll();
            int x = v.x, y = v.y;

            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] != 0) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    count++;
                }
            }
        }

        return N * M - wall - 3 - count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) wall++;
                else if (map[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        Answer = 0;
        dfs(0, 0);
        System.out.println(Answer);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
