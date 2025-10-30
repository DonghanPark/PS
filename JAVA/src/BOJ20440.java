import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] mosquitoTime = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            mosquitoTime[i][0] = start;
            mosquitoTime[i][1] = end;
        }

        Arrays.sort(mosquitoTime, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxCnt = 0;
        int maxStart = -1;
        int maxEnd = -1;
        boolean inMaxRange = false;

        for (int i = 0; i < N; i++) {
            int curStart = mosquitoTime[i][0];
            int curEnd   = mosquitoTime[i][1];

            while (!pq.isEmpty() && pq.peek() <= curStart) {
                if (inMaxRange && pq.peek() != curStart)
                    inMaxRange = false;

                pq.poll();
            }

            pq.offer(curEnd);

            if (pq.size() > maxCnt) {
                maxCnt = pq.size();
                maxStart = curStart;
                maxEnd = pq.peek();
                inMaxRange = true;
            }
            else if (pq.size() == maxCnt && inMaxRange)
                maxEnd = pq.peek();
        }

        System.out.println(maxCnt);
        System.out.println(maxStart + " " + maxEnd);
    }
}
