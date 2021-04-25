import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] alp = new int[26];

        for(int i = 0; i < s.length(); i++)
            alp[s.charAt(i) - 'a']++;

        for(int c : alp)
            System.out.print(c + " ");
    }
}
