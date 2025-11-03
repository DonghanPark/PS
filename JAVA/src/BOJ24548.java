import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ24548 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String road = br.readLine();

        long[][][][] cnt = new long[3][3][3][3];
        int T = 0;
        int G = 0;
        int P = 0;
        int F = 0;
        cnt[T][G][P][F] = 1;

        for (int i = 0; i < N; i++) {
            char c = road.charAt(i);

            if (c == 'T')
                T = (T + 1) % 3;
            else if (c == 'G')
                G = (G + 1) % 3;
            else if (c == 'P')
                P = (P + 1) % 3;
            else if (c == 'F')
                F = (F + 1) % 3;

            cnt[T][G][P][F]++;
        }

        long answer = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++) {
                        long n = cnt[i][j][k][l];
                        answer += n * (n - 1) / 2;
                    }

        System.out.println(answer);
    }
}
