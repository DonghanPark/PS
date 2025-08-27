import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐 (끝나는 순), 2차원
// 이전에 끝난 시간
// 지금 시작 시간이 크면 회의 가능
// count ++

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {end, start});
        }

        int time = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] curr = pq.poll();
            int end = curr[0];
            int start = curr[1];

            if (start >= time) {
                time = end;
                count++;
            }
        }

        System.out.println(count);
    }
}
