import java.io.*;
import java.util.*;

public class P_08_문자열_재정렬 {
    static char[] charArr = new char[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String s = br.readLine();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (Character.isDigit(now)) sum += now - '0';
            else charArr[count++] = now;
        }

        Arrays.sort(charArr, 0, count);

        for (int i = 0; i < count; i++) answer.append(charArr[i]);
        answer.append(sum);

        System.out.println(answer);
    }
}
