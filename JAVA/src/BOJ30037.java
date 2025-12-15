import java.io.*;
import java.util.*;

public class BOJ30037 {
    private static boolean isDelimeter(String t) {
        return t.equals("!") || t.equals("?") || t.equals(",") || t.equals(".");
    }

    private static String capitalizeWord(String word) {
        if (word == null || word.isEmpty()) return word;
        char c = word.charAt(0);
        if (c >= 'a' && c <= 'z') return Character.toUpperCase(c) + word.substring(1);
        return word;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line == null) line = "";

            List<String> tokens = new ArrayList<>();
            String delims = " !?,.";
            StringTokenizer st = new StringTokenizer(line, delims, true);

            while (st.hasMoreTokens()) {
                String tok = st.nextToken();
                if (tok.equals(" ")) continue;
                tokens.add(tok);
            }

            List<String> ofKorea = new ArrayList<>();
            for (int j = 0; j < tokens.size(); ) {
                if (tokens.get(j).equals("of")
                        && j + 1 < tokens.size()
                        && tokens.get(j + 1).equals("Korea")
                        && !ofKorea.isEmpty()
                        && !isDelimeter(ofKorea.get(ofKorea.size() - 1))) {

                    String word = capitalizeWord(ofKorea.get(ofKorea.size() - 1));
                    ofKorea.set(ofKorea.size() - 1, "K-" + word);
                    j += 2;
                }
                else {
                    ofKorea.add(tokens.get(j));
                    j++;
                }
            }

            List<String> korea = new ArrayList<>();
            for (int j = ofKorea.size() - 1; j >= 0; j--) {
                String t = ofKorea.get(j);
                if (t.equals("Korea")
                        && !korea.isEmpty()
                        && !isDelimeter(korea.get(korea.size() - 1))) {

                    String word = capitalizeWord(korea.get(korea.size() - 1));
                    korea.set(korea.size() - 1, "K-" + word);
                }
                else {
                    korea.add(t);
                }
            }
            Collections.reverse(korea);

            String answer = "";
            for (int j = 0; j < korea.size(); j++) {
                answer += korea.get(j);
                if (j + 1 < korea.size() && !isDelimeter(korea.get(j + 1))) answer += " ";
            }

            System.out.println(answer);
        }
    }
}
