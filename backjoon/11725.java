import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int[] parent = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int n : list[q]) {
                if (!visit[n]) {
                    visit[n] = true;
                    parent[n] = q;
                    queue.offer(n);
                }
            }
        }

        for(int i = 2; i <= N; i++)
            sb.append(parent[i]).append("\n");

        System.out.println(sb);
    }
}
