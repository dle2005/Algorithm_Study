import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int N, M;
    public static int[][] map, dis;
    public static List<Pos> list = new ArrayList<>();

    public static int di[] = {1, 0, -1, 0, 1, -1, 1, -1};
    public static int dj[] = {0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 1) list.add(new Pos(i, j));
            }
        }

        for (int i = 0; i < list.size(); i++)
            calculate(list.get(i).x, list.get(i).y);

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                answer = Math.max(answer, dis[i][j]);
            }
        }

        System.out.println(answer == Integer.MIN_VALUE ? 0 : answer);
    }

    public static void calculate(int x, int y) {
        boolean[][] visit = new boolean[N][M];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y, 0));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            dis[cur.x][cur.y] = Math.min(dis[cur.x][cur.y], cur.cnt);

            for (int k = 0; k < 8; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= N || j >= M) continue;
                if (visit[i][j]) continue;

                visit[i][j] = true;
                queue.offer(new Pos(i, j, cur.cnt + 1));
            }
        }
    }
}
