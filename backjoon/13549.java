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
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        boolean[] visit = new boolean[200001];

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int cur = q[0];
            int cnt = q[1];

            if (cur == K) {
                System.out.println(cnt);
                return;
            }

            if (cur < K) {
                if (!visit[cur * 2]) {
                    queue.offer(new int[]{cur * 2, cnt});
                    visit[cur * 2] = true;
                }
            }

            if (cur > 0) {
                if(!visit[cur - 1]) {
                    queue.offer(new int[]{cur - 1, cnt + 1});
                    visit[cur - 1] = true;
                }
            }

            if (cur < K) {
                if (!visit[cur + 1]) {
                    queue.offer(new int[]{cur + 1, cnt + 1});
                    visit[cur + 1] = true;
                }
            }
        }
    }
}
