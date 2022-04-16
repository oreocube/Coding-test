import java.io.*;

public class P_1347_미로_만들기 {
    static boolean[][] map = new boolean[103][103];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        // 0~50 51 52~102
        int top = 51, bottom = 51, left = 51, right = 51;
        int x = 51, y = 51, dir = 0;
        map[x][y] = true;

        for (int i = 0; i < N; i++) {
            char now = line.charAt(i);
            if (now == 'R') dir = (dir + 1) % 4;
            else if (now == 'L') dir = (dir + 3) % 4;
            else if (now == 'F') {
                x += dx[dir];
                y += dy[dir];
                top = Math.min(top, x);
                bottom = Math.max(bottom, x);
                left = Math.min(left, y);
                right = Math.max(right, y);
                map[x][y] = true;
            }
        }

        // 미로 출력
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (map[i][j]) sb.append('.');
                else sb.append('#');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
