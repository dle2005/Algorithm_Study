import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static List<Integer>[] list;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        list = new List[N+1]; // 인접리스트 형태로 친구관계 저장
        for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        visit = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // 양방향으로 저장
            list[b].add(a);
        }

        for(int i = 0; i <= N; i++) {
            visit[i] = true;
            dfs(0, i);
            visit[i] = false;
        }

        System.out.println(0);
    }

    public static void dfs(int depth, int start) {
        if(depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for(int n : list[start]) {
            if(!visit[n]) {
                visit[n] = true;
                dfs(depth + 1, n);
                visit[n] = false;
            }
        }
    }
}
