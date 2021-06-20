import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[0] = dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[N]);
        print(N);
        System.out.println(sb);
    }
    public static void print(int n) {
        sb.append(n).append(" ");

        if (n - 1 >= 0 && dp[n - 1] == dp[n] - 1) print(n - 1);
        else if (n % 3 == 0 && dp[n / 3] == dp[n] - 1) print(n / 3);
        else if (n % 2 == 0 && dp[n / 2] == dp[n] - 1) print(n / 2);
    }
}
