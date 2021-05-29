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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] q = queue.poll();

            long cur = q[0];
            long cnt = q[1];

            if (cur == B) {
                System.out.println(cnt);
                return;
            }

            if (cur < B) {
                queue.offer(new long[]{cur * 2, cnt + 1});
                queue.offer(new long[]{cur * 10 + 1, cnt + 1});
            }
        }

        System.out.println(-1);
    }
}
