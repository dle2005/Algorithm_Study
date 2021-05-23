import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] inputs = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }

        int[][] dp = new int[Math.max(max + 1, 4)][3];

        dp[1][0] = 1;

        dp[2][0] = 1;
        dp[2][1] = 1;

        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }

        StringBuilder sb = new StringBuilder();
        for (int input : inputs)
            sb.append(dp[input][0] + dp[input][1] + dp[input][2]).append("\n");

        System.out.println(sb);
    }
}
