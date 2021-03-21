import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if (!list.contains(s))
                list.add(s);
        }

        Collections.sort(list, (x, y) -> {
            if(x.length() == y.length())
                return x.compareTo(y);
            else
                return x.length() - y.length();
        });

        Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
