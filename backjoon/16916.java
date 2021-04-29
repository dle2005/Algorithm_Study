import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int[] pi = getPattern(P);

        int answer = 0;

        for(int i = 0, j = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j))
                j = pi[j - 1];

            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    answer = 1;
                    break;
                }
                else j++;
            }
        }

        System.out.println(answer);
    }

    public static int[] getPattern(String P) {
        int[] pattern = new int[P.length()];

        for (int i = 1, j = 0; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j))
                j = pattern[j - 1];

            if(P.charAt(i) == P.charAt(j))
                pattern[i] = ++j;
        }

        return pattern;
    }
}
