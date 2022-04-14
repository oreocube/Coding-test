import java.io.*;
import java.util.*;

public class P_1759_암호_만들기 {
    static StringBuilder resultSb = new StringBuilder();
    static int L, C;
    static char[] alpha;
    static boolean[] used;

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static void dfs(int len, int last, StringBuilder sb) {
        if (len == L) {
            int mo = 0;
            String word = sb.toString();
            for (int i = 0; i < L; i++) {
                if (isVowel(word.charAt(i))) mo++;
            }
            if (mo >= 1 && L - mo >= 2) {
                resultSb.append(word).append('\n');
            }
            return;
        }
        for (int i = last + 1; i < C; i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(alpha[i]);

            dfs(len + 1, i, sb);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];
        used = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        dfs(0, -1, new StringBuilder());
        System.out.println(resultSb);
    }
}
