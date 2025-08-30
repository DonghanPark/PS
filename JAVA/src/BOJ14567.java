import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            inDegree[B]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] semester = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adjList[curr]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                    semester[next] += semester[curr] + 1;
                }
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.print(semester[i] + " ");
    }
}
