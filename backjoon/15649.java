 import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);

        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int i : arr)
                sb.append(i + 1).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                arr[depth] = i;
                visit[i] = true;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
