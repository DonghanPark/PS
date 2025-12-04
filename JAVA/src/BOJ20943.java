import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20943 {
    private static class Gradient implements Comparable<Gradient> {
        long a, b;

        Gradient(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Gradient o) {
            if (this.a != o.a) return Long.compare(this.a, o.a);
            return Long.compare(this.b, o.b);
        }
    }

    private static long gcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Gradient[] gradients = new Gradient[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            Long.parseLong(st.nextToken());

            long g = gcd(a, b);
            a /= g;
            b /= g;

            if (a < 0) {
                a = -a;
                b = -b;
            }
            else if (a == 0 && b < 0) {
                b = -b;
            }

            gradients[i] = new Gradient(a, b);
        }

        Arrays.sort(gradients);

        long parallelPairs = 0L;
        long count = 1L;

        for (int i = 1; i < N; i++) {
            boolean isParallel = gradients[i].a == gradients[i - 1].a && gradients[i].b == gradients[i - 1].b;

            if (isParallel)
                count++;
            else {
                parallelPairs += count * (count - 1) / 2;
                count = 1;
            }
        }
        if (N > 0)
            parallelPairs += count * (count - 1) / 2;

        long totalPairs = (long) N * (N - 1) / 2;
        long answer = totalPairs - parallelPairs;

        System.out.println(answer);
    }
}
