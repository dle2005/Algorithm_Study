import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] time = new int[N];
        int arrow = 0, sum_time = 0;
        int x = 0, y = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if(i == 0)
                time[i] = Integer.parseInt(st.nextToken());
            else
                time[i] = Integer.parseInt(st.nextToken()) - sum_time;
            sum_time += time[i];
            String loR = st.nextToken();

            x += direction[arrow][0] * time[i];
            y += direction[arrow][1] * time[i];

            if(loR.equals("right")) {
                arrow--;
                if(arrow < 0) arrow = 3;
            }
            else if(loR.equals("left")) {
                arrow++;
                arrow %= 4;
            }
        }

        x += direction[arrow][0] * (T - sum_time);
        y += direction[arrow][1] * (T - sum_time);

        System.out.println(x + " " + y);
    }
}
