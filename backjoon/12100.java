import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, answer;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        move(0, 0);

        System.out.println(answer);
    }

    public static void move(int depth, int dir) {
        if (dir == 1) { // 위
            for (int i = 0; i < N; i++) {
                int num = 0; // 합칠 블록
                int index = 0; // 블록이 이동될 위치

                for (int j = 0; j < N; j++) {
                    if (map[j][i] != 0) {
                        if (num == map[j][i]) { // 합치는 경우
                            map[index - 1][i] = num * 2; // index - 1이 합쳐질 위치
                            num = 0; // 합칠 블록 초기화
                            map[j][i] = 0;
                        } else { // 블록의 숫자가 다른 경우
                            num = map[j][i];
                            map[j][i] = 0; // 중간에 빈칸이 존재해서
                            map[index][i] = num; // 위로 밀면서 0으로 초기화
                            index++;
                        }
                    }
                }
            }
        } else if (dir == 2) { // 아래
            for (int i = 0; i < N; i++) {
                int num = 0, index = N - 1;

                for (int j = N - 1; j >= 0; j--) {
                    if (map[j][i] != 0) {
                        if (num == map[j][i]) {
                            map[index + 1][i] = num * 2;
                            num = 0;
                            map[j][i] = 0;
                        } else {
                            num = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = num;
                            index--;
                        }
                    }
                }
            }
        } else if (dir == 3) { // 왼
            for (int i = 0; i < N; i++) {
                int num = 0, index = 0;

                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        if (num == map[i][j]) {
                            map[i][index - 1] = num * 2;
                            num = 0;
                            map[i][j] = 0;
                        } else {
                            num = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = num;
                            index++;
                        }
                    }
                }
            }
        } else if (dir == 4) {
            for (int i = 0; i < N; i++) {
                int num = 0, index = N - 1;

                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        if (num == map[i][j]) {
                            map[i][index + 1] = num * 2;
                            num = 0;
                            map[i][j] = 0;
                        } else {
                            num = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = num;
                            index--;
                        }
                    }
                }
            }
        }

        if (depth == 5) {
            find();
            return;
        }

        for (int i = 1; i <= 4; i++) {
            int[][] temp = new int[N][N];
            for (int j = 0; j < N; j++) temp[j] = map[j].clone();

            move(depth + 1, i);

            for (int j = 0; j < N; j++) map[j] = temp[j].clone();
        }
    }

    public static void find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                answer = Math.max(answer, map[i][j]);
        }
    }
}
