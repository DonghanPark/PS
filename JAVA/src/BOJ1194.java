
/*
* A = 'a' - 32
*
* N M
* map
*
* set
* dx, dy
* queue
* 탐색
* 꺼내고
* 1이면 끝
* 4방
* inRange
* 벽
* 열쇠 X
* queue 추가
* 
* => 메모리 초과
* 
* => 비트로 visited 체크
* 
* => 이미 방문됨 처리 빼먹음
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1194 {
    static class Minsik {
        int x;
        int y;
        int move;
        int keys;

        public Minsik(int x, int y, int move, int keys) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        Minsik minsik = null;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == '0')
                    minsik = new Minsik(i, j, 0, 0);
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][][] visited = new boolean[N][M][(1 << 6)];
        Queue<Minsik> queue = new ArrayDeque<>();

        queue.offer(minsik);
        visited[minsik.x][minsik.y][minsik.keys] = true;

        int minMove = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Minsik curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int move = curr.move;
            int keys = curr.keys;

            if (map[x][y] == '1') {
                minMove = move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny][keys]) continue;
                if (map[nx][ny] == '#') continue;
                if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F' && (keys & (1 << (map[nx][ny] - 'A'))) == 0) continue;

                int nextKeys = keys;
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f')
                    nextKeys = nextKeys | (1 << (map[nx][ny] - 'a'));

                queue.offer(new Minsik(nx, ny, move + 1, nextKeys));
                visited[nx][ny][nextKeys] = true;
            }
        }

        if (minMove == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minMove);

    }
}
