import java.util.ArrayDeque;
import java.util.Queue;

class PG네트워크 {
    public int main(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int j = 0; j < n; j++) {
                    if (computers[curr][j] == 0) continue;
                    if (visited[j]) continue;

                    queue.offer(j);
                    visited[j] = true;
                }
            }
            answer++;
        }

        return answer;
    }
}