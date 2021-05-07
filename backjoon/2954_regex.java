import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.replaceAll("(a|e|i|o|u)(p{1})(a|e|i|o|u)", "$1");

        System.out.println(s);
    }
}
