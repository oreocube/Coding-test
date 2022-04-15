import java.io.*;
import java.util.*;

public class P_17123_배열_놀이 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] row, col;

    static void operation(int r1, int c1, int r2, int c2, int v) {
        for (int i = r1; i <= r2; i++) row[i] += v * (c2 - c1 + 1);
        for (int i = c1; i <= c2; i++) col[i] += v * (r2 - r1 + 1);
    }

    static void appendResultString() {
        for (int i = 0; i < N; i++) sb.append(row[i]).append(' ');
        sb.append('\n');
        for (int i = 0; i < N; i++) sb.append(col[i]).append(' ');
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            row = new int[N];
            col = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    row[i] += x;
                    col[j] += x;
                }
            }

            int r1, c1, r2, c2, v;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                r1 = Integer.parseInt(st.nextToken()) - 1;
                c1 = Integer.parseInt(st.nextToken()) - 1;
                r2 = Integer.parseInt(st.nextToken()) - 1;
                c2 = Integer.parseInt(st.nextToken()) - 1;
                v = Integer.parseInt(st.nextToken());

                operation(r1, c1, r2, c2, v);
            }
            appendResultString();
        }
        System.out.println(sb);
    }
}
