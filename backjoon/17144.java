import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, top, bottom;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map1 = new int[R][C]; // 확산 전
        int[][] map2 = new int[R][C]; // 확산 후

        int robot_index = 0;

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
                if(map1[i][j] == -1 && robot_index == 0) {
                    top = i;
                    robot_index++;
                }
                else if(map1[i][j] == -1 && robot_index == 1)
                    bottom = i;
            }
        }

        for(int i = 0; i < T; i++) {
            if(i % 2 == 0) {
                spreed(map1, map2);
                inhale(map2);
            }
            else {
                spreed(map2, map1);
                inhale(map1);
            }
        }

        int sum = 0;

        if(T % 2 == 0) {
            for (int[] i : map1) {
                for (int j : i) if (j != -1) sum += j;
            }
        }
        else {
            for (int[] i : map2) {
                for (int j : i) if (j != -1) sum += j;
            }
        }

        System.out.println(sum);
    }

    public static void inhale(int[][] map) {
        for(int i = top - 1; i > 0; i--) map[i][0] = map[i-1][0]; // 아래
        for(int i = 0; i < C - 1; i++) map[0][i] = map[0][i+1]; // 왼쪽
        for(int i = 0; i < top; i++) map[i][C-1] = map[i+1][C-1]; // 위쪽
        for(int i = C - 1; i > 1; i--) map[top][i] = map[top][i-1]; // 오른쪽
        map[top][1] = 0;

        for(int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i+1][0];
        for(int i = 0; i < C - 1; i++) map[R-1][i] = map[R-1][i+1];
        for(int i = R - 1; i > bottom; i--) map[i][C-1] = map[i-1][C-1];
        for(int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i-1]; // 오른쪽
        map[bottom][1] = 0;

//        for(int[] i : map) {
//            for(int j : i)
//                System.out.print(j + " ");
//            System.out.println();
//        }
//        System.out.println();
    }

    public static void spreed(int[][] map1, int[][] map2) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                map2[i][j]  = 0;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {

                if(map1[i][j] != 0) {
                    int promise = 0;

                    for(int k = 0; k < 4; k++) { // 4방향 검사
                        int ii = i + di[k];
                        int jj = j + dj[k];

                        if(ii < 0 || jj < 0 || ii >= R || jj >= C) continue;
                        if(map1[ii][jj] == -1) continue;

                        map2[ii][jj] += map1[i][j] / 5; // 확산
                        promise++; // 확산시킨 수 증가
                    }

                    map2[i][j] += map1[i][j] - (map1[i][j]/5) * promise;
                }

            }
        }

//        for(int[] i : map2) {
//            for(int j : i)
//                System.out.print(j + " ");
//            System.out.println();
//        }
//        System.out.println();
    }
}
