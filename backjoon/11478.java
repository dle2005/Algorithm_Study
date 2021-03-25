import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        String s = br.readLine();
        int start = 0, end = 1;

        for(int i = 0; i < s.length(); i++) {
            start = 0;

            for(int j = s.length() - i; j > 0; j--) {
                set.add(s.substring(start, start+end));
                start++;
            }

            end++;
        }

        System.out.println(set.size());
    }
}
