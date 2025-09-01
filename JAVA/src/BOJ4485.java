import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485{
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;
        while (true) {
            count++;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.offer(new int[]{0, 0, cave[0][0]});
            dist[0][0] = cave[0][0];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int x = curr[0];
                int y = curr[1];
                int weight = curr[2];

                if (x == N - 1 && y == N - 1) {
                    System.out.println("Problem " + count + ": " + weight);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    int nextWeight = weight + cave[nx][ny];
                    if (nextWeight >= dist[nx][ny]) continue;

                    pq.offer(new int[] {nx, ny, nextWeight});
                    dist[nx][ny] = nextWeight;
                }
            }

        }
    }
}

/*
* n에 0 들어오면 중단
* 
* 2차원 배열
* 
* qeueu에 넣는데 우선순위 큐로
* */