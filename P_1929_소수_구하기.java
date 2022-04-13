import java.util.*;

public class P_1929_소수_구하기 {
    static boolean[] check = new boolean[1000001];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int M, N;
        M = sc.nextInt();
        N = sc.nextInt();

        check[0] = check[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!check[i]) {
                for (int j = i; j <= N; j += i) {
                    if (j == i) continue;
                    check[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!check[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
