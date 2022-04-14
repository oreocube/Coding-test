import java.io.*;
import java.util.*;

public class P_14950_정복자 {
    static int N, M, T;
    static ArrayList<Info>[] adj;

    // MST 구성하기
    static void solve() {
        // 비용 순으로 정렬
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        boolean[] visited = new boolean[N + 1]; // 정복된 도시
        visited[1] = true;
        pq.addAll(adj[1]);

        long sum = 0;
        int edgeCount = 0;
        while (edgeCount < N - 1) { // N - 1개의 간선을 연결
            // 정복 가능한 도시 중 비용이 가장 적은 도시 고르기
            while (!pq.isEmpty()) {
                Info now = pq.poll();
                if (visited[now.node]) continue; // 이미 정복한 도시라면 다음으로 비용이 적은 도시

                visited[now.node] = true;
                pq.addAll(adj[now.node]);
                sum += (long) T * edgeCount + now.cost;
                break;
            }
            edgeCount++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[a].add(new Info(b, c));
            adj[b].add(new Info(a, c));
        }

        solve();
    }

    static class Info {
        int node;
        int cost;

        Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}

