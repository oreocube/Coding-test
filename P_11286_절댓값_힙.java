import java.io.*;
import java.util.*;

public class P_11286_절댓값_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> posQ = new PriorityQueue<>();
        PriorityQueue<Integer> negQ = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        int tt = Integer.parseInt(br.readLine());

        while (tt-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) posQ.add(x);
            else if (x < 0) negQ.add(-x);
            else {
                if (posQ.isEmpty() && negQ.isEmpty()) {
                    sb.append(0).append('\n');
                    continue;
                }

                if (posQ.isEmpty() && !negQ.isEmpty()) {
                    sb.append(-negQ.poll()).append('\n');
                    continue;
                }

                if (negQ.isEmpty() && !posQ.isEmpty()) {
                    sb.append(posQ.poll()).append('\n');
                    continue;
                }

                // 절댓값이 작은 값 찾기
                int pos = posQ.peek();
                int neg = negQ.peek();

                if (pos < neg)
                    sb.append(posQ.poll()).append('\n');
                else if (pos > neg)
                    sb.append(-negQ.poll()).append('\n');
                else
                    sb.append(-negQ.poll()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
