import java.io.*;
import java.util.*;

public class P_17276_배열_돌리기 {
    static StringBuilder sb = new StringBuilder();

    static void rotateRight(int N, int count, int[][] arr) {
        while (count-- > 0) {
            int[] tmp = new int[N];

            // 대각선 훔치기
            for (int i = 0; i < N; i++) {
                tmp[i] = arr[i][i];
            }

            // 중앙 가로선 옮기기
            for (int i = 0; i < N; i++) {
                arr[i][i] = arr[N / 2][i];
            }

            for (int i = 0; i < N; i++) {
                arr[N / 2][i] = arr[(N - i) - 1][i];
            }

            for (int i = 0; i < N; i++) {
                arr[(N - i) - 1][i] = arr[(N - i) - 1][N / 2];
            }

            for (int i = 0; i < N; i++) {
                arr[(N - i) - 1][N / 2] = tmp[(N - i) - 1];
            }
        }
    }

    static void rotateLeft(int N, int count, int[][] arr) {
        while (count-- > 0) {
            int[] tmp = new int[N];

            for (int i = 0; i < N; i++) {
                tmp[i] = arr[i][i];
            }

            for (int i = 0; i < N; i++) {
                arr[i][i] = arr[i][N / 2];
            }

            for (int i = 0; i < N; i++) {
                arr[i][N / 2] = arr[i][(N - i) - 1];
            }

            for (int i = 0; i < N; i++) {
                arr[i][(N - i) - 1] = arr[N / 2][(N - i) - 1];
            }

            for (int i = 0; i < N; i++) {
                arr[N / 2][(N - i) - 1] = tmp[(N - i) - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = Math.abs(D / 45) % 8;
            if (D > 0) rotateRight(N, count, arr);
            else rotateLeft(N, count, arr);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]);
                    if (j != N - 1) sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
