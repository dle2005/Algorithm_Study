import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Map {
        int r;
        int c;

        public Map(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int N, M, result = Integer.MAX_VALUE;
    public static List<Map> house;
    public static List<Map> chicken;
    public static Map[] per;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // N * N 도시
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집 최대

        house = new ArrayList<>(); // 집의 좌표
        chicken = new ArrayList<>(); // 치킨 집의 좌표
        per = new Map[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if(n == 1) // 집인 경우 집의 좌표를 추가
                    house.add(new Map(i, j));
                else if(n == 2) // 치킨집인 경우 치킨 집의 좌표를 추가
                    chicken.add(new Map(i, j));
            }
        }

        visit = new boolean[chicken.size()];

        permutation(0, 0);

        System.out.println(result);
    }

    public static void calculation() {
        int sum = 0; // 최소 거리

        for(Map h : house) {
            int dis = Integer.MAX_VALUE;

            for(Map m : per) {
                int d = Math.abs(h.c - m.c) + Math.abs(h.r - m.r);
                dis = Math.min(dis, d);
            }

            sum += dis;
        }

        result = Math.min(result, sum);
    }

    public static void permutation(int depth, int start) {
        if(depth == M) {
            calculation();
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                per[depth] = chicken.get(i);
                permutation(depth + 1, i+1);
                visit[i] = false;
            }
        }
    }
}
