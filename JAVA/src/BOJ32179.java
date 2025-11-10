import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ32179 {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] trace = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            trace[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int start = 1, end = N;
        for (int i = 0; i < K; i++) {
            int mid = (start + end) / 2;
            arr[mid] = trace[i];

            if (i == K-1) break;

            if (trace[i + 1] > trace[i])
                start = mid + 1;
            else
                end = mid - 1;
        }

        long[][] comb = new long[101][101];
        for (int i = 0; i <= 100; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++)
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
        }

        long answer = 1L;
        int i = 1;
        int leftValue = 0;

        while (i <= N) {
            if (arr[i] != 0) {
                leftValue = arr[i];
                i++;
                continue;
            }

            int emptyStart = i;
            while (i <= N && arr[i] == 0)
                i++;
            int emptyEnd = i - 1;
            int countEmpty = emptyEnd - emptyStart + 1;

            int rightValue = (i <= N && arr[i] != 0) ? arr[i] : 101;

            int range = rightValue - leftValue - 1;

            long ways = comb[range][countEmpty];
            answer = (answer * ways) % MOD;
        }

        System.out.println(answer % MOD);
    }
}
