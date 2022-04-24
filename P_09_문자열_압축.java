public class P_09_문자열_압축 {
    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            StringBuilder sb;

            for (int len = 1; len <= s.length() / 2; len++) {
                sb = new StringBuilder();
                int count = 1;
                String prev = s.substring(0, len);

                for (int i = len; i < s.length(); i += len) {
                    String now = s.substring(i, Math.min(i + len, s.length()));
                    if (now.equals(prev)) count++;
                    else {
                        if (count != 1) sb.append(count);
                        sb.append(prev);
                        prev = now;
                        count = 1;
                    }
                }

                if (count != 1) sb.append(count);
                sb.append(prev);

                answer = Math.min(answer, sb.toString().length());
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ababcdcdababcdcd"));

    }
}
