import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N + 1];
        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int preBuilding = Integer.parseInt(st.nextToken());

                if (preBuilding == -1) break;

                inDegree[i]++;
                adjList[preBuilding].add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int[] minCost = Arrays.copyOf(cost, N + 1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adjList[curr]) {
                minCost[next] = Math.max(minCost[next], minCost[curr] + cost[next]);

                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.add(next);
            }
        }

        for (int i = 1; i < N + 1; i++)
            System.out.println(minCost[i]);
    }
}