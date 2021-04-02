import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] front = new int[N];
        int[] end = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            front[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    front[i] = Math.max(front[i], front[j] + 1);
            }
        }

        for(int i = N-1; i >= 0; i--) {
            end[i] = 1;

            for(int j = N-1; j >= i; j--) {
                if(arr[i] > arr[j])
                    end[i] = Math.max(end[i], end[j] + 1);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, front[i] + end[i]);
        }

        System.out.println(max - 1);
    }
}
