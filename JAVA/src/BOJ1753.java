import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {
    static class Edge{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, weight));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.weight)));
        pq.offer(new Edge(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int to = curr.to;
            int weight = curr.weight;

            for (Edge next : adjList[to]) {
                int nextWeight = weight + next.weight;
                if (nextWeight > dist[next.to]) continue;

                dist[next.to] = nextWeight;
                pq.offer(new Edge(next.to, nextWeight));
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}

/*
 * 인접 리스트
 * 각 V별 K로부터 최단 거리 배열
 * 다익스트라 (우선순위 큐)
 * */
