import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int lastIdx = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        System.out.println(maxLen);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int cur = lastIdx; cur != -1; cur = parent[cur])
            stack.push(a[cur]);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}
