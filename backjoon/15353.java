import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int upper = 0;
        for (int i = 0; i < Math.max(A.length(), B.length()); i++) {
            int a = 0, b = 0;

            if(i < A.length()) a = A.charAt(A.length() - 1 - i) - '0';
            if(i < B.length()) b = B.charAt(B.length() -1 - i) - '0';

            int rest = (a + b + upper) % 10;
            System.out.println(rest);
            upper = (a + b + upper) / 10;

            sb.append(rest);
        }
        if(upper == 1) sb.append(upper);

        System.out.println(sb.reverse());
    }
}
