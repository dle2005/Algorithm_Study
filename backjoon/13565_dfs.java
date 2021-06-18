import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0) {
                visit[0][i] = true;
                dfs(0, i);
            }
        }

        System.out.println("NO");
    }

    public static void dfs(int i, int j) {
        if (i == M - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];

            if (ii < 0 || jj < 0 || ii >= M || jj >= N) continue;
            if (visit[ii][jj]) continue;
            if (map[ii][jj] != 0) continue;

            visit[ii][jj] = true;
            dfs(ii, jj);
        }
    }
}
