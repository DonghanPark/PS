import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12970 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numOfA = 0;
        for (; numOfA < N / 2 + 1; numOfA++)
            if (numOfA * (N - numOfA) >= K) break;

        String answer = "";
        if (numOfA * (N - numOfA) < K)
            answer = "-1";
        else if (numOfA * (N - numOfA) == K) {
            for (int i = 0; i < numOfA; i++)
                answer += 'A';
            for(int i = 0; i < N - numOfA; i++)
                answer += 'B';
        }
        else {
            for (int i = 0; i < numOfA - 1; i++)
                answer += 'A';
            for (int i = 0; i < (numOfA * (N - numOfA)) - K; i++)
                answer += 'B';
            answer += 'A';
            int size = answer.length();
            for (int i = 0; i < N - size; i++) {
                answer += 'B';
            }
        }

        System.out.println(answer);
    }
}
