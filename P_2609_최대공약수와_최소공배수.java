import java.io.*;
import java.util.*;

public class P_2609_최대공약수와_최소공배수 {
    static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int gcd = GCD(N, M);
        int lcm = (N * M) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
