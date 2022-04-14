import java.io.*;
import java.util.*;

public class P_5671_호텔_방_번호 {
    static int N, M;

    static boolean check(int x) {
        boolean[] visited = new boolean[10];
        while (x > 0) {
            // x를 일의 자리부터 숫자 체크
            int t = x % 10;
            if (visited[t]) return false;
            visited[t] = true;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String line = br.readLine();

            if (line == null || line.equals("")) break;

            st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int i = N; i <= M; i++) {
                if (check(i)) count++;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
