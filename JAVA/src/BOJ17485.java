import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17485 {
    private static boolean inRange(int x, int y, int N, int M) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // clockwise
        int[] dx = {-1, -1, -1};
        int[] dy = {0, 1, -1};

        int[][] dp = new int[N][M];
        int[][] prevDir = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int minFuel = Integer.MAX_VALUE;
                int minFuelDir = -1;
                for (int dir = 0; dir < 3; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (!inRange(nx, ny, N, M)) continue;
                    if (prevDir[nx][ny] == dir) continue;

                    if (dp[nx][ny] < minFuel) {
                        minFuel = dp[nx][ny];
                        minFuelDir = dir;
                    }
                }

                if (minFuel == Integer.MAX_VALUE)
                    minFuel = 0;

                dp[i][j] = map[i][j] + minFuel;
                prevDir[i][j] = minFuelDir;
            }
        }

        int finalMinFuel = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            finalMinFuel = Math.min(finalMinFuel, dp[N - 1][i]);
        }
        System.out.println(finalMinFuel);
    }
}
