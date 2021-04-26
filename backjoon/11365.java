import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        while(true) {
            String s = br.readLine();
            if(s.equals("END")) break;

            Stack<String> stack = new Stack<>();
            st = new StringTokenizer(s, " ");
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                sb = sb.reverse();

                stack.add(sb.toString());
            }

            while (!stack.isEmpty())
                result.append(stack.pop()).append(" ");

            result.append("\n");
        }

        System.out.println(result);
    }
}
