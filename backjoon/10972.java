import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());

        if (next_permutation(input, N)) {
            StringBuilder sb = new StringBuilder();
            for (int n : input) sb.append(n).append(" ");
            System.out.println(sb);
        } else System.out.println(-1);
    }

    public static boolean next_permutation(int[] arr, int N) {
        int i = N - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (arr[i - 1] >= arr[j]) j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        int k = N - 1;
        while (i < k) {
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            i++;
            k--;
        }

        return true;
    }
}
