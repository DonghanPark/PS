import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
* 그냥 처음 pq 돌리고
* 남은 거 다시 넣어서 돌리고
* 돌리고 돌리면 끝 아닌가?
* => 바로 시간 초과
*
* 큐를 달리 쓸 생각을 해야 함
* */
public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, (a, b) -> {
            int byEnd = Integer.compare(a[0], b[0]);
            return (byEnd != 0) ? byEnd : Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1])
                return Integer.compare(o1[0], o2[0]);
            else
                return Integer.compare(o1[1], o2[1]);
        });
        pq.offer(meetings[0]);

        int minMeetingRoom = 0;
        for (int i = 1; i < N; i++) {
            int end = pq.peek()[1];

            if (meetings[i][0] >= end)
                pq.poll();

            pq.offer(meetings[i]);

            minMeetingRoom = Math.max(minMeetingRoom, pq.size());
        }

        System.out.println(minMeetingRoom);
    }
}
