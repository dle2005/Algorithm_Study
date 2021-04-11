import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, R, groupNum;
    public static int[][] arr;
    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로 길이
        M = Integer.parseInt(st.nextToken()); // 가로 길이
        R = Integer.parseInt(st.nextToken()); // 회전 횟수

        arr = new int[N][M];
        for(int i = 0; i < N; i++) { // 배열 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 회전 하는 그룹의 수는 다음과 같다
        // 3x3 -> 1, 4x4 -> 2, 4x5 -> 2, 5x5 -> 2
        groupNum = Math.min(N,M) / 2;

        for(int i = 0; i < R; i++) // R번 회전
            rotate();

        for(int[] i : arr) { // 출력
            for(int j : i)
                sb.append(j).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void  rotate() {
        for(int i = 0; i < groupNum; i++) {
            int direction = 0;
            int x = i, y = i; // 시작지점 그룹에따라 달라짐
            int start = arr[i][i];

            while(direction < 4) { // 전체 회전할때 까지
                int ii = x + di[direction];
                int jj = y + dj[direction];

                // 지정한 그룹 내에서만 동작하도록
                if(ii >= i && ii < N-i && jj >= i && jj < M-i) {
                    arr[x][y] = arr[ii][jj];
                    x = ii; y = jj;
                }
                else // 그룹을 벗어나면 방향 전환
                    direction++;
            }
            arr[i+1][i] = start;
        }
    }
}
