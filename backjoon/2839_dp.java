import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N+1];
        Arrays.fill(arr, 999);

        if(N < 6 && N != 3 && N != 5) {
            System.out.println(-1);
            return;
        } else if (N == 3 || N == 5) {
            System.out.println(1);
        }

        arr[3] = 1;
        arr[5] = 1;

        for(int i = 6; i < N+1; i++)
            arr[i] = Math.min(arr[i-3]+1, arr[i-5]+1);

        if(arr[N] == 999)
            System.out.println(-1);
        else
            System.out.println(arr[N]);
    }
}
