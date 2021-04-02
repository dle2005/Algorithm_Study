import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static List<int []> list = new LinkedList<>();
    public static int N, M, Max = 0;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) list.add(new int[]{i, j});
            }
        }

        dfs(0);

        System.out.println(Max);
    }

    public static void calcArea() {
        int[][] temp = new int[N][M];

        for(int i = 0; i < N; i++)
            System.arraycopy(arr[i], 0, temp[i], 0, M);

        Queue<int[]> q = new LinkedList<>();
        for(int[] t : list)
            q.offer(new int[]{t[0], t[1]});

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int i = t[0];
            int j = t[1];

            for(int k = 0; k < 4; k++) {
                int ii = i + di[k];
                int jj = j + dj[k];

                if(0 <= ii && ii < N && 0 <= jj && jj < M && temp[ii][jj] == 0) {
                    temp[ii][jj] = 2;
                    q.offer(new int[]{ii, jj});
                }
            }
        }

        int safe_area = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 0)
                    safe_area++;
            }
        }

        Max = Math.max(Max, safe_area);
    }

    public static void dfs(int block) {
        if(block == 3) {
            calcArea();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(block + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
}
