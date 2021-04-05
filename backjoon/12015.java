import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int size = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(size == 0) {
                arr[size++] = n;
            }
            else if(arr[size-1] < n) {
                arr[size++] = n;
            }
            else {
                int low = 0, high = size;
                boolean flag = false;
                while(low <= high) {
                    int mid = (low + high) / 2;

                    if(arr[mid] == n) {
                        flag = true;
                        break;
                    }
                    else if(arr[mid] > n)
                        high = mid -1;
                    else
                        low = mid + 1;
                }
                if(!flag) arr[low] = n;
            }
        }

        System.out.println(size);

    }
}
