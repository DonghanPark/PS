import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> order = new ArrayList<>();

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                order.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < order.size() - 1; j++) {
                adjList[order.get(j)].add(order.get(j + 1));
                inDegree[order.get(j + 1)]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            answer.add(curr);

            for (int next : adjList[curr]) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    queue.add(next);
            }
        }

        if (answer.size() != N)
            System.out.println(0);
        else {
            for (int num : answer)
                System.out.println(num);
        }
    }
}
