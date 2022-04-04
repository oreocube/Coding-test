import java.util.*;

public class P_1562_계단수 {
    static final int MOD = 1000000000;
    // dp[len][k][status(bit)] : 길이가 len, 마지막 글자가 k, 방문 상태가 status 인 계단 수
    static long[][][] dp = new long[101][10][1 << 10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        // 길이가 1인 계단 수, i 번째 비트 방문 표시
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    // 현재 방문 상태가 k 일 때 j를 방문하려고 한다.
                    int next = k | (1 << j); // 다음 방문 상태
                    if (j != 0) {
                        dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j - 1][k]) % MOD;
                    }
                    if (j != 9) {
                        dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(sum);
    }
}
