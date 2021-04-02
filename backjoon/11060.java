import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 9999);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = 0;
        for(int i = 0; i < N; i++) {
            int n = arr[i];

            for(int j = i; j <= Math.min(i + n, N-1); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        if(dp[N-1] == 9999)
            System.out.println(-1);
        else
            System.out.println(dp[N-1]);
    }
}
