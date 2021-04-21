import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class CCTV {
        int num;
        int r;
        int c;

        public CCTV(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }

    public static int N, M, result, block_num;
    public static int[][] map;

    public static List<CCTV> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기

        map = new int[N][M];

        for(int i = 0; i < N; i++) { // 사무실 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(0 < map[i][j] && map[i][j] < 6) // CCTV인경우 리스트에 추가
                    list.add(new CCTV(map[i][j], i, j));
                if(map[i][j] == 6) block_num++;
            }
        }

        dfs(0, list.size(), 0);

        System.out.println(N * M - result - block_num);

    }

    public static void dfs(int depth, int count, int start) {
        if(depth == list.size()) { // 모든 CCTV 검사한 후
//            if(result < count) {
//                for (int[] i : map) {
//                    for (int j : i)
//                        System.out.print(j + " ");
//                    System.out.println();
//                }
//                System.out.println(count);
//                System.out.println();
//            }
            result = Math.max(result, count);

            return;
        }

        for(int k = start; k < list.size(); k++) {
            CCTV cctv = list.get(k);

            if(cctv.num == 1) {
                int cnt = up(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                up_back(cctv, depth);

                cnt = down(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                down_back(cctv, depth);

                cnt = left(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                left_back(cctv, depth);

                cnt = right(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                right_back(cctv, depth);
            }

            if(cctv.num == 2) {
                int cnt = up(cctv, depth);
                cnt += down(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                up_back(cctv, depth);
                down_back(cctv, depth);

                cnt = right(cctv, depth);
                cnt += left(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                right_back(cctv, depth);
                left_back(cctv, depth);
            }

            if(cctv.num == 3) {
                int cnt = up(cctv, depth);
                cnt += right(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                up_back(cctv, depth);
                right_back(cctv, depth);

                cnt = right(cctv, depth);
                cnt += down(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                right_back(cctv, depth);
                down_back(cctv, depth);

                cnt = down(cctv, depth);
                cnt += left(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                down_back(cctv, depth);
                left_back(cctv, depth);

                cnt = left(cctv, depth);
                cnt += up(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                left_back(cctv, depth);
                up_back(cctv, depth);
            }

            if(cctv.num == 4) {
                int cnt = left(cctv, depth);
                cnt += up(cctv, depth);
                cnt += right(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                left_back(cctv, depth);
                up_back(cctv, depth);
                right_back(cctv, depth);

                cnt = up(cctv, depth);
                cnt += right(cctv, depth);
                cnt += down(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                up_back(cctv, depth);
                right_back(cctv, depth);
                down_back(cctv, depth);

                cnt = right(cctv, depth);
                cnt += down(cctv, depth);
                cnt += left(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                right_back(cctv, depth);
                down_back(cctv, depth);
                left_back(cctv, depth);

                cnt = down(cctv, depth);
                cnt += left(cctv, depth);
                cnt += up(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                down_back(cctv, depth);
                left_back(cctv, depth);
                up_back(cctv, depth);
            }

            if(cctv.num == 5) {
                int cnt = up(cctv, depth);
                cnt += right(cctv, depth);
                cnt += down(cctv, depth);
                cnt += left(cctv, depth);
                dfs(depth + 1, count + cnt, k + 1);
                up_back(cctv, depth);
                right_back(cctv, depth);
                down_back(cctv, depth);
                left_back(cctv, depth);
            }
        }
    }

    public static int right(CCTV cctv, int depth) {
        int cnt = 0;

        for(int j = cctv.c; j < M; j++) {
            if(map[cctv.r][j] == 0) {
                cnt++;
                map[cctv.r][j] = depth + 7;
            }
            if(map[cctv.r][j] == 6) break;
        }

        return cnt;
    }

    public static void right_back(CCTV cctv, int depth) {
        for(int j = cctv.c; j < M; j++) {
            if(map[cctv.r][j] == depth + 7)
                map[cctv.r][j] = 0;
            if(map[cctv.r][j] == 6) break;
        }
    }

    public static int left(CCTV cctv, int depth) {
        int cnt = 0;

        for(int j = cctv.c; j >= 0; j--) {
            if(map[cctv.r][j] == 0) {
                cnt++;
                map[cctv.r][j] = depth + 7;
            }
            if(map[cctv.r][j] == 6) break;
        }

        return cnt;
    }

    public static void left_back(CCTV cctv, int depth) {
        for(int j = cctv.c; j >= 0; j--) {
            if(map[cctv.r][j] == depth + 7)
                map[cctv.r][j] = 0;
            if(map[cctv.r][j] == 6) break;
        }
    }

    public static int down(CCTV cctv, int depth) {
        int cnt = 0;

        for(int i = cctv.r; i < N; i++) {
            if(map[i][cctv.c] == 0) {
                cnt++;
                map[i][cctv.c] = depth + 7;
            }
            if(map[i][cctv.c] == 6) break;
        }

        return cnt;
    }

    public static void down_back(CCTV cctv, int depth) {
        for(int i = cctv.r; i < N; i++) {
            if(map[i][cctv.c] == depth + 7)
                map[i][cctv.c] = 0;
            if(map[i][cctv.c] == 6) break;
        }
    }

    public static int up(CCTV cctv, int depth) {
        int cnt = 0;

        for(int i = cctv.r; i >= 0; i--) {
            if(map[i][cctv.c] == 0) {
                cnt++;
                map[i][cctv.c] = depth + 7;
            }
            if(map[i][cctv.c] == 6) break;
        }

        return cnt;
    }

    public static void up_back(CCTV cctv, int depth) {
        for(int i  = cctv.r; i >= 0; i--) {
            if(map[i][cctv.c] == depth + 7)
                map[i][cctv.c] = 0;
            if(map[i][cctv.c] == 6) break;
        }
    }
}
