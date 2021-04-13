import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static Set<Integer>[] list;
    public static List<String> order = new ArrayList<>();
    public static boolean[] visit;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 정점의 수

        list = new Set[N+1]; // 인접리스트
        for(int i = 0; i <= N; i++)
            list[i] = new HashSet<>();

        for(int i = 0; i < N-1; i++) { // N-1 간선 정보
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // 양방향으로 저장
            list[b].add(a);
        }

        list[0].add(1);
        visit = new boolean[N+1];

        int lastNum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int dest = Integer.parseInt(st.nextToken());
            if(!dfs(dest, lastNum)) {
                System.out.println(0);
                return;
            }
            lastNum = dest;
        }

        System.out.println(1);
    }

    public static boolean dfs(int node, int lastNum) {
        if(visit[node]) {
            return false;
        }

        if(list[lastNum].contains(node)) {
            if(!visit[node]) {
                visit[node] = true;
                stack.push(lastNum);
                return true;
            }
        }

        while(!stack.isEmpty()) {
            int n = stack.pop();
            if(dfs(node, n)) return true;
        }

        return false;
    }
}
