import java.io.*;
import java.util.*;

public class P_22945_팀_빌딩 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0, end = N - 1, answer = 0;
        while (start <= end) {
            answer = Math.max(answer, (end - start - 1) * Math.min(arr[start], arr[end]));

            if (arr[start] < arr[end])
                start++;
            else
                end--;
        }

        System.out.println(answer);
    }
}
