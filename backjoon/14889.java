import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N, f_value, e_value, min = 999999;
    public static int[] NM;
    public static int[][] arr;
    public static List<int[]> list = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        NM = new int[N/2];

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                arr[i][j] = sc.nextInt();
        }

        dfs(0, 1);

        int low = 0, high = list.size()-1;
        while(low < high) {
            int[] front = list.get(low++);
            int[] end = list.get(high--);

            f_value = 0;
            e_value = 0;

            visit = new boolean[N+1];
            NM = new int[2];
            dfs_2(0,0, front);

            visit = new boolean[N+1];
            NM = new int[2];
            dfs_3(0,0, end);

            if(min > Math.abs(f_value - e_value))
                min = Math.abs(f_value - e_value);
        }

        System.out.println(min);

    }

    public static void dfs_3(int depth, int begin, int[] tarr) {
        if(depth == 2) {
            int i = NM[0];
            int j = NM[1];

            e_value += arr[i][j];
            e_value += arr[j][i];

            return;
        }

        for(int i = begin; i < tarr.length; i++) {
            if(!visit[i]) {
                if(depth == 1 && NM[0] > tarr[i]) continue;
                NM[depth] = tarr[i];
                visit[i] = true;
                dfs_3(depth+1, begin+1, tarr);
                visit[i] = false;
            }
        }
    }

    public static void dfs_2(int depth, int begin, int[] tarr) {
        if(depth == 2) {
            int i = NM[0];
            int j = NM[1];
            
            f_value += arr[i][j];
            f_value += arr[j][i];

            return;
        }

        for(int i = begin; i < tarr.length; i++) {
            if(!visit[i]) {
                if(depth == 1 && NM[0] > tarr[i]) continue;
                NM[depth] = tarr[i];
                visit[i] = true;
                dfs_2(depth+1, begin+1, tarr);
                visit[i] = false;
            }
        }
    }

    public static void dfs(int depth, int begin) {
        if(depth == N/2) {
            int[] temp = Arrays.copyOf(NM, NM.length);
            list.add(temp);
            return;
        }

        for(int i = begin; i <= N; i++) {
            if(!visit[i]) {
                NM[depth] = i;
                visit[i] = true;
                dfs(depth+1, i+1);
                visit[i] = false;
            }
        }
    }
}
