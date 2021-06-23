import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Coin {
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M, answer = Integer.MAX_VALUE;
    public static int[][] map;
    public static Coin coin1, coin2;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean flag = true;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    if (flag) {
                        coin1 = new Coin(i, j);
                        flag = false;
                    } else coin2 = new Coin(i, j);
                }
            }
        }

        backTracking(coin1, coin2, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void backTracking(Coin coin1, Coin coin2, int cnt) {
        if (cnt >= 10 || cnt >= answer) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x1 = coin1.x + di[k];
            int y1 = coin1.y + dj[k];
            int x2 = coin2.x + di[k];
            int y2 = coin2.y + dj[k];

            int drop = 0;
            if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= M) drop++;
            if (x2 < 0 || y2 < 0 || x2 >= N || y2 >= M) drop++;

            if (drop == 1) {
                answer = Math.min(answer, cnt + 1);
                return;
            }
            else if (drop == 2) continue;

            if (map[x1][y1] == '#') {
                x1 = coin1.x;
                y1 = coin1.y;
            }
            if (map[x2][y2] == '#') {
                x2 = coin2.x;
                y2 = coin2.y;
            }

            backTracking(new Coin(x1, y1), new Coin(x2, y2), cnt + 1);
        }
    }
}
