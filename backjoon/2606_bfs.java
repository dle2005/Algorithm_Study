import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static boolean[] visit;
    public static List<Integer>[] list;
    public static int count = 0;

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

        bfs(1);

        System.out.println(count);
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        visit[n] = true;
        queue.offer(n);

        while(!queue.isEmpty()) {
            int q = queue.poll();

            for(int i : list[q]) {
                if(!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
    }
}
