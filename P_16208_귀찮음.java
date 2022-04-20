import java.io.*;
import java.util.*;

public class P_16208_귀찮음 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        long answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum -= arr[i];
            answer += (long) arr[i] * sum;
        }
        System.out.println(answer);
    }
}
