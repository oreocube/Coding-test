import java.io.*;
import java.util.*;

public class P_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][3];
        int[][] dp = new int[N][3];

        // 점수판 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        for (int i = 0; i < 3; i++) {
            dp[0][i] = A[0][i];
        }

        // 최대 점수 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j] + A[i][j];

                if (j != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + A[i][j]);
                }
                if (j != 2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + A[i][j]);
                }
            }
        }
        sb.append(Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]))).append(' ');

        // 최소 점수 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j] + A[i][j];

                if (j != 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + A[i][j]);
                }
                if (j != 2) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + A[i][j]);
                }
            }
        }
        sb.append(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
        System.out.println(sb);
    }
}
