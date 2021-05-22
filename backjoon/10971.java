import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static boolean[] visit;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++)
            dfs(i, 0, i, 0);

        System.out.println(answer);
    }

    public static void dfs(int cur, int depth, int start, int sum) {
        if (depth == N && cur == start) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                if(map[cur][i] == 0) continue;
                if(sum + map[cur][i] > answer) continue;

                visit[i] = true;
                dfs(i, depth + 1, start, sum + map[cur][i]);
                visit[i] = false;
            }
        }
    }
}
