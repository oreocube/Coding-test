import java.util.*;

public class P_2004_조합0의개수 {

    static long countV(long num, int v) {
        long count = 0;

        while (num >= v) {
            count += num / v;
            num /= v;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long R = sc.nextLong();

        long countFive = countV(N, 5) - countV(R, 5) - countV(N - R, 5);
        long countTwo = countV(N, 2) - countV(R, 2) - countV(N - R, 2);
        System.out.println(Math.min(countTwo, countFive));
    }
}
