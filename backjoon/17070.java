import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N, count = 0;

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Node(Node node) {
            this.i = node.i;
            this.j = node.j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Node front = new Node(0,0);
        Node back = new Node(0, 1);

        dfs(front, back);

        System.out.println(count);
    }

    public static void dfs(Node front, Node back) {
        Node newFront = new Node(back);
        Node newBack;

        if(back.i == N-1 && back.j == N-1) {
            count++;
            return;
        }

        if(front.i == back.i) { // 가인 경우
//            System.out.println("가로 ");
            newBack = new Node(back.i, back.j+1);
            if(newBack.i < N && newBack.j < N && arr[newBack.i][newBack.j] != 1 )
                dfs(newFront, newBack);

            newBack = new Node(back.i+1, back.j+1);
            if(newBack.i < N && newBack.j < N) {
                if(arr[newBack.i][newBack.j] != 1 && arr[back.i][back.j+1] != 1 && arr[back.i+1][back.j] != 1)
                    dfs(newFront, newBack);
            }
        }
        else if(front.j == back.j) { // 세로인 경우
//            System.out.println("세로 ");
            newBack = new Node(back.i+1, back.j);
            if(newBack.i < N && newBack.j < N && arr[newBack.i][newBack.j] != 1 )
                dfs(newFront, newBack);

            newBack = new Node(back.i+1, back.j+1);
            if(newBack.i < N && newBack.j < N) {
                if(arr[newBack.i][newBack.j] != 1 && arr[back.i][back.j+1] != 1 && arr[back.i+1][back.j] != 1)
                    dfs(newFront, newBack);
            }
        }
        else { // 대각선인 경우
//            System.out.println("대각선 ");
            newBack = new Node(back.i+1, back.j);
            if(newBack.i < N && newBack.j < N && arr[newBack.i][newBack.j] != 1 )
                dfs(newFront, newBack);

            newBack = new Node(back.i, back.j+1);
            if(newBack.i < N && newBack.j < N && arr[newBack.i][newBack.j] != 1 )
                dfs(newFront, newBack);

            newBack = new Node(back.i+1, back.j+1);
            if(newBack.i < N && newBack.j < N) {
                if(arr[newBack.i][newBack.j] != 1 && arr[back.i][back.j+1] != 1 && arr[back.i+1][back.j] != 1)
                    dfs(newFront, newBack);
            }
        }
    }
}
