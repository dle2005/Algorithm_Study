import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        // 0에는 입력 값, 1에는 가장 큰 증가 부분 수열 값
        int[][] dp = new int[A][2];
        int index = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < A; i++) {
            int n = Integer.parseInt(st.nextToken());

            dp[i][0] = n; // 입력 값 저장

            int max = n;
            for(int j = i; j >= 0; j--) {
                if(dp[j][0] < dp[i][0])
                    max = Math.max(max, dp[i][0] + dp[j][1]);
            }
            dp[i][1] = max;
        }

        int result = 0;
        for(int[] i : dp)
            result = Math.max(result, i[1]);

        System.out.println(result);

    }
}
