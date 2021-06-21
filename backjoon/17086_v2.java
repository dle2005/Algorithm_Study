import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M;
    public static int[][] map, dis;
    public static Queue<Pos> queue = new LinkedList<>();

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
                if (map[i][j] == 1) queue.add(new Pos(i, j));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int answer = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int k = 0; k < 8; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= N || j >= M) continue;
                if (map[i][j] == 1) continue;
                if (dis[i][j] != 0) continue;

                dis[i][j] = dis[cur.x][cur.y] + 1;
                answer = Math.max(answer, dis[i][j]);
                queue.add(new Pos(i, j));
            }
        }

        return answer;
    }
}
