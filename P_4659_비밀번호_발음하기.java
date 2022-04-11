import java.io.*;

public class P_4659_비밀번호_발음하기 {

    static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static boolean isAcceptable(String s) {
        int mo = 0, ja = 0, lastMo = -1, lastJa = -1;
        char prev = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            // 같은 글자가 연속으로 두번 오면 안됨
            if (i > 0 && prev == now && prev != 'e' && prev != 'o')
                return false;

            // 자음인지 모음인지
            if (isVowel(now)) {
                mo++;
                lastMo = i;
            } else {
                ja++;
                lastJa = i;
            }

            // 모음 또는 자음이 연속 3번 X
            if (Math.abs(lastJa - lastMo) >= 3) return false;

            prev = now;
        }
        return mo != 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String pw = br.readLine();

            if (pw.equals("end")) break;

            sb.append("<").append(pw).append("> is");
            if (!isAcceptable(pw)) sb.append(" not");
            sb.append(" acceptable.\n");
        }
        System.out.println(sb);
    }
}
