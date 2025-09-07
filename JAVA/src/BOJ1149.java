
/*
* DP인데 그냥 2차원 배열로 [N+1][3]을 받고
* 자기 줄 바로 위 말고 다른 것들만 받기
*
* N
* houseColorCost[N + 2][3]
*
* dp[i][0] = houseColorCost[i][0] + min(dp[i-1][1], dp[i-1][2])
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] houseColorCost = new int[N + 2][3];
        int[][] dp = new int[N + 2][3];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houseColorCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N + 2; i++) {
            dp[i][0] = houseColorCost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = houseColorCost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = houseColorCost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(dp[N + 1][0], Math.min(dp[N + 1][1], dp[N + 1][2])));
    }
}
