/*
* 다른 풀이 존재
* */
/*
* 도달 가능 횟수
* 이전 dir에 따라 지금 dir 결정
* 순서. 그 SWEA 파이프 연결 문제와 비슷한 듯
*
* N
* map
*
* dx
* dy
* dirs = {1, 2}, {1, 2, 3}, {2, 3}
* queue (x, y, dir)
*
* 탐색
* if (r,c) count++
* 3방
*   inRange
*   queue
* 
* => 다음으로 가는데 벽이 있는 거 체크 안함
* => 대각이면 3곳에 벽있는지 체크해야하는 거 빼먹음
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        int[][] dirs = {{0, 1}, {0, 1, 2}, {1, 2}};

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {0, 1, 0});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dir = curr[2];

            if (x == N - 1 && y == N - 1) {
                count++;
                continue;
            }

            for (int i = 0; i < dirs[dir].length; i++) {
                int nextDir = dirs[dir][i];
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == 1) continue;
                if (nextDir == 1 && (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)) continue;

                queue.offer(new int[] {nx, ny, nextDir});
            }
        }

        System.out.println(count);
    }
}
