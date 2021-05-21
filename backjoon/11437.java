import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] list;
    public static int[] parents, depths;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        parents = new int[N + 1];
        depths = new int[N + 1];

        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            findParent(v1, v2);
        }

        System.out.println(sb);
    }

    public static void findParent(int v1, int v2) {
        int v1_depth = depths[v1];
        int v2_depth = depths[v2];

        if (v1_depth > v2_depth) {
            while (v1_depth != v2_depth) {
                v1 = parents[v1];
                v1_depth--;
            }
        } else {
            while (v1_depth != v2_depth) {
                v2 = parents[v2];
                v2_depth--;
            }
        }

        while (v1 != v2) {
            v1 = parents[v1];
            v2 = parents[v2];
        }

        sb.append(v1).append("\n");
    }

    public static void dfs(int child, int parent, int depth) {
        parents[child] = parent;
        depths[child] = depth;

        for (int next : list[child]) {
            if(next != parent) dfs(next, child, depth + 1);
        }
    }
}
