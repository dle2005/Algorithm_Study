import java.util.Scanner;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int i : arr)
                sb.append(i+1).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(depth == 0) {
                arr[depth] = i;
                dfs(depth+1);
            } else {
                if(arr[depth-1] <= i) {
                    arr[depth] = i;
                    dfs(depth+1);
                }
            }

        }
    }
}
