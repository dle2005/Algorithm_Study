import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, zeros, answer = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, 1, 0, -1};
    public static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) zeros++;
                else if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        zeros += virus.size() - M;
        if (zeros == 0) {
            System.out.println(0);
            return;
        }

        permutation(0, 0);

        System.out.println(answer ==  Integer.MAX_VALUE ? -1 : answer);
    }

    public static void permutation(int depth, int start) {
        if (virus.size() - M == depth) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            int[] pos = virus.get(i);
            map[pos[0]][pos[1]] = 0;
            permutation(depth + 1, i + 1);
            map[pos[0]][pos[1]] = 2;
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[N][N];
        int zero = zeros;

        for (int[] v : virus) {
            if (map[v[0]][v[1]] == 2) {
                queue.offer(new int[]{v[0], v[1], 0});
                visit[v[0]][v[1]] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int i = cur[0] + di[k];
                int j = cur[1] + dj[k];

                if (i < 0 || j < 0 || i >= N || j >= N) continue;
                if (map[i][j] != 0) continue;
                if (visit[i][j]) continue;

                if (--zero == 0) {
                    answer = Math.min(answer, cur[2] + 1);
                    return;
                }

                visit[i][j] = true;
                queue.offer(new int[]{i, j, cur[2] + 1});
            }
        }
    }
}
