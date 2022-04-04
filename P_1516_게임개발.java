import java.io.*;
import java.util.*;

public class P_1516_게임개발 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] indeg, time;

    static void solve() {
        int[] done = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                done[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : adj[x]) {
                if (--indeg[y] == 0) queue.add(y);
                done[y] = Math.max(done[y], done[x] + time[y]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(done[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        time = new int[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                adj[x].add(i);
                indeg[i]++;
            }
        }

        solve();
    }
}
