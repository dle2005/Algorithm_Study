import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 300 / A; i++) {
            for (int j = 0; j <= 300 / B; j++) {
                for (int k = 0; k <= 300 / C; k++) {
                    if(A * i + B * j + k * C == N) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(0);
    }

}
