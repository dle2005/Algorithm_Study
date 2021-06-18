import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static int[][] map;
    public static boolean[][] visit;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = s.charAt(j) - '0';
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0) {
                queue.add(new int[]{0, i});
                visit[0][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == M - 1) {
                System.out.println("YES");
                return;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur[0] + di[k];
                int j = cur[1] + dj[k];

                if (i < 0 || j < 0 || i >= M || j >= N) continue;
                if (visit[i][j]) continue;
                if (map[i][j] == 1) continue;

                queue.add(new int[]{i, j});
                visit[i][j] = true;
            }
        }

        System.out.println("NO");
    }
}
