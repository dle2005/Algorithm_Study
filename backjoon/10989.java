import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int MAX_SIZE = 10001;
        int[] count = new int[MAX_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
            count[Integer.parseInt(br.readLine())]++;

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < MAX_SIZE; i++) {
            while(count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
