import java.io.*;
import java.util.*;

public class P_2961_도영이가_만든_맛있는_음식 {
    static int N;
    static int[][] arr;
    static boolean[] used;
    static long answer = Long.MAX_VALUE;

    // k 번째 재료 고르기
    static void dfs(int k, int last, long sour, long bitter) {
        if (k > 0) answer = Math.min(answer, Math.abs(sour - bitter));
        if (k == N) return;

        for (int i = last + 1; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(k + 1, i, sour * arr[i][0], bitter + arr[i][1]);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, -1, 1, 0);
        System.out.println(answer);
    }
}
