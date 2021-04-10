import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Subin {
        int pos; // 현재 위치
        int move; // 이동 횟수

        public Subin(int pos, int move) {
            this.pos = pos;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈 위치
        int K = sc.nextInt(); // 동생 위치

        int min = K - N; // 최소 이동
        int count = 0; // 최소 이동 방법 수

        if (N > K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        Queue<Subin> queue = new LinkedList<>();
        queue.offer(new Subin(N, 0));
        boolean[] visit = new boolean[100001];

        while(!queue.isEmpty()) {
            Subin now = queue.poll();
            visit[now.pos] = true;

            if(now.pos == K) {
                if(min > now.move) { // 최소 이동 횟수 갱신
                    min = now.move;
                    count = 1;
                }
                else if(min == now.move)
                    count++;
            }

            if(now.move < min) {
                if (now.pos < K && now.pos*2 <= 100000 && !visit[now.pos*2])
                    queue.offer(new Subin(now.pos * 2, now.move + 1));
                if (now.pos < K && !visit[now.pos+1])
                    queue.offer(new Subin(now.pos + 1, now.move + 1));
                if (now.pos > 0 && !visit[now.pos-1])
                    queue.offer(new Subin(now.pos - 1, now.move + 1));
            }
        }

        System.out.println(min);
        System.out.println(count);
    }
}
