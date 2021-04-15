import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기

        // 주사위를 놓을 곳의 좌표 x, y
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken()); // 명령의 개수

        int[][] map = new int[N][M]; // 지도

        for(int i = 0; i < N; i++) { // 지도 좌표 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dice = new int[6];
        int top = 0;
        int front = 1;
        int bottom = 2;
        int back = 3;
        int left = 4;
        int right = 5;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) { // 명령을 수행
            int k = Integer.parseInt(st.nextToken());

            boolean flag = true;

            if(k == 1) { // 동쪽
                if(y + 1 < M) {
                    y = y + 1; // 주사위의 좌표 이동
                    int temp_top = top, temp_bottom = bottom, temp_left = left, temp_right = right;
                    top = temp_left;
                    right = temp_top;
                    bottom = temp_right;
                    left = temp_bottom;
                }
                else
                    flag = false;
            }

            if(k == 2) { // 서쪽
                if(y - 1 >= 0) {
                    y = y - 1; // 주사위의 좌표 이동
                    int temp_top = top, temp_bottom = bottom, temp_left = left, temp_right = right;
                    top = temp_right;
                    right = temp_bottom;
                    bottom = temp_left;
                    left = temp_top;
                }
                else
                    flag = false;
            }

            if(k == 3) { // 북쪽
                if(x - 1 >= 0) {
                    x = x - 1; // 주사위의 좌표 이동
                    int temp_top = top, temp_front = front, temp_bottom = bottom, temp_back = back;
                    top = temp_front;
                    front = temp_bottom;
                    bottom = temp_back;
                    back = temp_top;
                }
                else
                    flag = false;
            }

            if(k == 4) { // 남쪽
                if(x + 1 < N) {
                    x = x + 1; // 주사위의 좌표 이동
                    int temp_top = top, temp_front = front, temp_bottom = bottom, temp_back = back;
                    top = temp_back;
                    front = temp_top;
                    bottom = temp_front;
                    back = temp_bottom;
                }
                else
                    flag = false;
            }


            if(flag) {
                int num = map[x][y]; // 지도 바닥의 숫자

                if (num == 0)
                    map[x][y] = dice[bottom];
                else {
                    dice[bottom] = num;
                    map[x][y] = 0;
                }

                sb.append(dice[top]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
