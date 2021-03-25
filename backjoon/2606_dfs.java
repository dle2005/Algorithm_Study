import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean[] visit;
    public static List<Integer>[] list;
    public static int count = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int vertex = sc.nextInt();

        visit = new boolean[node + 1];
        list = new LinkedList[node + 1];
        for(int i = 0; i < node + 1; i++)
            list[i] = new LinkedList<>();

        for(int i = 0; i < vertex; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    public static void dfs(int n) {
        visit[n] = true;
        count++;

        for(int i : list[n]) {
            if(!visit[i])
                dfs(i);
        }
    }
}
