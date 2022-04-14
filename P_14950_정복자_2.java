import java.io.*;
import java.util.*;

public class P_14950_정복자_2 {
    static int N, M, T;
    static int[] root;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    // MST 구성하기
    static void solve() {
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        long sum = 0;
        int edgeCount = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int a = now.src;
            int b = now.dst;

            if (find(a) == find(b)) continue;

            union(a, b);
            sum += (long) T * edgeCount + now.cost;

            if (++edgeCount == N - 1) break;
        }

        System.out.println(sum);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot) root[aRoot] = bRoot;
        else root[bRoot] = aRoot;
    }

    static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        root = new int[N + 1];

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, c));
        }

        solve();
    }

    static class Edge implements Comparable<Edge> {
        int src, dst, cost;

        public Edge(int src, int dst, int cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

