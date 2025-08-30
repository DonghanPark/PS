import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // clockwise
        int[] dx = {-1, -1, -1};
        int[] dy = {0, 1, -1};

        int[][][] dp = new int[N + 2][M + 2][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0][j] = 1_000_000;
                dp[i][M + 1][j] = 1_000_000;
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[1][i][j] = map[1][i];
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j][0] = map[i][j] + Math.min(dp[i + dx[0]][j + dy[0]][1], dp[i + dx[0]][j + dy[0]][2]);
                dp[i][j][1] = map[i][j] + Math.min(dp[i + dx[1]][j + dy[1]][0], dp[i + dx[1]][j + dy[1]][2]);
                dp[i][j][2] = map[i][j] + Math.min(dp[i + dx[2]][j + dy[2]][0], dp[i + dx[2]][j + dy[2]][1]);
            }
        }

        int minFuel = Integer.MAX_VALUE;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 3; j++) {
                minFuel = Math.min(minFuel, dp[N][i][j]);
            }
        }
        System.out.println(minFuel);
    }
}
