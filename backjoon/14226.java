import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[1001][1001];
        int min = 10000;

        q.offer(new int[]{1, 0, 0});

        while(!q.isEmpty()) {
            int[] arr = q.poll(); // 0: 화면, 1: 클립보드, 2: 시간

            if(!visit[arr[0]][arr[1]])
                visit[arr[0]][arr[1]] = true;
            else
                continue;

            if(arr[0] == S) { // 화면에 S개 이모티콘
                System.out.println(arr[2]);
                System.exit(0);
            }

            q.offer(new int[]{arr[0], arr[0], arr[2] + 1});

            if(arr[1] > 0 && arr[0] + arr[1] <= 1000)
                q.offer(new int[]{arr[0] + arr[1], arr[1], arr[2] + 1});

            if(arr[0] > 1)
                q.offer(new int[]{arr[0] - 1, arr[1], arr[2] + 1});

        }
    }
}
