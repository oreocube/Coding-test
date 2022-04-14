import java.io.*;
import java.util.*;

public class P_6137_문자열_생성 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        int start = 0, end = N - 1, len = 0;
        while (start <= end) {
            if (arr[start] < arr[end]) sb.append(arr[start++]);
            else if (arr[start] > arr[end]) sb.append(arr[end--]);
            else {
                int i = start, j = end;
                while (i <= j) {
                    if (arr[i] < arr[j]) {
                        sb.append(arr[start++]);
                        break;
                    } else if (arr[i] > arr[j]) {
                        sb.append(arr[end--]);
                        break;
                    }
                    i++;
                    j--;
                }
                // 계속 같으면 아무거나
                if (i > j) sb.append(arr[start++]);
            }
            if (++len % 80 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }
}
