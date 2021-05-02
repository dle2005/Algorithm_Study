import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;

        while (right < N) {
            if (map.containsKey(arr[right]))
                map.put(arr[right], map.get(arr[right]) + 1);
            else map.put(arr[right], 1);

            if (map.get(arr[right]) > K) {
                while (map.get(arr[right]) > K) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    left++;
                }
            }
            right++;

            answer = Math.max(answer, right - left);
        }

        System.out.println(answer);
    }
}
