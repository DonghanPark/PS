import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        final int NUM_OF_TICKET = 4;
        final int MONTH = 12;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // day, month, 3month, year
            st = new StringTokenizer(br.readLine());
            int[] ticketCost = new int[NUM_OF_TICKET];
            for (int i = 0; i < NUM_OF_TICKET; i++)
                ticketCost[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] plan = new int[MONTH + 1];
            for (int i = 1; i <= MONTH; i++)
                plan[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[MONTH + 1];
            for (int i = 1; i <= MONTH; i++) {
                int monthCost = Math.min(ticketCost[0] * plan[i], ticketCost[1]);
                dp[i] = monthCost + dp[i - 1];

                int threeMonthAgo = Math.max(0, i - 3);
                dp[i] = Math.min(dp[i], ticketCost[2] + dp[threeMonthAgo]);
            }

            dp[MONTH] = Math.min(dp[MONTH], ticketCost[3]);

            System.out.println("#" + test_case + " " + dp[MONTH]);
        }
    }
}