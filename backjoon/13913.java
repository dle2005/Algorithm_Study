import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] index = new int[200_001];
        boolean[] visit = new boolean[200_001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visit[N] = true;

        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] cur = queue.poll();

            if (cur[0] == K) {
                System.out.println(cur[1]);
                sb.append(K);
                while (K != N) {
                    sb.insert(0, index[K] + " ");
                    K = index[K];
                }
                System.out.println(sb);
                break;
            }

            if (cur[0] < K && !visit[cur[0] * 2]) {
                queue.add(new int[]{cur[0] * 2, cur[1] + 1});
                visit[cur[0] * 2] = true;
                index[cur[0] * 2] = cur[0];
            }

            if (cur[0] + 1 <= K && !visit[cur[0] + 1]) {
                queue.add(new int[]{cur[0] + 1, cur[1] + 1});
                visit[cur[0] + 1] = true;
                index[cur[0] + 1] = cur[0];
            }

            if (cur[0] - 1 >= 0 && !visit[cur[0] - 1]) {
                queue.add(new int[]{cur[0] - 1, cur[1] + 1});
                visit[cur[0] - 1] = true;
                index[cur[0] - 1] = cur[0];
            }
        }
    }
}
