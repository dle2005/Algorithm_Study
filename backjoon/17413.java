import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        String s = br.readLine();

        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(flag) {
                sb.append(c);
            }

            if(c == '<') {
                temp = temp.reverse();
                sb.append(temp);
                temp = new StringBuilder();

                sb.append(c);
                flag = true;
            }
            else if(c == '>') {
                flag = false;
            }
            else if(!flag && c == ' ') {
                temp = temp.reverse();
                sb.append(temp).append(" ");
                temp = new StringBuilder();
            }
            else if(!flag) temp.append(c);
        }

        temp = temp.reverse();
        sb.append(temp);

        System.out.println(sb);
    }
}
