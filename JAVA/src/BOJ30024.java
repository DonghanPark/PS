import java.io.*;
import java.util.*;

public class BOJ30024 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[2], x[2]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                a[i][j] = v;

                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        pq.add(new int[]{i, j, v});
                    }
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int t = 0; t < K; t++) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];

            System.out.println((x + 1) + " " + (y + 1));

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.add(new int[]{nx, ny, a[nx][ny]});
            }
        }
    }
}
