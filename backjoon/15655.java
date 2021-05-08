import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] numbers, combination;
    public static int N, M;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        combination = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        permutation(0, 0);

        System.out.println(sb);
    }

    public static void permutation(int depth, int start) {
        if (depth == M) {
            for(int n : combination)
                sb.append(n + " ");
            sb.append("\n");

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination[depth] = numbers[i];
                permutation(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
