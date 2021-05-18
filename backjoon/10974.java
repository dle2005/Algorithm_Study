import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] permutation;
    public static boolean[] visit;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        permutation = new int[N];
        visit = new boolean[N + 1];

        nextPermutation(0);

        System.out.println(sb);
    }

    public static void nextPermutation(int depth) {
        if (depth == N) {
            for (int num : permutation)
                sb.append(num).append(" ");
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                permutation[depth] = i;
                visit[i] = true;
                nextPermutation(depth + 1);
                visit[i] = false;
            }
        }
    }
}
