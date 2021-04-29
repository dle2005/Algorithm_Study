import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        String K = br.readLine();

        // 숫자를 제거
        for (int i = 0; i < sb.length(); i++) {
            if(!Character.isAlphabetic(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            }
        }

        String S = sb.toString();

        System.out.println(KMP(S, K));
    }

    public static int KMP(String S, String K) {
        int answer = 0;
        int[] pattern = getPattern(K);

        for (int i = 0, j = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != K.charAt(j))
                j = pattern[j - 1];

            if (S.charAt(i) == K.charAt(j)) {
                if (j == K.length() - 1) {
                    answer = 1;
                    break;
                }
                else j++;
            }
        }


        return answer;
    }

    public static int[] getPattern(String K) {
        int[] pattern = new int[K.length()];

        for (int i = 1, j = 0; i < K.length(); i++) {
            while(j > 0 && K.charAt(i) != K.charAt(j))
                j = pattern[j - 1];

            if(K.charAt(i) == K.charAt(j))
                pattern[i] = ++j;
        }

        return pattern;
    }
}
