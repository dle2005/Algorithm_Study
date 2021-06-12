import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(n + 1, 3)];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;

        System.out.println(dp[n]);
    }
}
