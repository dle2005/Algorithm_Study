import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1,0);

        System.out.println(sb);
    }

    public static void dfs(int begin, int depth) {
        if(depth == M) {
            for(int i : arr)
                sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = begin; i <= N; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
