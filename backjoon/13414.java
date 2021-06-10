import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();

        while (L-- > 0) {
            String id = br.readLine();

            if (set.contains(id)) set.remove(id);

            set.add(id);
        }

        for (String id : set) {
            if (K-- > 0) sb.append(id).append("\n");
        }

        System.out.println(sb);
    }
}
