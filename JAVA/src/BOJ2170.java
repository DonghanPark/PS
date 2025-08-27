import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] lines = new int[N][2];
        final int OFFSET = 1_000_000_000;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + OFFSET;
            int y = Integer.parseInt(st.nextToken()) + OFFSET;

            lines[i] = new int[]{x, y};
        }

        Arrays.sort(lines, (o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            else
                return Integer.compare(o1[0], o2[0]);
        });

        int left = 0;
        int right = 0;
        int lineLength = 0;
        for (int i = 0; i < N; i++) {
            if (lines[i][0] <= right) {
                right = Math.max(right, lines[i][1]);
            }
            else {
                lineLength += right - left;
                left = lines[i][0];
                right = lines[i][1];
            }
        }
        lineLength += right - left;

        System.out.println(lineLength);
    }
}
