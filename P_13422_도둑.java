import java.util.*;
import java.io.*;

public class P_13422_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];
            int[] dp = new int[N + M];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = dp[i - 1] + arr[i];
            }

            for (int i = 1; i < M; i++) {
                dp[N + i] = dp[N + i - 1] + arr[i];
            }

            if (N == M) {
                if (dp[M] - dp[0] < K) sb.append(1).append('\n');
                else sb.append(0).append('\n');
                continue;
            }

            int count = 0;
            int start = 0;
            for (int end = M; end < dp.length; end++) {
                if (dp[end] - dp[start++] < K) count++;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
