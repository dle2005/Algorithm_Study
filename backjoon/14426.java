import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(br.readLine());

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            for(String t : list) {
                if(t.substring(0, s.length()).equals(s)) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
