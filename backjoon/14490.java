import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int a = Integer.parseInt(s.split(":")[0]);
        int b = Integer.parseInt(s.split(":")[1]);

        int max = 1;
        for(int i = 1; i <= Math.min(a, b); i++) {
            if(a % i == 0 && b % i == 0) max = Math.max(max, i);
        }

        sb.append(a/max).append(":").append(b/max);
        System.out.println(sb);
    }
}
