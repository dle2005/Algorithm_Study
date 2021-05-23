import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0, k = i - 1; j < i && k >= 0; j++, k--)
                dp[i] += dp[j] * dp[k];
        }

        System.out.println(dp[n]);
    }
}
