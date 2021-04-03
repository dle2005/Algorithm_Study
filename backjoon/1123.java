import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            char[][] arr = new char[H][W];
            boolean[][] visit = new boolean[H][W];
            int count = 0;
            Queue<int[]> queue = new LinkedList<>();

            for(int j = 0; j < H; j++) {
                String s = br.readLine();
                for(int k = 0; k < W; k++) {
                    arr[j][k] = s.charAt(k);
                    if(s.charAt(k) == '#')
                        list.add(new int[]{j, k});
                }
            }

            for(int[] sheep : list) {
                if(visit[sheep[0]][sheep[1]] == false)
                    count++;
                else
                    visit[sheep[0]][sheep[1]] = true;
                queue.offer(new int[]{sheep[0],sheep[1]});

                while(!queue.isEmpty()) {
                    int[] s = queue.poll();

                    for(int k = 0; k < 4; k++) {
                        int ii = s[0] + di[k];
                        int jj = s[1] + dj[k];

                        if(0 <= ii && ii < H && 0 <= jj && jj < W && !visit[ii][jj] && arr[ii][jj] == '#') {
                            queue.offer(new int[]{ii, jj});
                            visit[ii][jj] = true;
                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
