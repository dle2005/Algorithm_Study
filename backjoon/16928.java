import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] snakes = new int[101];
        boolean[] visit = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            snakes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visit[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == 100) {
                System.out.println(cur[1]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;

                if (100 < next) continue;
                if (visit[next]) continue;

                if (snakes[next] != 0)
                    next = snakes[next];

                visit[next] = true;
                queue.offer(new int[]{next, cur[1] + 1});
            }
        }
    }
}
