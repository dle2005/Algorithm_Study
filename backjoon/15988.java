import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;

        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] dp = new long[Math.max(max+1, 4)];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= max; i++)
            dp[i] = ((dp[i-3] + dp[i-2]) % 1000000009 + dp[i-1]) % 1000000009;

        for(int i : arr)
            sb.append(dp[i]).append("\n");

        System.out.println(sb);
    }
}
