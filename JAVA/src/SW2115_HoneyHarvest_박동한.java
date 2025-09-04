import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2115_HoneyHarvest_박동한 {
    static int N, M, C;
    static int[][] map;
    static int[][] bestHarvest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            bestHarvest = new int[N][Math.max(1, N - M + 1)];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int[] subHive = new int[M];
                    for (int k = 0; k < M; k++)
                        subHive[k] = map[i][j + k];
                    bestHarvest[i][j] = dfs(subHive, 0, 0, 0);
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    for (int k = i; k < N; k++) {
                        for (int l = 0; l < N - M + 1; l++) {
                            if (i == k && (l < j + M || j < l + M)) continue;

                            answer = Math.max(answer, bestHarvest[i][j] + bestHarvest[k][l]);
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static int dfs(int[] subHive, int index, int sum, int squardSum) {
        if (sum > C) return -1;
        if (index == subHive.length) return squardSum;

        int exclude = dfs(subHive, index + 1, sum, squardSum);
        int include = dfs(subHive, index + 1, sum + subHive[index], squardSum + subHive[index] * subHive[index]);

        return (include > exclude) ? include : exclude;
    }
}
