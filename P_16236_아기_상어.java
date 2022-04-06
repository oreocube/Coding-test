import java.io.*;
import java.util.*;

public class P_16236_아기_상어 {
    static int N, startX, startY;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static void bfs() {
        PriorityQueue<Info> eatable = new PriorityQueue<>();
        Queue<Info> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int curX = startX, curY = startY;
        visited[curX][curY] = true;
        queue.add(new Info(curX, curY, 0));

        int time = 0, count = 0, size = 2, range = 0;
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;

            // 거리가 증가한 경우, 먹을 수 있는 물고기가 있는지 조사
            if (dist > range) {
                if (!eatable.isEmpty()) {
                    Info next = eatable.poll();
                    int nx = next.x;
                    int ny = next.y;
                    int nd = next.dist;

                    // 한 마리 더 먹었을 때, 크기가 커지는지 체크
                    if (++count == size) {
                        size++;
                        count = 0;
                    }
                    time += nd;

                    // 새로운 위치로 이동
                    map[curX][curY] = 0;
                    map[nx][ny] = 0;
                    curX = nx;
                    curY = ny;

                    // 새로운 위치부터 다시 bfs 하기 위해 초기화
                    eatable.clear();
                    queue.clear();
                    visited = new boolean[N][N];
                    visited[curX][curY] = true;
                    range = 0;
                    queue.add(new Info(curX, curY, 0));
                    continue;
                }
                // 없으면 범위 갱신 후 계속 탐색
                range = dist;
            }

            // 상, 하, 좌, 우 탐색
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                // 맵을 벗어나거나 이미 지난 곳이면 넘어간다
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 크기가 큰 물고기는 먹을 수도, 지나갈 수도 없다
                if (map[nx][ny] > size) continue;

                // 크기가 작은 물고기는 먹을 수 있다.
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    eatable.add(new Info(nx, ny, dist + 1));
                }

                // 빈 공간이거나 크기가 같은 물고기의 경우
                // 먹을 수는 없지만, 지나갈 수 있다.
                visited[nx][ny] = true;
                queue.add(new Info(nx, ny, dist + 1));
            }
        }
        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 아기 상어
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs();
    }
}

class Info implements Comparable<Info> {
    int x, y, dist;

    Info(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Info o) {
        int comp1 = Integer.compare(this.dist, o.dist);
        if (comp1 != 0) return comp1;
        int comp2 = Integer.compare(this.x, o.x);
        if (comp2 != 0) return comp2;
        return Integer.compare(this.y, o.y);
    }
}