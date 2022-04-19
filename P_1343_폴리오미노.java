import java.io.*;

public class P_1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine()
                .replaceAll("XXXX", "AAAA")
                .replaceAll("XX", "BB");

        System.out.println(answer.contains("X") ? -1 : answer);
    }
}
