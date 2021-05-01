import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int[] combo;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        combo = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        permutation(0);

        System.out.println(sb);
    }

    public static void permutation(int depth) {
        if (depth == M) {
            for(int i : combo)
                sb.append(i).append(" ");
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combo[depth] = arr[i];
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }
}
