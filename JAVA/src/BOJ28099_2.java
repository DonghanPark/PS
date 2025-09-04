import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ28099_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] array = new int[N];
            for (int i = 0; i < N; i++)
                array[i] = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> first = new HashMap<>();
            Map<Integer, Integer> last  = new HashMap<>();
            for (int i = 0; i < N; i++) {
                first.putIfAbsent(array[i], i);
                last.put(array[i], i);
            }
            
            boolean isStrangeArray = true;
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                if (first.get(array[i]) == i)
                    treeSet.add(array[i]);

                if (last.get(array[i]) == i)
                    treeSet.remove(array[i]);

                if (!treeSet.isEmpty() && array[i] > treeSet.first()) {
                    isStrangeArray = false;
                    break;
                }
            }

            System.out.println(isStrangeArray ? "Yes" : "No");
        }
    }
}
