import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] arr = new int[9];
    public static boolean[] visit = new boolean[9];
    public static int[] answer = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        backTracking(0, 0);
    }

    public static void backTracking(int depth, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                StringBuilder sb = new StringBuilder();

                for (int n : answer) sb.append(n).append("\n");

                System.out.println(sb);

                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = arr[i];
                backTracking(depth + 1, sum + arr[i]);
                visit[i] = false;
            }
        }
    }
}
