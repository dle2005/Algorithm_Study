import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[][] weight = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                weight[i][j] = weight[i-1][j];

                if(W[i] <= j)
                    weight[i][j] = Math.max(weight[i-1][j],
                            weight[i-1][j-W[i]] + V[i]);
            }
        }

        System.out.println(weight[N][K]);
    }
}
