import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] adjList;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int to = Integer.parseInt(st.nextToken());
                adjList[i].add(to);
                adjList[to].add(i);
            }
        }

        selected = new boolean[N + 1];

        dfs(1);

        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == N + 1) {
            if (!isValidDivision())
                return;

            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (selected[i]) A.add(i);
                else B.add(i);
            }

            if (isConnected(A) && isConnected(B)) {
                int diff = Math.abs(sum(A) - sum(B));
                answer = Math.min(answer, diff);
            }

            return;
        }

        selected[idx] = true;
        dfs(idx + 1);

        selected[idx] = false;
        dfs(idx + 1);
    }

    static boolean isValidDivision() {
        int countTrue = 0;
        for (int i = 1; i <= N; i++)
            if (selected[i])
                countTrue++;

        return countTrue != 0 && countTrue != N;
    }

    static boolean isConnected(ArrayList<Integer> electoralDistrict) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(electoralDistrict.get(0));
        visited[electoralDistrict.get(0)] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adjList[cur]) {
                if (!visited[next] && electoralDistrict.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count == electoralDistrict.size();
    }

    static int sum(ArrayList<Integer> electoralDistrict) {
        int sum = 0;
        for (int x : electoralDistrict)
            sum += population[x];
        return sum;
    }
}
