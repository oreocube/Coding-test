import java.util.*;

public class P_1456_거의_소수 {
    static final int MAX = 10000001;
    static boolean[] check = new boolean[MAX];
    static ArrayList<Integer> prime = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        check[0] = check[1] = true;
        for (int i = 2; i < MAX; i++) {
            if (check[i]) continue;
            prime.add(i);
            for (int j = 2 * i; j < MAX; j += i) check[j] = true;
        }

        long count = 0;
        for (int p : prime) {
            long cur = p;
            while (cur <= B / p) {
                cur *= p;
                if (cur >= A) count++;
            }
        }
        System.out.println(count);
    }
}
