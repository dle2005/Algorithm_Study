import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, Max = Integer.MIN_VALUE;
    public static int[][] paper;
    public static boolean[][] visit;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 종이의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 종이의 가로 크기

        paper = new int[N][M]; // 종이의 내용을 저장할 배열
        visit = new boolean[N][M]; // 사이클 방지 방문 여부 저장 배열

        for(int i = 0; i < N; i++) { // 종이의 내용 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // ㅜ모양을 제외한 모든 모양은 한 정점에서 dfs 탐색시 전부 검사가 가능
                // 모든 정점에서 ㅜ모양을 제외한 모든 경우의 수를 탐색
                visit[i][j] = true;

                dfs(i, j, 1, paper[i][j]);

                visit[i][j] = false;

                rest(i, j);
            }
        }

        System.out.println(Max);
    }

    public static void rest(int i, int j) {
        if(i + 1 < N && j + 2 < M) // ㅜ
            Max = Math.max(Max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1]);
        if(i - 1 >= 0 && j + 2 < M) // ㅗ
            Max = Math.max(Max, paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i-1][j+1]);
        if(i - 1 >= 0 && i + 1 < N && j + 1 < M) // ㅓ
            Max = Math.max(Max, paper[i][j] + paper[i+1][j+1] + paper[i][j+1] + paper[i-1][j+1]);
        if(i + 2 < N && j + 1 < M) // ㅏ
            Max = Math.max(Max, paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j+1]);
    }

    public static void dfs(int i, int j, int depth, int sum) {
        if(depth == 4) { // 길이가 4이면
            Max = Math.max(Max, sum); // 합이 최대값인 경우 갱신
            return;
        }

        for(int k = 0; k < 4; k++) {
            int ii = i + di[k]; // 다음에 방문한 위치
            int jj = j + dj[k];

            // 종이의 밖으로 벗어나는 경우는 생략
            if(0 > ii || ii >= N || 0 > jj || jj >= M) continue;
            if(visit[ii][jj]) continue; // 이미 방문하였으면 방문 하지 않음

            visit[ii][jj] = true;

            dfs(ii, jj, depth+1, sum + paper[ii][jj]);

            // 탐색이 종료되는 방문 하지 않음으로 변경
            // 백트레킹 방식을 사용하여 다시 방문이 가능하도록 함
            visit[ii][jj] = false;
        }
    }
}
