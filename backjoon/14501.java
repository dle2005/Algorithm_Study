import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+6];
        int[][] benefit = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            benefit[i][0] = Integer.parseInt(st.nextToken());
            benefit[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            int days = benefit[i][0];
            int money = benefit[i][1];

            int index = i + days - 1;

            dp[i] = Math.max(dp[i], max);
            dp[index] = Math.max(dp[index], max + money);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
