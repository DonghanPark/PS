import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24041 {
    static int N;
    static long G;
    static int K;
    static int[][] ingredient;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        G = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ingredient = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken()); // S
            ingredient[i][1] = Integer.parseInt(st.nextToken()); // L
            ingredient[i][2] = Integer.parseInt(st.nextToken()); // O (0 = 중요, 1 = 중요X)
        }

//        int answer = 0;
//
//        for (int x = 0; x <= 2_000_000_000; x++) {
//            if (!canEat(x)) {
//                answer = x - 1;
//                break;
//            }
//
//            if (x == 2_000_000_000) {
//                answer = x;
//            }
//        }

        int lo = 0;
        int hi = 2_000_000_000;
        int answer = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canEat(mid)) {
                answer = mid;
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }

        System.out.println(answer);
    }

    static boolean canEat(long x) {
        long sum = 0L;
        ArrayList<Long> optional = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long s = ingredient[i][0];
            long l = ingredient[i][1];
            int o = ingredient[i][2];

            long days = x - l;
            if (days < 1) days = 1;

            long bacteria = s * days;

            if (o == 0) {
                sum += bacteria;
                if (sum > G)
                    return false;
            }
            else {
                optional.add(bacteria);
            }
        }


        if (!optional.isEmpty()) {
            optional.sort(Collections.reverseOrder());

            int size = optional.size();
            int start = Math.min(K, size);

            for (int i = start; i < size; i++) {
                sum += optional.get(i);
                if (sum > G)
                    return false;
            }
        }

        return sum <= G;
    }
}
