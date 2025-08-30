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
        ArrayList<Integer>[] preBuildings = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            preBuildings[i] = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int preBuilding = Integer.parseInt(st.nextToken());

                if (preBuilding == -1) break;

                inDegree[i]++;
                adjList[preBuilding].add(i);
                preBuildings[i].add(preBuilding);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] != 0) continue;

            queue.add(i);
        }

        int[] minCost = new int[N + 1];
        System.arraycopy(cost, 0, minCost, 0, N + 1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int preBuilding : preBuildings[curr]) {
                minCost[curr] += cost[preBuilding];
            }

            for (int next : adjList[curr]) {
                inDegree[next]--;
                if (inDegree[next] != 0) continue;

                queue.add(next);
            }
        }

        for (int i = 1; i < N + 1; i++)
            System.out.println(minCost[i]);
    }
}
