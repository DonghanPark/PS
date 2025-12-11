import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, ArrayList<Integer>> stationToLines = new HashMap<>();
        boolean[][] adj = new boolean[N + 1][N + 1];
        ArrayList<Integer> startLines = new ArrayList<>();

        for (int lineIdx = 1; lineIdx <= N; lineIdx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            for (int i = 0; i < K; i++) {
                long station = Long.parseLong(st.nextToken());

                if (station == 0L)
                    startLines.add(lineIdx);

                ArrayList<Integer> lines = stationToLines.get(station);
                if (lines != null) {
                    for (int prevLine : lines) {
                        if (!adj[lineIdx][prevLine]) {
                            adj[lineIdx][prevLine] = true;
                            adj[prevLine][lineIdx] = true;
                        }
                    }
                }
                else {
                    lines = new ArrayList<>();
                    stationToLines.put(station, lines);
                }
                lines.add(lineIdx);
            }
        }

        long dest = Long.parseLong(br.readLine());

        if (dest == 0L) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> destLines = stationToLines.get(dest);

        int answer = bfs(N, adj, startLines, destLines);
        System.out.println(answer);
    }

    private static int bfs(int N, boolean[][] adj,
                           ArrayList<Integer> startLines,
                           ArrayList<Integer> destLines) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new ArrayDeque<>();

        for (int line : startLines) {
            q.offer(new int[]{line, 0});
            visited[line] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int line = cur[0];
            int transfers = cur[1];

            if (destLines.contains(line))
                return transfers;

            for (int next = 1; next <= N; next++) {
                if (adj[line][next] && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, transfers + 1});
                }
            }
        }

        return -1;
    }
}
