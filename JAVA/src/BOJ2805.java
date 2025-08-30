import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long[] tree =  new long[N];
        st = new StringTokenizer(br.readLine());

        long maxTree = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            maxTree = Math.max(maxTree, tree[i]);
        }

        long answer = 0L;
        long minTree = 0L;
        while (minTree <= maxTree) {
            long midTree = (minTree + maxTree) / (long) 2;
            long cuttedTrees = 0L;

            for (int i = 0; i < N; i++) {
                if (tree[i] > midTree)
                    cuttedTrees += tree[i] - midTree;
            }

            if (cuttedTrees < M)
                maxTree = midTree - 1;
            else {
                answer = midTree;
                minTree = midTree + 1;
            }
        }

        System.out.println(answer);
    }
}
