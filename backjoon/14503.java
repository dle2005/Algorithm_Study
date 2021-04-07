import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visit[r][c] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            boolean flag = true;
            if(arr[q[0]][q[1]] == 0) {
                arr[q[0]][q[1]] = -1;
                count++;
            }

            for(int k = 0; k < 4; k++) {
                d = (d + 3) % 4;

                int ii = q[0] + di[d];
                int jj = q[1] + dj[d];

                if(0 <= ii && ii < N && 0 <= jj && jj < M && !visit[ii][jj] && arr[ii][jj] == 0) {
                    flag = false;
                    queue.offer(new int[]{ii, jj});
                    visit[ii][jj] = true;
                    break;
                }
            }

            if(flag) {
                int dd = (d + 2) % 4;

                int ii = q[0] + di[dd];
                int jj = q[1] + dj[dd];

                if(0 <= ii && ii < N && 0 <= jj && jj < M && arr[ii][jj] != 1) {
                    queue.offer(new int[]{ii, jj});
                    visit[ii][jj] = true;
                }
            }
        }

        System.out.println(count);
    }
}
