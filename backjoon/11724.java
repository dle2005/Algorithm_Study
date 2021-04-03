import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new List[N+1];
        for(int i = 0; i <= N; i++)
            lists[i] = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        int count = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
            if(!visit[i])
                count++;
            visit[i] = true;

            while(!queue.isEmpty()) {
                int q = queue.poll();

                for (int j : lists[q]) {
                    if(!visit[j]) {
                        visit[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        System.out.println(count);
    }
}
