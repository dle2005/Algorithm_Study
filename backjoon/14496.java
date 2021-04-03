import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{a, 0});
        visit[a] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            if(q[0] == b) {
                System.out.println(q[1]);
                System.exit(0);
            }

            for(int i : list[q[0]]) {
                if(!visit[i]) {
                    queue.offer(new int[]{i, q[1] + 1});
                    visit[i] = true;
                }
            }
        }

        System.out.println(-1);
    }
}
