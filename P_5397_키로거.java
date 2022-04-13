import java.io.*;
import java.util.*;

public class P_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();
            LinkedList<Character> list = new LinkedList<>();

            int cursor = 0;
            for (int i = 0; i < line.length(); i++) {
                char now = line.charAt(i);

                if (now == '<') {
                    if (cursor != 0) cursor--;
                } else if (now == '>') {
                    if (cursor != list.size()) cursor++;
                } else if (now == '-') {
                    if (cursor != 0) list.remove(--cursor);
                } else {
                    list.add(cursor++, now);
                }
            }

            for (char c : list) sb.append(c);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
