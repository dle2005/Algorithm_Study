import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        List<int[]> list = new ArrayList<>();
        boolean[][] visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    list.add(new int[]{i, j});
            }
        }

        int[] di = {0, 1, 0, -1, 1, -1, -1, 1};
        int[] dj = {1, 0, -1, 0, 1, -1, 1, -1};
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int[] t : list) {
            if(!visit[t[0]][t[1]]) {
                count++;
                visit[t[0]][t[1]] = true;

                queue.offer(new int[]{t[0], t[1]});
                while (!queue.isEmpty()) {
                    int[] q = queue.poll();

                    for(int k = 0; k < 8; k++) {
                        int i = q[0] + di[k];
                        int j = q[1] + dj[k];

                        if(0 <= i && i < N && 0 <= j && j < M && !visit[i][j] && arr[i][j] == 1) {
                            queue.offer(new int[]{i, j});
                            visit[i][j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
