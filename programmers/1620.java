import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();

            map.put(s, String.valueOf(i));
            map.put(String.valueOf(i), s);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();

            if(map.containsKey(s)) sb.append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
