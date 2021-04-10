import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Soldier {
        int i; // i 좌표
        int j; // j 좌표
        int move; // 이동 수
        boolean gram; // 그람 보유 여부

        public Soldier(int i, int j, int move, boolean gram) {
            this.i = i;
            this.j = j;
            this.move = move;
            this.gram = gram;
        }
    }

    public static int N, M, T, count = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 성의 크기 세로
        M = Integer.parseInt(st.nextToken()); // 성의 크기 가로
        T = Integer.parseInt(st.nextToken()); // 제한 시간

        map = new int[N][M]; // 지도 저장 배열
        visit = new boolean[N][M][2]; // 사이클을 방지 배열
        // 그람을 얻었을 때의 경로와 아닐때의 경로를 확인
        // 별도로 확인하지 않으면 경로가 겹쳐 문제가 발생

        for(int i = 0; i < N; i++) { // 지도 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        bfs();

        if(count == Integer.MAX_VALUE)
            System.out.println("Fail");
        else
            System.out.println(count);
    }

    public static void bfs() {
        Queue<Soldier> queue = new LinkedList<>();
        queue.offer(new Soldier(0, 0, 0, false)); // 출발지점
        visit[0][0][0] = true;

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0 ,-1, 0};

        while (!queue.isEmpty()) {
            Soldier s = queue.poll();

            if(s.i == N-1 && s.j == M-1) { // 공주에게 도착할 경우
                count = Math.min(count, s.move); // 최단 시간 갱신
                return;
            }

            if(s.move >= T) // 제한시간을 초과한 경우
                return;

            for(int k = 0; k < 4; k++) {
                int i = s.i + di[k]; // 새로 이동할 지점
                int j = s.j + dj[k];

                if(0 > i || i >= N || 0 > j || j >= M) continue; // 지도 밖을 벗어나면 이동 불가
                // 이미 방문한 곳이면 이동 불가 사이클이 생김
                if(s.gram && visit[i][j][1]) continue; // 그람이 있을 때 방문한 것과
                if(!s.gram && visit[i][j][0]) continue; // 그람이 없을 때 방문한 것을 각각 확인

                if(s.gram) { // 그람이 있는 경우
                    queue.offer(new Soldier(i, j, s.move+1, true));
                    visit[i][j][1] = true; // 그람이 있는 경우의 이동 경로
                }
                else { // 그람이 없는 경우
                    if(map[i][j] == 0) { // 빈공간으로 이동
                        queue.offer(new Soldier(i, j, s.move + 1, false));
                        visit[i][j][0] = true; // 그람이 없는 경우의 이동 경로
                    }
                    else if(map[i][j] == 2) { // 그람 획득
                        queue.offer(new Soldier(i, j, s.move + 1, true));
                        visit[i][j][1] = true; // 그람을 얻은 순간부터 그람이 포함된 경로로 이동
                    }
                }
            }
        }

    }
}
