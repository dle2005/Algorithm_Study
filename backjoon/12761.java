import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Pos {
        int index;
        int cnt;

        public Pos(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }

    public static final int INF = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[INF];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(N, 0));
        visit[N] = true;

        while (true) {
            Pos cur = queue.poll();

            if (cur.index == M) {
                System.out.println(cur.cnt);
                return;
            }

            if (cur.index + 1 <= M && !visit[cur.index + 1] ) {
                visit[cur.index + 1] = true;
                queue.add(new Pos(cur.index + 1, cur.cnt + 1));
            }
            if (cur.index - 1 >= 0 && !visit[cur.index - 1] ) {
                visit[cur.index - 1] = true;
                queue.add(new Pos(cur.index - 1, cur.cnt + 1));
            }
            if (cur.index + A < INF && !visit[cur.index + A] ) {
                visit[cur.index + A] = true;
                queue.add(new Pos(cur.index + A, cur.cnt + 1));
            }
            if (cur.index + B < INF && !visit[cur.index + B] ) {
                visit[cur.index + B] = true;
                queue.add(new Pos(cur.index + B, cur.cnt + 1));
            }
            if (cur.index - A >= 0 && !visit[cur.index - A] ) {
                visit[cur.index - A] = true;
                queue.add(new Pos(cur.index - A, cur.cnt + 1));
            }
            if (cur.index - B >= 0 && !visit[cur.index - B] ) {
                visit[cur.index - B] = true;
                queue.add(new Pos(cur.index - B, cur.cnt + 1));
            }
            if (cur.index * A < INF && !visit[cur.index * A] ) {
                visit[cur.index * A] = true;
                queue.add(new Pos(cur.index * A, cur.cnt + 1));
            }
            if (cur.index * B < INF && !visit[cur.index * B] ) {
                visit[cur.index * B] = true;
                queue.add(new Pos(cur.index * B, cur.cnt + 1));
            }
        }
    }
}
