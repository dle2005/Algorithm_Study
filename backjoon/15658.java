import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] num, operator, per;
    public static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        per = new int[N-1];

        operator = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if(depth == N - 1) {
            int result = num[0];
            for(int i = 1; i < N; i++) {
                if(per[i-1] == 0)
                    result += num[i];
                else if(per[i-1] == 1)
                    result -= num[i];
                else if(per[i-1] == 2)
                    result *= num[i];
                else
                    result /= num[i];
            }

            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                per[depth] = i;
                dfs(depth + 1);
                operator[i]++;
            }
        }
    }
}
