import java.util.Scanner;

public class Main {
    public static int[] calc = new int[4];
    public static int[] arr;
    public static int N, Min = (int)Math.pow(10, 9), Max = (int)((-1)*Math.pow(10, 9));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < 4; i++)
            calc[i] = sc.nextInt();

        dfs(0, arr[0], 1);

        System.out.println(Max);
        System.out.println(Min);
    }

    public static void dfs(int depth, int value, int start) {

        if(depth == N-1) {
            if(value > Max) Max = value;
            if(value < Min) Min = value;

            return;
        }

        if(calc[0] > 0) {
            calc[0]--;
            dfs(depth + 1, value + arr[start], start + 1);
            calc[0]++;
        }
        if(calc[1] > 0) {
            calc[1]--;
            dfs(depth + 1, value - arr[start], start + 1);
            calc[1]++;
        }
        if(calc[2] > 0) {
            calc[2]--;
            dfs(depth + 1, value * arr[start], start + 1);
            calc[2]++;
        }
        if(calc[3] > 0) {
            calc[3]--;
            dfs(depth + 1, value / arr[start], start + 1);
            calc[3]++;
        }
    }
}
