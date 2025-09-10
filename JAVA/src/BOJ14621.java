import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *
 * class Edge (to, weight)
 *
 * N M
 * int[N] schoolType (M = 0, W = 1)
 * ArrayList<Edge>[] adjList
 *
 * int[N] dist
 * fill(dist, INF = 20000)
 *
 * PriorityQueue (low weight) (1,0)
 *
 * 탐색
 * for 인접
 * 	지금 타입과 다음 타입이 다른지 XOR
 *  dist[next] > curr_weight + next.weight
 *
 * => 이게 최소 경로를 구하면 뭐해. 모든 경로를 다 거쳤는지 알 수 없는데
 * => 그냥 연결하자
 * => 그래프는 그냥 연결만 하면되는 거고 그 연결의 최소 가중치를 구하는 거니까 어찌보면 조건이 MST를 말하는 것 같다.
 * => 재설계 시작
 *
 * make()
 * find()
 * union()
 *
 * int[N + 1] parent
 *
 * int[M][3] edgeList
 *
 * for M
 * 	if (같은 색이면 패스)
 *
 * */

public class BOJ14621 {
    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;

        parent[bRoot] = aRoot;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] schoolType = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            String type = st.nextToken();
            schoolType[i] = (type.equals("M") ? 0 : 1);
        }

        int[][] edgeList = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new int[] {from, to, weight};
        }

        Arrays.sort(edgeList, ((o1, o2) -> Integer.compare(o1[2], o2[2])));

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++)
            parent[i] = i;

        int answer = 0;
        int count = 0;
        for (int i = 0; i < M; i++) {
            int[] curr = edgeList[i];

            if (schoolType[curr[0]] == schoolType[curr[1]]) continue;
            if (!union(curr[0], curr[1])) continue;

            answer += curr[2];

            count++;
            if (count == N - 1) break;
        }

        if (count != N - 1) answer = -1;
        System.out.println(answer);
    }
}
