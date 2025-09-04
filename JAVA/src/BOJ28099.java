import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ28099 {
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

            Map<Integer, List<Integer>> position = new HashMap<>();
            for (int i = 0; i < N; i++) {
                position.computeIfAbsent(array[i], k -> new ArrayList<>()).add(i);
            }

            List<Integer> keys = new ArrayList<>(position.keySet());
            keys.sort(Collections.reverseOrder());

            boolean isStrangeArray = true;
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int key : keys) {
                List<Integer> curr = position.get(key);
                int left = curr.get(0);
                int right = curr.get(curr.size() - 1);

                if (left < right) {
                    Integer large = treeSet.higher(left);
                    if (large != null && large < right) {
                        isStrangeArray = false;
                        break;
                    }
                }

                treeSet.addAll(curr);
            }

            System.out.println(isStrangeArray ? "Yes" : "No");
        }
    }
}
