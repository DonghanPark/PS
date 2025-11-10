import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ32628 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] a = new long[N + 1];
        long[] b = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            a[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            b[i] = Long.parseLong(st.nextToken());

        long totalA = 0;
        long totalB = 0;
        for (int i = 1; i <= N; i++) {
            totalA += a[i];
            totalB += b[i];
        }

        long[] topA = new long[N + 1];
        long[] topB = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            topA[i] = topA[i - 1] + a[N - i + 1];
            topB[i] = topB[i - 1] + b[N - i + 1];
        }

        long minBag = Long.MAX_VALUE;

        for (int take = 0; take <= K; take++) {
            int takeB = K - take;

            if (take > N || takeB > N)
                continue;

            long remainA = totalA - topA[take];
            long remainB = totalB - topB[takeB];

            long wonbinBag = Math.max(remainA, remainB);
            minBag = Math.min(minBag, wonbinBag);
        }

        System.out.println(minBag);
    }
}
