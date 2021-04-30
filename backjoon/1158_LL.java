import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // N명의 사람
        int K = Integer.parseInt(st.nextToken()); // K번째 사람 제거

        StringBuilder answer = new StringBuilder("<");

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        int index = 0;
        for (int i = 0; i < N - 1 ; i++) {
            index = (index + K - 1) % list.size();
            answer.append(list.remove(index)).append(", ");
        }
        answer.append(list.remove(0)).append(">");

        System.out.println(answer);
    }
}
