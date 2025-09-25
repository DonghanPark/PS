import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14712 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int bitSize = 1 << M;
        long[][] dp = new long[N + 1][bitSize];
        dp[0][0] = 1;

        for (int row = 0; row < N; row++) {
            for (int prevBit = 0; prevBit < bitSize; prevBit++) {
                if (dp[row][prevBit] == 0) continue;

                for (int currBit = 0; currBit < bitSize; currBit++) {
                    int x = prevBit & currBit;
                    boolean isNemmo = ( (x & (x << 1)) != 0 );
                    if (isNemmo) continue;

                    dp[row + 1][currBit] += dp[row][prevBit];
                }
            }
        }

        long answer = 0;
        for (int bit = 0; bit < bitSize; bit++)
            answer += dp[N][bit];

        System.out.println(answer);
    }
}
