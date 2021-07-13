import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') c = '@';

            if (map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
            } else map.put(c, 1);
        }

        for (int i = 0; i < N; i++) {
            char c;

            if (num[i] == '0') {
                c = 32;
            } else if (num[i] <= 26) {
                c = (char) ('A' + num[i] - 1);
            } else {
                c = (char) ('a' + num[i] - 27);
            }

            if (map.containsKey(c)) {
                if (map.get(c) > 1) map.put(c, map.get(c) - 1);
                else map.remove(c);
            }
        }

        System.out.println(map.size() > 0 ? "n" : "y");
    }
}
