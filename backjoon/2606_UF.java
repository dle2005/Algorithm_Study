import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(find(i) == 1) answer++;
        }

        System.out.println(answer);
    }

    public static int find(int n) {
        if(n == parent[n]) return n;
        else return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
