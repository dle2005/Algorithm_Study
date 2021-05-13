import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String all = "11111111111111111111";
        String empty = "00000000000000000000";
        StringBuilder S = new StringBuilder(empty);

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String operator = st.nextToken();

            if (operator.equals("add")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                S.replace(index, index+1, "1");
            }
            if (operator.equals("remove")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                S.replace(index, index+1, "0");
            }
            if (operator.equals("check")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                if(S.charAt(index) == '1') sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            if (operator.equals("toggle")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                if(S.charAt(index) == '0') S.replace(index, index+1, "1");
                else S.replace(index, index+1, "0");
            }
            if (operator.equals("all")) {
                S = new StringBuilder(all);
            }
            if (operator.equals("empty")) {
                S = new StringBuilder(empty);
            }
        }

        System.out.println(sb);
    }
}
