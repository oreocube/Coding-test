import java.io.*;
import java.util.*;

public class P_19236_청소년_상어 {
    static final int SHARK = -1;
    static Fish[] fishInfo = new Fish[16 + 1];
    static int[][] map = new int[4][4];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    static void dfs(int x, int y, int dir, int sum) {
        answer = Math.max(answer, sum); // 최댓값 갱신

        // 원본 빼두기
        int[][] prevMap = copyMap();
        Fish[] prevFish = copyFish();

        // 물고기 이동
        moveFish();

        // 상어 이동
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if (map[nx][ny] == 0) continue;

            // 물고기 먹기
            int num = map[nx][ny];
            int nd = fishInfo[num].dir;
            fishInfo[num].isGone = true;
            map[nx][ny] = SHARK;
            map[x][y] = 0;

            // 다음
            dfs(nx, ny, nd, sum + num);

            // 원상복구
            map[x][y] = SHARK;
            map[nx][ny] = num;
            fishInfo[num].isGone = false;
        }
        map = prevMap;
        fishInfo = prevFish;
    }

    static void moveFish() {
        for (int i = 1; i <= 16; i++) {
            // 먹혀서 없다면 다음
            if (fishInfo[i].isGone) continue;

            Fish now = fishInfo[i];
            int x = now.x;
            int y = now.y;
            int dir = now.dir;

            for (int j = 0; j < 8; j++) {
                int nd = (dir + j) % 8;
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
                if (map[nx][ny] == SHARK) continue;

                // 이동할 위치에 다른 물고기가 있는지 체크
                if (map[nx][ny] == 0) {
                    map[x][y] = 0;
                } else {
                    // 원래 물고기 위치 수정
                    int origin = map[nx][ny];
                    fishInfo[origin].x = x;
                    fishInfo[origin].y = y;
                    map[x][y] = origin;
                }
                // 이동
                fishInfo[i].x = nx;
                fishInfo[i].y = ny;
                fishInfo[i].dir = nd;
                map[nx][ny] = i;
                break;
            }
        }
    }

    static int[][] copyMap() {
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, 4);
        }
        return copy;
    }

    static Fish[] copyFish() {
        Fish[] copy = new Fish[17];
        for (int i = 1; i < 17; i++) {
            Fish fish = fishInfo[i];
            copy[i] = new Fish(fish.x, fish.y, fish.dir, fish.isGone);
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물고기 위치 테이블 만들기
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                // 물고기 번호, 방향 입력받기
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = num;
                fishInfo[num] = new Fish(i, j, dir);
            }
        }

        int dir = fishInfo[map[0][0]].dir;
        fishInfo[map[0][0]].isGone = true;
        answer = map[0][0];
        map[0][0] = SHARK;
        dfs(0, 0, dir, answer);
        System.out.println(answer);
    }
}

class Fish {
    int x, y, dir;
    boolean isGone;

    Fish(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    Fish(int x, int y, int dir, boolean isGone) {
        this(x, y, dir);
        this.isGone = isGone;
    }
}