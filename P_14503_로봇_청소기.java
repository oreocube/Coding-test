import java.io.*;
import java.util.*;

public class P_14503_로봇_청소기 {
    static int N, M, Answer;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서
    static boolean[][] cleaned;

    static void dfs(int x, int y, int face) {
        // 현재 위치에서 현재 방향을 기준으로, 왼쪽부터 인접한 칸을 탐색한다.
        for (int i = 0; i < 4; i++) {
            int d = (face + 3 - i) % 4;
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (map[nx][ny] != 0) continue;
            if (!cleaned[nx][ny]) {
                cleaned[nx][ny] = true;
                Answer++;
                dfs(nx, ny, d);
                return;
            }
        }

        // 네 방향 모두 이미 청소가 되었거나 벽인 경우
        int d = (face + 2) % 4;
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 작동을 멈춘다.
        if (map[nx][ny] == 1) return;
        // 후진 가능한 경우 바라보는 방향을 유지한채로 한칸 후진한다.
        dfs(nx, ny, face);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int face = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaned[startX][startY] = true;
        Answer = 1;
        dfs(startX, startY, face);
        System.out.println(Answer);
    }
}
