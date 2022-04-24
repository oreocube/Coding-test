import java.io.*;
import java.util.*;

public class P_18406_럭키_스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        int len = score.length();

        int left = 0, right = 0;
        for (int i = 0; i < len / 2; i++)
            left += score.charAt(i) - '0';

        for (int i = len / 2; i < len; i++)
            right += score.charAt(i) - '0';

        System.out.println(left == right ? "LUCKY" : "READY");
    }
}
