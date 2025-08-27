/*
* 몇 명에게 초대장 줘야 하는지
*
* 상원이랑 친한 친구
* 친한 친구의 친한 친구
*
* N 명 방문처리
* adj list
*
* 친한 친구 큐에 넣고
* 상원이랑 친한친구 한번 쫙 돌리면서 count++, 방문처리
* 큐 넣고
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adjList = new ArrayList[N+1];
            for (int i = 0; i < N + 1; i++)
                adjList[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int person1 = Integer.parseInt(st.nextToken());
                int person2 = Integer.parseInt(st.nextToken());

                adjList[person1].add(person2);
                adjList[person2].add(person1);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[N + 1];

            queue.offer(1);
            visited[1] = true;

            int count = 0;
            for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int curr = queue.poll();

                    for (int next : adjList[curr]) {
                        if (visited[next]) continue;

                        queue.offer(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + (count));
        }
    }
}
