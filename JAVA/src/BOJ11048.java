import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {
    private static boolean inRange(int x, int y, int N, int M) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // counterclockwise
        int[] dx = {-1, -1, 0};
        int[] dy = {0, -1, -1};

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxDP = 0;
                for (int dir = 0; dir < 3; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (!inRange(nx, ny, N, M)) continue;

                    maxDP = Math.max(maxDP, dp[nx][ny]);
                }
                dp[i][j] = maxDP + maze[i][j];
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
