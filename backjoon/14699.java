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

        int[] level = new int[N + 1];
        int[][] height = new int[N + 1][2];
        int[] height2 = new int[N + 1];
        List<Integer>[] list = new List[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            height[i][0] = Integer.parseInt(st.nextToken());
            height[i][1] = i;
            height2[i] = height[i][0];
        }

        Arrays.sort(height, 1, N+1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            int h = height[i][0];
            int n = height[i][1];

            level[n] = 1;

            for(int j : list[n]) {
//                System.out.println(n + " " + h + "  " + j + " " + height2[j]);

                if(height2[j] > h) {
                    level[n] = Math.max(level[j]+1, level[n]);
                }
            }
        }

        for(int i = 1; i <= N; i++)
            System.out.println(level[i]);
    }
}
