import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0)
                arr[i] = arr[i - 2] + 1;
            if(i >= 5 && (i % 5 == 0 || arr[i-5] != 0))
                arr[i] = arr[i-5] + 1;
        }

        if(arr[n] == 0)
            System.out.println(-1);
        else
            System.out.println(arr[n]);
    }
}
