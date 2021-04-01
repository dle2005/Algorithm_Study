import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N-1];
        int[] price = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N-1; i++)
            distance[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N-1; i++)
            price[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        long min = price[0];
        for(int i = 0; i < N-1; i++) {
            if(price[i] <= min)
                min = price[i];
            sum += min * distance[i];
        }

        System.out.println(sum);
    }
}
