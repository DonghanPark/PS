import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ22236 {

    static long[][] dp;
    static int d;
    static long m;

    static long flight(int pos, int height) {
        if (pos == d) {
            return (height == 0) ? 1 : 0;
        }

        if (height == 0 && pos != 0) return 0;
        if (height < 0) return 0;

        if (dp[pos][height] != -1) return dp[pos][height];

        long localCount = 0;
        localCount = (localCount + flight(pos + 1, height + 1)) % m;
        localCount = (localCount + flight(pos + 1, height - 1)) % m;

        return dp[pos][height] = localCount;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        if (d % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp = new long[d + 1][d + 1];
        for (int i = 0; i <= d; i++)
            Arrays.fill(dp[i], -1);

        long answer = flight(0, 0) % m;

        System.out.println(answer);
    }
}
