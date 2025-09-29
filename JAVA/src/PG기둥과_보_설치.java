import java.util.*;
/*
기둥을 설치할 때는 y index가 0인지, ((x-1, y) or (x, y))가 보인지, (x, y-1)이 기둥인지
보를 설치할 때는 (x, y - 1)이 기둥인지, ((x - 1, y), (x + 1, y)) 둘 다 보인지

기둥 삭제할 때는 ((x-1, y+1), (x, y+1)) 둘 중 하나에 보가 있으면 둘 다 보인지
(x, y+1)이 기둥이면 ((x-1, y+1), (x, y+1)) 둘 다 보인지

보 삭제할 때는 ((x-1, y),(x+1, y)) 둘 다 보인지, (x, y)에 기둥이 없거나,
(x, y)에 기둥이 있으면 (x, y-1)에 기둥이 있거나, (x-1, y)에 보가 있거나
(x+1, y)에 기둥이 있으면 (x+1, y-1)에 기둥이 있거나, (x+1, y)에 보가 있거나
*/

class PG기둥과_보_설치 {
    static boolean[][] pillar, beam;
    static int N;

    static boolean inRange(int x, int y) {
        return 0 <= x && x <= N && 0 <= y && y <= N;
    }

    static boolean checkAfterRemoveBeam(int x, int y) {
        // 양 끝 기둥
        if (inRange(x, y) && pillar[x][y] && !canPillar(x, y))
            return false;
        if (inRange(x+1, y) && pillar[x+1][y] && !canPillar(x+1, y))
            return false;
        // 양쪽 보
        if (inRange(x-1, y) && beam[x-1][y] && !canBeam(x-1, y))
            return false;
        if (inRange(x+1, y) && beam[x+1][y] && !canBeam(x+1, y))
            return false;

        return true;
    }

    static boolean checkAfterRemovePillar(int x, int y) {
        // 위 기둥
        if (inRange(x, y+1) && pillar[x][y+1] && !canPillar(x, y+1))
            return false;
        // 왼쪽 위 보
        if (inRange(x-1, y+1) && beam[x-1][y+1] && !canBeam(x-1, y+1))
            return false;
        // 오른쪽 위 보
        if (inRange(x, y+1) && beam[x][y+1] && !canBeam(x, y+1))
            return false;

        return true;
    }

    // 보 설치 가능: (아래 기둥) || (오른쪽 아래 기둥) || (양쪽 보)
    static boolean canBeam(int x, int y) {
        if (x+1 > N)
            return false;

        if (y-1 >= 0 && (pillar[x][y-1] || pillar[x+1][y-1]))
            return true;

        boolean leftBeam  = (x-1 >= 0) && beam[x-1][y];
        boolean rightBeam = beam[x+1][y];
        if (leftBeam && rightBeam)
            return true;

        return false;
    }

    // 기둥 설치 가능: 바닥 || 아래 기둥 || (왼쪽보) || (오른쪽보)
    static boolean canPillar(int x, int y) {
        if (y == 0)
            return true;
        if (y-1 >= 0 && pillar[x][y-1])
            return true;
        if (x - 1 >= 0 && beam[x - 1][y])
            return true;
        if (beam[x][y])
            return true;

        return false;
    }

    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        pillar = new boolean[n + 1][n + 1];
        beam   = new boolean[n + 1][n + 1];

        for (int[] cmd : build_frame) {
            int x = cmd[0];
            int y = cmd[1];
            int isBeam = cmd[2];
            int install = cmd[3];

            if (install == 1) {
                if (isBeam == 0) {
                    if (canPillar(x, y)) {
                        pillar[x][y] = true;
                    }
                } else {
                    if (canBeam(x, y)) {
                        beam[x][y] = true;
                    }
                }
            }
            else {
                if (isBeam == 0) {
                    pillar[x][y] = false;
                    if (!checkAfterRemovePillar(x, y)) {
                        pillar[x][y] = true;
                    }
                } else {
                    beam[x][y] = false;
                    if (!checkAfterRemoveBeam(x, y)) {
                        beam[x][y] = true;
                    }
                }
            }
        }

        ArrayList<int[]> ans = new ArrayList<>();
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y])
                    ans.add(new int[]{x, y, 0});
                if (beam[x][y])
                    ans.add(new int[]{x, y, 1});
            }
        }

        ans.sort((p, q) -> {
            if (p[0] != q[0]) return p[0]-q[0];
            if (p[1] != q[1]) return p[1]-q[1];
            return p[2]-q[2];
        });

        return ans.toArray(new int[0][]);
    }
}