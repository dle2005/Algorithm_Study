import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        int length = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    length = Math.max(length, dp[i]);
                }
            }
        }

        System.out.println(length);
        StringBuilder sb = new StringBuilder();

        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == length) {
                sb.insert(0, arr[i] + " ");
                length--;
            }
        }

        System.out.println(sb);
    }
}
