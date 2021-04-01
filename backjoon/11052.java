import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

            int low = 0, high = i-1;
            while(low <= high) {
                arr[i] = Math.max(arr[i], arr[low] + arr[high]);
                low++;
                high--;
            }
        }

        System.out.println(arr[N-1]);
    }
}
