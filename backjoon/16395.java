import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[n+1][n+1];
        arr[1][1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j == 1) arr[i][j] = 1;
                else if(j == n) arr[i][j] = 1;
                else
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }

        System.out.println(arr[n][k]);
    }
}
