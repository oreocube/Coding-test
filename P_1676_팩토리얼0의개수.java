import java.util.*;

public class P_1676_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 5 == 0) count++;
            if (i % 25 == 0) count++;
            if (i % 125 == 0) count++;
        }
        System.out.println(count);
    }
}
