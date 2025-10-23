import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ20924 {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static ArrayList<Edge>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, d));
            adj[b].add(new Edge(a, d));
        }

        if (N == 1) {
            System.out.println("0 0");
            return;
        }

        int cur = R;
        int prev = 0;
        int giga;
        int pillar = 0;

        while (true) {
            int degree = adj[cur].size();
            int childCount = (cur == R ? degree : degree - 1);

            if (childCount >= 2 || childCount == 0) {
                giga = cur;
                break;
            }

            for (Edge e : adj[cur]) {
                if (e.to == prev)
                    continue;

                pillar += e.w;
                prev = cur;
                cur = e.to;

                break;
            }
        }

        int longest = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{giga, prev, 0});

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int u = curr[0];
            int p = curr[1];
            int dist = curr[2];

            if (dist > longest)
                longest = dist;

            for (Edge e : adj[u]) {
                if (e.to == p)
                    continue;
                stack.push(new int[]{e.to, u, dist + e.w});
            }
        }

        System.out.println(pillar + " " + longest);
    }
}
