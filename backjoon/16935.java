import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) rotate(Integer.parseInt(st.nextToken()));

        for (int i[] : map) {
            for (int j : i) sb.append(j).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void rotate(int r) {
        if (r == 1) {
            int[][] temp = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    temp[i][j] = map[N - i - 1][j];
            }

            map = temp;
        } else if (r == 2) {
            int[][] temp = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    temp[i][j] = map[i][M - j - 1];
            }

            map = temp;
        } else if (r == 3) {
            int[][] temp = new int[M][N];

            int c = N - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    temp[j][c] = map[i][j];
                c--;
            }

            int t = N;
            N = M;
            M = t;

            map = temp;
        } else if (r == 4) {
            int[][] temp = new int[M][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    temp[M - j - 1][i] = map[i][j];
            }

            int t = N;
            N = M;
            M = t;

            map = temp;
        } else if (r == 5) {
            int[][] temp = new int[N][M];

            int h = N / 2;
            int w = M / 2;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++)
                    temp[i][j + w] = map[i][j];
            }
            for (int i = 0; i < h; i++) {
                for (int j = w; j < M; j++)
                    temp[i + h][j] = map[i][j];
            }
            for (int i = h; i < N; i++) {
                for (int j = w; j < M; j++)
                    temp[i][j - w] = map[i][j];
            }
            for (int i = h; i < N; i++) {
                for (int j = 0; j < w; j++)
                    temp[i - h][j] = map[i][j];
            }

            map = temp;
        } else {
            int[][] temp = new int[N][M];

            int h = N / 2;
            int w = M / 2;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++)
                    temp[i + h][j] = map[i][j];
            }
            for (int i = h; i < N; i++) {
                for (int j = 0; j < w; j++)
                    temp[i][j + w] = map[i][j];
            }
            for (int i = h; i < N; i++) {
                for (int j = w; j < M; j++)
                    temp[i - h][j] = map[i][j];
            }
            for (int i = 0; i < h; i++) {
                for (int j = w; j < M; j++)
                    temp[i][j - w] = map[i][j];
            }

            map = temp;
        }
    }
}
