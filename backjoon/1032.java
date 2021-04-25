import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N];

        for (int i = 0; i < N; i++)
            inputs[i] = br.readLine();

        String answer = "";

        for(int i = 0; i < inputs[0].length(); i++) {
            char c = inputs[0].charAt(i);
            boolean flag = true;

            for(int j = 1; j < N; j++) {
                if(inputs[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer += c;
            else answer += "?";
        }

        System.out.println(answer);
    }
}
